package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getDefectStatuses extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getDefectStatuses(SoapObject soapObject) {
    super(soapObject);
  }
  public getDefectStatuses (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getDefectStatuses"));
 }

 }
