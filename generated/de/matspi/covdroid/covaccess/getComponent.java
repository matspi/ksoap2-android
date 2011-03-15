package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getComponent extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getComponent(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTMAPFILTER  = "componentMapFilter";

  public getComponent ( componentIdDataObj componentMapFilter ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getComponent"));
    addProperty(COMPONENTMAPFILTER, componentMapFilter);
 }

  public componentIdDataObj getcomponentMapFilter() {
    Object tmp = getProperty(COMPONENTMAPFILTER);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new componentIdDataObj((SoapObject)tmp);
    }
    return (componentIdDataObj)tmp;
  }
 }
