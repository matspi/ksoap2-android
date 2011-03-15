package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateProjectResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateProjectResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public updateProjectResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateProjectResponse"));
 }

 }
