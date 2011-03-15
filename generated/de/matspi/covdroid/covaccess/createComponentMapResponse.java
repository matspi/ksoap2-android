package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class createComponentMapResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public createComponentMapResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public createComponentMapResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "createComponentMapResponse"));
 }

 }
