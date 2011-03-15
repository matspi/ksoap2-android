package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateStreamResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateStreamResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public updateStreamResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateStreamResponse"));
 }

 }
