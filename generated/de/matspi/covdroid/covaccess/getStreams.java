package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getStreams extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getStreams(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String FILTERSPEC  = "filterSpec";

  public getStreams ( streamFilterSpecDataObj filterSpec ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getStreams"));
    addProperty(FILTERSPEC, filterSpec);
 }

  public streamFilterSpecDataObj getfilterSpec() {
    Object tmp = getProperty(FILTERSPEC);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new streamFilterSpecDataObj((SoapObject)tmp);
    }
    return (streamFilterSpecDataObj)tmp;
  }
 }
