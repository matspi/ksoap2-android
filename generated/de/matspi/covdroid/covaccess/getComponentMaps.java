package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getComponentMaps extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getComponentMaps(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTMAPID  = "componentMapId";

  public getComponentMaps ( componentMapFilterSpecDataObj componentMapId ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getComponentMaps"));
    addProperty(COMPONENTMAPID, componentMapId);
 }

  public componentMapFilterSpecDataObj getcomponentMapId() {
    Object tmp = getProperty(COMPONENTMAPID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new componentMapFilterSpecDataObj((SoapObject)tmp);
    }
    return (componentMapFilterSpecDataObj)tmp;
  }
 }
