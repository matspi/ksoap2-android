package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class componentPathRuleDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public componentPathRuleDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTID  = "componentId";

  public static final String PATHPATTERN  = "pathPattern";

  public componentPathRuleDataObj ( componentIdDataObj componentId,String pathPattern ) {
    this(new SoapObject("http://ws.coverity.com/v2", "componentPathRuleDataObj"));
    addProperty(COMPONENTID, componentId);
    addProperty(PATHPATTERN, pathPattern);
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
  public String getpathPattern() {
    Object tmp = getProperty(PATHPATTERN);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
