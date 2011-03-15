package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class deleteComponentMap extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public deleteComponentMap(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTMAPID  = "componentMapId";

  public deleteComponentMap ( componentMapIdDataObj componentMapId ) {
    this(new SoapObject("http://ws.coverity.com/v2", "deleteComponentMap"));
    addProperty(COMPONENTMAPID, componentMapId);
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
 }
