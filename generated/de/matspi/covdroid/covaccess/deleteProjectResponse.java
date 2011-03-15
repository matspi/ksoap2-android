package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class deleteProjectResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public deleteProjectResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public deleteProjectResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "deleteProjectResponse"));
 }

 }
