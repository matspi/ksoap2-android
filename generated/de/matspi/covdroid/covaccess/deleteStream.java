package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class deleteStream extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public deleteStream(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String STREAMID  = "streamId";

  public deleteStream ( streamIdDataObj streamId ) {
    this(new SoapObject("http://ws.coverity.com/v2", "deleteStream"));
    addProperty(STREAMID, streamId);
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
 }
