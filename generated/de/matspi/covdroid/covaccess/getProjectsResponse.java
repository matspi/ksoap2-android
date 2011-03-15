package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getProjectsResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getProjectsResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String RETURN  = "return";

  public getProjectsResponse ( projectDataObj[] _return ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getProjectsResponse"));
    addProperty(RETURN, _return);
 }

  public projectDataObj[] getreturn() {
    Object tmp = getProperty(RETURN);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(RETURN )) {
          SoapObject value = (SoapObject)pi.getValue();
          v.addElement(new projectDataObj(value));
       }
     }
     projectDataObj[] array  = new projectDataObj[v.size()];
     for ( int counter = 0 ; counter < v.size() ; counter++ ) {
       array[counter] = (projectDataObj)v.elementAt(counter);
     }
      tmp = array;
    }
    return (projectDataObj[])tmp;
  }
 }
