package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class createProjectResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public createProjectResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public createProjectResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "createProjectResponse"));
 }

 }
