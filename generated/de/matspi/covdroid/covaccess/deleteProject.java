package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class deleteProject extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public deleteProject(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String PROJECTID  = "projectId";

  public deleteProject ( projectIdDataObj projectId ) {
    this(new SoapObject("http://ws.coverity.com/v2", "deleteProject"));
    addProperty(PROJECTID, projectId);
 }

  public projectIdDataObj getprojectId() {
    Object tmp = getProperty(PROJECTID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new projectIdDataObj((SoapObject)tmp);
    }
    return (projectIdDataObj)tmp;
  }
 }
