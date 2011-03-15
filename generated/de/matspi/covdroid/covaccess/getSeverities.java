package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getSeverities extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getSeverities(SoapObject soapObject) {
    super(soapObject);
  }
  public getSeverities (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getSeverities"));
 }

 }
