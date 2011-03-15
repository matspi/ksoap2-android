package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getProjects extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getProjects(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String FILTERSPEC  = "filterSpec";

  public getProjects ( projectFilterSpecDataObj filterSpec ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getProjects"));
    addProperty(FILTERSPEC, filterSpec);
 }

  public projectFilterSpecDataObj getfilterSpec() {
    Object tmp = getProperty(FILTERSPEC);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new projectFilterSpecDataObj((SoapObject)tmp);
    }
    return (projectFilterSpecDataObj)tmp;
  }
 }
