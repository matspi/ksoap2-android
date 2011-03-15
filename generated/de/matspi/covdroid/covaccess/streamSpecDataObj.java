package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class streamSpecDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public streamSpecDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTMAPID  = "componentMapId";

  public static final String DESCRIPTION  = "description";

  public static final String LANGUAGE  = "language";

  public static final String NAME  = "name";

  public static final String TYPE  = "type";

  public streamSpecDataObj ( componentMapIdDataObj componentMapId,String _description,String _language,String _name,String _type ) {
    this(new SoapObject("http://ws.coverity.com/v2", "streamSpecDataObj"));
    addProperty(COMPONENTMAPID, componentMapId);
    addProperty(DESCRIPTION, _description);
    addProperty(LANGUAGE, _language);
    addProperty(NAME, _name);
    addProperty(TYPE, _type);
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
  public String getdescription() {
    Object tmp = getProperty(DESCRIPTION);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String getlanguage() {
    Object tmp = getProperty(LANGUAGE);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String getname() {
    Object tmp = getProperty(NAME);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String gettype() {
    Object tmp = getProperty(TYPE);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
