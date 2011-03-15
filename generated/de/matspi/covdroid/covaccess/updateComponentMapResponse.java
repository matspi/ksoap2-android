package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateComponentMapResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateComponentMapResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public updateComponentMapResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateComponentMapResponse"));
 }

 }
