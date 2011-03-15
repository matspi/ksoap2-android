package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getSnapshotsForStream extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getSnapshotsForStream(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String STREAMID  = "streamId";

  public static final String FILTERSPEC  = "filterSpec";

  public getSnapshotsForStream ( streamIdDataObj streamId,snapshotFilterSpecDataObj filterSpec ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getSnapshotsForStream"));
    addProperty(STREAMID, streamId);
    addProperty(FILTERSPEC, filterSpec);
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
  public snapshotFilterSpecDataObj getfilterSpec() {
    Object tmp = getProperty(FILTERSPEC);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new snapshotFilterSpecDataObj((SoapObject)tmp);
    }
    return (snapshotFilterSpecDataObj)tmp;
  }
 }
