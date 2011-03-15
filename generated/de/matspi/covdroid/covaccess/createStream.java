package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class createStream extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public createStream(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String STREAMSPEC  = "streamSpec";

  public createStream ( streamSpecDataObj streamSpec ) {
    this(new SoapObject("http://ws.coverity.com/v2", "createStream"));
    addProperty(STREAMSPEC, streamSpec);
 }

  public streamSpecDataObj getstreamSpec() {
    Object tmp = getProperty(STREAMSPEC);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new streamSpecDataObj((SoapObject)tmp);
    }
    return (streamSpecDataObj)tmp;
  }
 }
