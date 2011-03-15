package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class deleteSnapshot extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public deleteSnapshot(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String SNAPSHOTID  = "snapshotId";

  public deleteSnapshot ( snapshotIdDataObj snapshotId ) {
    this(new SoapObject("http://ws.coverity.com/v2", "deleteSnapshot"));
    addProperty(SNAPSHOTID, snapshotId);
 }

  public snapshotIdDataObj getsnapshotId() {
    Object tmp = getProperty(SNAPSHOTID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new snapshotIdDataObj((SoapObject)tmp);
    }
    return (snapshotIdDataObj)tmp;
  }
 }
