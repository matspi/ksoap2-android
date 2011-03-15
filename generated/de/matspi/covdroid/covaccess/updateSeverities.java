package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateSeverities extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateSeverities(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String SEVERITIES  = "severities";

  public updateSeverities ( String[] _severities ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateSeverities"));
    addProperty(SEVERITIES, _severities);
 }

  public String[] getseverities() {
    Object tmp = getProperty(SEVERITIES);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(SEVERITIES )) {
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
