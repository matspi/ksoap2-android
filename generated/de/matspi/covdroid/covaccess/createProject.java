package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class createProject extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public createProject(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String PROJECTSPEC  = "projectSpec";

  public createProject ( projectSpecDataObj projectSpec ) {
    this(new SoapObject("http://ws.coverity.com/v2", "createProject"));
    addProperty(PROJECTSPEC, projectSpec);
 }

  public projectSpecDataObj getprojectSpec() {
    Object tmp = getProperty(PROJECTSPEC);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new projectSpecDataObj((SoapObject)tmp);
    }
    return (projectSpecDataObj)tmp;
  }
 }
