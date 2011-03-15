package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateComponentMap extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateComponentMap(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTMAPFILTER  = "componentMapFilter";

  public static final String COMPONENTMAPSPEC  = "componentMapSpec";

  public updateComponentMap ( componentMapIdDataObj componentMapFilter,componentMapSpecDataObj componentMapSpec ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateComponentMap"));
    addProperty(COMPONENTMAPFILTER, componentMapFilter);
    addProperty(COMPONENTMAPSPEC, componentMapSpec);
 }

  public componentMapIdDataObj getcomponentMapFilter() {
    Object tmp = getProperty(COMPONENTMAPFILTER);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new componentMapIdDataObj((SoapObject)tmp);
    }
    return (componentMapIdDataObj)tmp;
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
