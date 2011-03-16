/*
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ksoap2.wsdl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.apache.axis.wsdl.gen.Generator;
import org.apache.axis.wsdl.symbolTable.ContainedAttribute;
import org.apache.axis.wsdl.symbolTable.DefinedType;
import org.apache.axis.wsdl.symbolTable.ElementDecl;
import org.apache.axis.wsdl.symbolTable.SymbolTable;
import org.apache.axis.wsdl.symbolTable.TypeEntry;
import org.apache.axis.wsdl.toJava.Emitter;

/**
 * This generator creates types for KSoap
 */
public class KSoapTypeGenerator implements Generator {
  
  /** The emitter that we were created for. */
  protected Emitter emitter;
  
  /** The type description. */
  protected TypeEntry type;
  
  /** The symbolTable. */
  protected SymbolTable symbolTable;
  
  /**
   * Constructor.
   * 
   * @param emitter     
   * @param type        
   * @param symbolTable 
   */
  public KSoapTypeGenerator(Emitter emitter, TypeEntry type, SymbolTable symbolTable) {
    this.emitter = emitter;
    this.type = type;
    this.symbolTable = symbolTable;
  }
   /**
     * Do a whole lot of nothing.
     * 
     * @throws IOException 
     */
  public void generate() throws IOException {
    //System.out.println ("Generating type...");
    String className = type.getQName().getLocalPart();
    // I don't (yet) have a good way to distinguish the types I care about
    // here's A way.
    while ( className.startsWith(">") && className.length() > 0) {
      className = className.substring(1);
    }
    if ( className.indexOf(']') >= 0 || className.length() == 0 ) {  // don't currently do arrays... (and the length should never be zero)
      System.out.println ("array className " + className);
      return;
    }
    if ( className.indexOf("Action") >= 0 ) {
      System.out.println ("className " + className);
    }
    
    if ( className.indexOf(">") >= 0  ) {
      className = className.replace('>', '_');
    }
    String nodeType = type.getNode().getLocalName();
    if ( nodeType.indexOf("simpleType") < 0 && !className.startsWith("ArrayOf") && !className.endsWith("[0,unbounded]") && !className.endsWith("wrapped")) {
      String packageName = emitter.getPackageName();
      if ( packageName != null ) {
        packageName = packageName.replace('.', File.separatorChar); 
        packageName += File.separatorChar;
      }
      else {
        packageName = "";
      }
      String fileName = null;
      if ( emitter.getOutputDir() != null ) {
        fileName = emitter.getOutputDir() + File.separatorChar + packageName + className + ".java";
      }
      else {
        fileName = packageName + className + ".java";
      }
      File f = new File(fileName).getParentFile();
      f.mkdirs();
      FileOutputStream fos = new FileOutputStream (fileName);
      if ( packageName != null ) {
        fos.write(("package " + emitter.getPackageName() + ";\n\n").getBytes());
      }
      fos.write(("import org.ksoap2.serialization.*;\n").getBytes());
      fos.write(("import org.ksoap2.wsdl.*;\n\n").getBytes());
      //fos.write(("import java.util.*;\n\n").getBytes());
      
      fos.write(("public class " + className + " extends SoapObjectWrapper {\n").getBytes());
      fos.write(("\n      public static final String NAMESPACE = \"" + type.getQName().getNamespaceURI() + "\";\n").getBytes());
      Vector attributes = type.getContainedAttributes();
      if ( attributes == null && type.getRefType() != null ) {
        attributes = type.getRefType().getContainedAttributes();
      }
      StringBuffer constructor = new StringBuffer();
      StringBuffer constructorName = new StringBuffer();
      StringBuffer getMethods = new StringBuffer();
      fos.write(("    public " + className + "(SoapObject soapObject) {\n    super(soapObject);\n  }\n").getBytes());
      constructor.append("    this(new SoapObject(\"" + type.getQName().getNamespaceURI() + "\", \"" + className + "\"));\n" );
      constructorName.append ("public " + className + " ( ");
      if ( attributes != null ) {
        for ( int counter = 0 ; counter < attributes.size() ; counter++ ) {
          ContainedAttribute attribute = (ContainedAttribute)attributes.elementAt(counter);
          String attributeName = typeToJavaName(attribute.getQName().getLocalPart());
          attributeName = attributeName.substring(className.length()+1);
          fos.write(( "  public static final String " + attributeName.toUpperCase() + "  = \"" + attributeName + "\";\n\n").getBytes());
          if ( type.getBaseType() == null ) {
            //String attributeInitializer = getAttributeInitializer(attributeName, attribute.getType().getQName().getLocalPart());
            // the to lower case is not cosmetic, we must avoid a naming conflict with the 
            // all upper case static generated above.  We could just lower case the 
            // first character, but laziness currently prevails
            constructor.append("    addAttribute(" + attributeName.toUpperCase() + ", " + getValidJavaIdentifier(attributeName) + ");\n");
          }
          else {
            System.out.println("Some Type");
          }
          if ( counter != 0 ) {
            constructorName.append(",");
          }
          constructorName.append(getAttributeClassName(attributeName, attribute.getType().getQName().getLocalPart()));
          constructorName.append(" ");
          // the to lower case is not cosmetic, we must avoid a naming conflict with the 
          // all upper case static generated above
          constructorName.append(getValidJavaIdentifier(attributeName));  
          getMethods.append (getMethod(attributeName, attribute.getType().getQName().getLocalPart()));
          //System.out.println ( "      Attribute: " + attribute.getQName().getLocalPart());
        }
      }
      
      Vector sequences = type.getContainedElements();
      if ( sequences != null ) {
        for ( int counter = 0 ; counter < sequences.size() ; counter++ ) {
          ElementDecl sequence = (ElementDecl)sequences.elementAt(counter);
          String sequenceName = typeToJavaName(sequence.getQName().getLocalPart());
          if ( sequenceName.startsWith(className)) { // I suspect that this is an unworkable hack
            sequenceName = sequenceName.substring(className.length()+1);
            fos.write(( "  public static final String " + sequenceName.toUpperCase() + "  = \"" + sequenceName + "\";\n\n").getBytes());
            if ( type.getBaseType() == null ) {
              //String attributeInitializer = getAttributeInitializer(sequenceName, sequence.getType().getQName().getLocalPart());
              // the to lower case is not cosmetic, we must avoid a naming conflict with the 
              // all upper case static generated above.  We could just lower case the 
              // first character, but laziness currently prevails
              constructor.append("    addProperty(" + sequenceName.toUpperCase() + ", " + getValidJavaIdentifier(sequenceName) + ");\n");
            }
            else {
              System.out.println("Some Type");
            }
            if ( counter != 0 || (attributes != null && attributes.size() != 0) ) {
              constructorName.append(",");
            }
            constructorName.append(getAttributeClassName(sequenceName, sequence.getType().getQName().getLocalPart()));
            constructorName.append(" ");
            // the to lower case is not cosmetic, we must avoid a naming conflict with the 
            // all upper case static generated above
            constructorName.append(getValidJavaIdentifier(sequenceName));
            getMethods.append (getMethod(true, sequenceName, sequence.getType().getQName().getLocalPart()));
            //System.out.println ( "      Attribute: " + attribute.getQName().getLocalPart());
          }
        }
      }
      fos.write(("  " + constructorName.toString() + " ) {\n").getBytes());
      fos.write((constructor.toString()).getBytes());
      fos.write( " }\n".getBytes());
      fos.write((getMethods.toString()).getBytes());
      fos.write( "\n }\n".getBytes());  // end of class
    }
  }    // generate
  
  /** Returns a valid Java Identifier that will not be all upper case.   The need to lower case
   * avoids a conflict with generated "statics" which are all upper case.   The name must be 
   * non-null and length > 0.  The name is NOT checked for illegal characters.
   */
  public String getValidJavaIdentifier ( String attributeName ) {
    char firstCharacter = Character.toLowerCase(attributeName.charAt(0));
    if ( attributeName.length() > 1 ) {
      attributeName = firstCharacter + attributeName.substring(1);
      if ( attributeName.toLowerCase().equals(attributeName)) {
        // the name is all LowerCase.  Since all Java reserved keywords are lower case, we'll prepend an _
        // to make sure that there is no possible conflict
        attributeName = "_" + attributeName;
      }
    }
    else {
      attributeName = "_" + firstCharacter + "_";
    }
    return attributeName;
  }
  
  /** Returns an initializer string for the given attribut name and type. */
  protected String getAttributeInitializer(String attributeName, String typeName) {
    if ( typeName.equals("int")|| typeName.equals("unsignedByte")) {
      return "new Integer(" +attributeName+")";
    }
    else if ( typeName.equals("boolean")) {
      return "new Boolean(" +attributeName+")";
    }
    else if ( typeName.equals("float") || typeName.equals("double") ) {
      return "new Double(" +attributeName+")";
    }
    else if ( typeName.equals("dateTime") ) {
      return attributeName;
    }
    else {
      return attributeName;
    }
  }
  
  /** Returns an initializer string for the given attribut name and type. */
  protected String getAttributeClassName(String attributeName, String typeName) {
    lastAttributeWasSimple = true;
    int arrayOpener = typeName.indexOf('[');
    String postPend = "";
    if ( arrayOpener >= 0  ) {
      typeName = typeName.substring(0, arrayOpener);
      postPend = "[]";
    }
    String lcTypeName = typeName.toLowerCase();
    if ( lcTypeName.startsWith("unsigned")) {
      typeName = typeName.substring("unsigned".length());
    }
    if ( lcTypeName.startsWith("positive")) {
      typeName = typeName.substring("positive".length());
    }
    if ( lcTypeName.startsWith("nonnegative")) {
      typeName = typeName.substring("nonnegative".length());
    }
    if ( lcTypeName.startsWith("nonpositive")) {
      typeName = typeName.substring("nonpositive".length());
    }
    lcTypeName = typeName.toLowerCase();   // just in case it changed...
    if ( lcTypeName.equals("int") || lcTypeName.equals("integer") || lcTypeName.equals("byte") || lcTypeName.equals("short")) {
      return "Integer" + postPend;
    }
    if ( lcTypeName.equals("long") ) {
      return "Long" + postPend;
    }
    else if ( lcTypeName.equals("string") || lcTypeName.equals("qname") || lcTypeName.equals("anytype") ) {
      return "String" + postPend;
    }
    else if ( lcTypeName.equals("boolean")) {
      return "Boolean" + postPend;
    }
    else if ( lcTypeName.equals("float") || lcTypeName.equals("double") || typeName.equals("decimal") ) {
      return "Double" + postPend;
    }
    else if ( lcTypeName.equals("datetime") ) {
      return "java.util.Date" + postPend;
    }
    else {
      if ( typeName.indexOf("Condition") >= 0 ) {
        System.out.println ("Stop Here");
      }
      Object definedType = symbolTable.getType(new QName(type.getQName().getNamespaceURI(),typeName));
      if ( definedType != null && definedType instanceof DefinedType ) {
        try {
          String nodeType = ((DefinedType)definedType).getNode().getLocalName();
          if ( nodeType.indexOf("simpleType") >= 0 ) {
            return "String" + postPend;
          }
        } catch ( Exception any ) {
          // ignore
        }
        lastAttributeWasSimple = false;
        if ( ((DefinedType)definedType).isSimpleType() ) {
          if ( ((DefinedType)definedType).getBaseType() != null ) {
            return typeToJavaName((String)(((DefinedType)definedType).getBaseType()));
          }
          else {
            return typeToJavaName(typeName) + postPend;
            // getAttributeClassName(((DefinedType)definedType).);
          }
        }
        else {
          return typeToJavaName(typeName) + postPend;
        }
      }
      else {  // if all else fails
        return "String" + postPend;  // this is just plain WRONG (but it works for me).
      }
    }
  }
  /**
   * @param typeName
   * @return
   */
  protected String typeToJavaName(String typeName) {
     while ( typeName.startsWith(">") && typeName.length() > 0) {
       typeName = typeName.substring(1);
    }
    if ( typeName.length() == 0 ) {  // should never be....
      return "Object";
    }
    if ( typeName.indexOf(">") >= 0  ) {  // "inner class"
      typeName = typeName.replace('>', '_');
    }
    return typeName;
  }
  
  /** Totally not thread safe, but describes the outcome of the last call to getAttributeTypeName. *
   * 
   */
  protected boolean lastAttributeWasSimple;
  
  /** Returns the string that represents the simple type. */
  protected String getAttributeTypeName(String attributeName, String typeName) {
    lastAttributeWasSimple = true;
    int arrayOpener = typeName.indexOf('[');
    String postPend = "";
    if ( arrayOpener >= 0  ) {
      typeName = typeName.substring(0, arrayOpener);
      postPend = "[]";
    }
    String lcTypeName = typeName.toLowerCase();
    if ( lcTypeName.startsWith("unsigned")) {
      typeName = typeName.substring("unsigned".length());
    }
    if ( lcTypeName.startsWith("positive")) {
      typeName = typeName.substring("positive".length());
    }
    if ( lcTypeName.startsWith("nonnegative")) {
      typeName = typeName.substring("nonnegative".length());
    }
    if ( lcTypeName.startsWith("nonpositive")) {
      typeName = typeName.substring("nonpositive".length());
    }
    lcTypeName = typeName.toLowerCase();   // just in case it changed...
    if ( lcTypeName.equals("string") || lcTypeName.equals("qname")) {
      return "String" + postPend;
    }
    else if ( lcTypeName.equals("int") ||  lcTypeName.equals("integer") || lcTypeName.equals("byte") || lcTypeName.equals("short")) {
      return "int" + postPend;
    }
    else if ( lcTypeName.equals("long") ) {
      return "long" + postPend;
    }
    else if ( lcTypeName.equals("boolean")) {
      return typeName + postPend;
    }
    else if ( lcTypeName.equals("float") || typeName.equals("double") || typeName.equals("decimal") ) {
      return typeName + postPend;
    }
    else if ( lcTypeName.equals("dateTime") ) {
       return "java.util.Date" + postPend;
    }
    else {
      lastAttributeWasSimple = false;
      Object definedType = symbolTable.getType(new QName(type.getQName().getNamespaceURI(),typeName));
      if ( definedType != null && definedType instanceof DefinedType ) {
        if ( ((DefinedType)definedType).isSimpleType() ) {
          if ( ((DefinedType)definedType).getBaseType() != null ) {
            return (String)(((DefinedType)definedType).getBaseType());
          }
          else {
            return typeToJavaName(typeName);   // the node has the real type, but it's too hard to get at
            // getAttributeClassName(((DefinedType)definedType).);
          }
        }
        else {
          return typeName + postPend;
        }
      }
      else {  // if all else fails
        return typeToJavaName(typeName) + postPend;  // this is just plain WRONG (but it works for me).
      }
    }
  }
  
  /** Return a string appropriate for a get method. */
  protected String getMethod (String attributeName, String typeName) {
    return getMethod (false, attributeName, typeName);
  }
    
  /** Return a string appropriate for a get method. */
  protected String getMethod (boolean isProperty, String attributeName, String typeName) {
    StringBuffer sb = new StringBuffer();
    sb.append("\n  public ");
    //sb.append(getAttributeTypeName(attributeName, typeName));
    String attributeClassName = getAttributeClassName(attributeName, typeName);
    sb.append(attributeClassName);
    if ( typeName.equals("boolean")) {
      sb.append(" is" + attributeName);
    }
    else {
      sb.append(" get" + attributeName);
    }
    sb.append("() {\n");
    if ( isProperty ) {
      sb.append("    Object tmp = getProperty(");
    }
    else {
      sb.append("    Object tmp = getAttribute(");
    }
    sb.append(attributeName.toUpperCase());
    sb.append(");\n");
    
    sb.append("    if ( tmp == null ) {\n       return null;\n    }\n");
    if ( attributeClassName.equals("java.util.Date")) {
      // handle date conversion from String - this is necessary for attributes.
      sb.append("    if ( tmp instanceof String ) {\n");
      sb.append("      tmp = org.kobjects.isodate.IsoDate.stringToDate((String)tmp, org.kobjects.isodate.IsoDate.DATE_TIME);\n");
      if ( isProperty ) {
        sb.append("    addProperty (" + attributeName.toUpperCase() + ", tmp);\n");
      }
      else {
        sb.append("    addAttribute (" + attributeName.toUpperCase() + ", tmp);\n");
      }
      sb.append("    }\n");
    }
    if ( !lastAttributeWasSimple || attributeClassName.endsWith("[]")) {  //&& !(attributeClassName.equals("String"))) {
      sb.append("    if ( tmp instanceof SoapObject ) {\n");
      if ( attributeClassName.endsWith("[]" )) {
        String rawClassName = attributeClassName.substring(0, attributeClassName.length()-2);
        //sb.append("      tmp  = new " + attributeClassName + "{ new " + attributeClassName.substring(0, attributeClassName.length()-2) + "((SoapObject)tmp)};\n");
        sb.append("     java.util.Vector v = new java.util.Vector(3);\n");
        sb.append("     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {\n");
        sb.append("        PropertyInfo pi = new PropertyInfo();\n");
        sb.append("        soapObject.getPropertyInfo(counter, pi);\n");
        sb.append("        if ( pi.getName().equals(" + attributeName.toUpperCase() + " )) {\n");
        if (lastAttributeWasSimple) {
          sb.append("          v.addElement(pi.getValue());\n");
        }
        else {
          sb.append("          SoapObject value = (SoapObject)pi.getValue();\n");
          sb.append("          v.addElement(new " + rawClassName + "(value));\n");
        }
        sb.append("       }\n");
        sb.append("     }\n");
        sb.append("     " + rawClassName + "[] array  = new " + rawClassName + "[v.size()];\n");
        sb.append("     for ( int counter = 0 ; counter < v.size() ; counter++ ) {\n");
        sb.append("       array[counter] = (" + rawClassName + ")v.elementAt(counter);\n");
        sb.append("     }\n");
        sb.append("      tmp = array;\n");
      }
      else {
        sb.append("      tmp = new ");
        sb.append(attributeClassName);
        sb.append("((SoapObject)tmp);\n");
      }
      // can't optimize by saving the new SoapObject unless we remove all the non-Soap Objects (or something similar)
      // for now, we'll just ignore the optimization and recalulate the array each time it's requests.
//      if ( isProperty ) {
//        sb.append("      addProperty (" + attributeName.toUpperCase() + ", tmp);\n");
//      }
//      else {
//        sb.append("      addAttribute (" + attributeName.toUpperCase() + ", tmp);\n");
//      }
      sb.append("    }\n");
    }
    if ( attributeClassName.endsWith("[]" ) || !lastAttributeWasSimple || "java.util.Date".equals(attributeClassName)) {
      sb.append("    return (");
      sb.append(attributeClassName);
      sb.append(")tmp;\n  }");
    }
    else {
      if ( attributeClassName.equals("String")) {
        sb.append("    return ((");
        sb.append(attributeClassName);
        sb.append(")tmp");
        sb.append(".toString());\n  }");
      }
      else {
        //return Integer.valueOf(tmp.toString());
        sb.append("    return ");
        sb.append(attributeClassName);
        sb.append(".valueOf(tmp.toString());\n  }");
      }
    }
    return sb.toString();
  }
}    // class NoopGenerator
