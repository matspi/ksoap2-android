package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class createComponentMap extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public createComponentMap(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTMAPSPEC  = "componentMapSpec";

  public createComponentMap ( componentMapSpecDataObj componentMapSpec ) {
    this(new SoapObject("http://ws.coverity.com/v2", "createComponentMap"));
    addProperty(COMPONENTMAPSPEC, componentMapSpec);
 }

  public componentMapSpecDataObj getcomponentMapSpec() {
    Object tmp = getProperty(COMPONENTMAPSPEC);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new componentMapSpecDataObj((SoapObject)tmp);
    }
    return (componentMapSpecDataObj)tmp;
  }
 }
