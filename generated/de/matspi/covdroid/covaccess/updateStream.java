package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateStream extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateStream(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String STREAMID  = "streamId";

  public static final String STREAMSPEC  = "streamSpec";

  public updateStream ( streamIdDataObj streamId,streamSpecDataObj streamSpec ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateStream"));
    addProperty(STREAMID, streamId);
    addProperty(STREAMSPEC, streamSpec);
 }

  public streamIdDataObj getstreamId() {
    Object tmp = getProperty(STREAMID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new streamIdDataObj((SoapObject)tmp);
    }
    return (streamIdDataObj)tmp;
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
