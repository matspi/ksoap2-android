package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class deleteSnapshotResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public deleteSnapshotResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public deleteSnapshotResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "deleteSnapshotResponse"));
 }

 }
