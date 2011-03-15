package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateProject extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateProject(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String PROJECTID  = "projectId";

  public static final String PROJECTSPEC  = "projectSpec";

  public updateProject ( projectIdDataObj projectId,projectSpecDataObj projectSpec ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateProject"));
    addProperty(PROJECTID, projectId);
    addProperty(PROJECTSPEC, projectSpec);
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
