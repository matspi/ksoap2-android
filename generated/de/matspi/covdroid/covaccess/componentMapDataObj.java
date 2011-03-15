package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class componentMapDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public componentMapDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTMAPID  = "componentMapId";

  public static final String COMPONENTPATHRULES  = "componentPathRules";

  public static final String COMPONENTS  = "components";

  public static final String DEFECTRULES  = "defectRules";

  public static final String DESCRIPTION  = "description";

  public componentMapDataObj ( componentMapIdDataObj componentMapId,componentPathRuleDataObj[] componentPathRules,componentDataObj[] _components,componentDefectRuleDataObj[] defectRules,String _description ) {
    this(new SoapObject("http://ws.coverity.com/v2", "componentMapDataObj"));
    addProperty(COMPONENTMAPID, componentMapId);
    addProperty(COMPONENTPATHRULES, componentPathRules);
    addProperty(COMPONENTS, _components);
    addProperty(DEFECTRULES, defectRules);
    addProperty(DESCRIPTION, _description);
 }

  public componentMapIdDataObj getcomponentMapId() {
    Object tmp = getProperty(COMPONENTMAPID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new componentMapIdDataObj((SoapObject)tmp);
    }
    return (componentMapIdDataObj)tmp;
  }
  public componentPathRuleDataObj[] getcomponentPathRules() {
    Object tmp = getProperty(COMPONENTPATHRULES);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(COMPONENTPATHRULES )) {
          SoapObject value = (SoapObject)pi.getValue();
          v.addElement(new componentPathRuleDataObj(value));
       }
     }
     componentPathRuleDataObj[] array  = new componentPathRuleDataObj[v.size()];
     for ( int counter = 0 ; counter < v.size() ; counter++ ) {
       array[counter] = (componentPathRuleDataObj)v.elementAt(counter);
     }
      tmp = array;
    }
    return (componentPathRuleDataObj[])tmp;
  }
  public componentDataObj[] getcomponents() {
    Object tmp = getProperty(COMPONENTS);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(COMPONENTS )) {
          SoapObject value = (SoapObject)pi.getValue();
          v.addElement(new componentDataObj(value));
       }
     }
     componentDataObj[] array  = new componentDataObj[v.size()];
     for ( int counter = 0 ; counter < v.size() ; counter++ ) {
       array[counter] = (componentDataObj)v.elementAt(counter);
     }
      tmp = array;
    }
    return (componentDataObj[])tmp;
  }
  public componentDefectRuleDataObj[] getdefectRules() {
    Object tmp = getProperty(DEFECTRULES);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(DEFECTRULES )) {
          SoapObject value = (SoapObject)pi.getValue();
          v.addElement(new componentDefectRuleDataObj(value));
       }
     }
     componentDefectRuleDataObj[] array  = new componentDefectRuleDataObj[v.size()];
     for ( int counter = 0 ; counter < v.size() ; counter++ ) {
       array[counter] = (componentDefectRuleDataObj)v.elementAt(counter);
     }
      tmp = array;
    }
    return (componentDefectRuleDataObj[])tmp;
  }
  public String getdescription() {
    Object tmp = getProperty(DESCRIPTION);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
