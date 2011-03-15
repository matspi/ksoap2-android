package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateSeveritiesResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateSeveritiesResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public updateSeveritiesResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateSeveritiesResponse"));
 }

 }
