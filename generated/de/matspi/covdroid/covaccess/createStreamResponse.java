package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class createStreamResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public createStreamResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public createStreamResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "createStreamResponse"));
 }

 }
