package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class streamDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public streamDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTMAPID  = "componentMapId";

  public static final String DESCRIPTION  = "description";

  public static final String ID  = "id";

  public static final String LANGUAGE  = "language";

  public streamDataObj ( componentMapIdDataObj componentMapId,String _description,streamIdDataObj _id,String _language ) {
    this(new SoapObject("http://ws.coverity.com/v2", "streamDataObj"));
    addProperty(COMPONENTMAPID, componentMapId);
    addProperty(DESCRIPTION, _description);
    addProperty(ID, _id);
    addProperty(LANGUAGE, _language);
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
  public streamIdDataObj getid() {
    Object tmp = getProperty(ID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new streamIdDataObj((SoapObject)tmp);
    }
    return (streamIdDataObj)tmp;
  }
  public String getlanguage() {
    Object tmp = getProperty(LANGUAGE);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
