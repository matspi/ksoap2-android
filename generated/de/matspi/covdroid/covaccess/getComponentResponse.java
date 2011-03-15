package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getComponentResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getComponentResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String RETURN  = "return";

  public getComponentResponse ( componentDataObj _return ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getComponentResponse"));
    addProperty(RETURN, _return);
 }

  public componentDataObj getreturn() {
    Object tmp = getProperty(RETURN);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new componentDataObj((SoapObject)tmp);
    }
    return (componentDataObj)tmp;
  }
 }
