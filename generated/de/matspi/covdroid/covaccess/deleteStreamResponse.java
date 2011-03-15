package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class deleteStreamResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public deleteStreamResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public deleteStreamResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "deleteStreamResponse"));
 }

 }
