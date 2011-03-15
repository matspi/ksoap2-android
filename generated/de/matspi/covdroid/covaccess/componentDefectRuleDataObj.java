package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class componentDefectRuleDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public componentDefectRuleDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTID  = "componentId";

  public static final String DEFAULTOWNER  = "defaultOwner";

  public componentDefectRuleDataObj ( componentIdDataObj componentId,String defaultOwner ) {
    this(new SoapObject("http://ws.coverity.com/v2", "componentDefectRuleDataObj"));
    addProperty(COMPONENTID, componentId);
    addProperty(DEFAULTOWNER, defaultOwner);
 }

  public componentIdDataObj getcomponentId() {
    Object tmp = getProperty(COMPONENTID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new componentIdDataObj((SoapObject)tmp);
    }
    return (componentIdDataObj)tmp;
  }
  public String getdefaultOwner() {
    Object tmp = getProperty(DEFAULTOWNER);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
