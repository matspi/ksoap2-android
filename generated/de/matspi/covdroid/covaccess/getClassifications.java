package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getClassifications extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getClassifications(SoapObject soapObject) {
    super(soapObject);
  }
  public getClassifications (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getClassifications"));
 }

 }
