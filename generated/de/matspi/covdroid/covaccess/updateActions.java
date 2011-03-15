package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class updateActions extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public updateActions(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String ACTIONS  = "actions";

  public updateActions ( String[] _actions ) {
    this(new SoapObject("http://ws.coverity.com/v2", "updateActions"));
    addProperty(ACTIONS, _actions);
 }

  public String[] getactions() {
    Object tmp = getProperty(ACTIONS);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(ACTIONS )) {
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
