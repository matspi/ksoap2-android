package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getClassificationsResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getClassificationsResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String RETURN  = "return";

  public getClassificationsResponse ( String[] _return ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getClassificationsResponse"));
    addProperty(RETURN, _return);
 }

  public String[] getreturn() {
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
          v.addElement(pi.getValue());
       }
     }
     String[] array  = new String[v.size()];
     for ( int counter = 0 ; counter < v.size() ; counter++ ) {
       array[counter] = (String)v.elementAt(counter);
     }
      tmp = array;
    }
    return (String[])tmp;
  }
 }
