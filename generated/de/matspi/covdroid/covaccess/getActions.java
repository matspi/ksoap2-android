package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getActions extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getActions(SoapObject soapObject) {
    super(soapObject);
  }
  public getActions (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getActions"));
 }

 }
