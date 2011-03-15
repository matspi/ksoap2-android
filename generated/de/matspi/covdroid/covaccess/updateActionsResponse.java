package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateActionsResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateActionsResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public updateActionsResponse (  ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateActionsResponse"));
 }

 }
