package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class deleteComponentMapResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public deleteComponentMapResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public deleteComponentMapResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "deleteComponentMapResponse"));
 }

 }
