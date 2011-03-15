package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class getComponentMapsResponse extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public getComponentMapsResponse(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String RETURN  = "return";

  public getComponentMapsResponse ( componentMapDataObj[] _return ) {
    this(new SoapObject("http://ws.coverity.com/v2", "getComponentMapsResponse"));
    addProperty(RETURN, _return);
 }

  public componentMapDataObj[] getreturn() {
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
          v.addElement(new componentMapDataObj(value));
       }
     }
     componentMapDataObj[] array  = new componentMapDataObj[v.size()];
     for ( int counter = 0 ; counter < v.size() ; counter++ ) {
       array[counter] = (componentMapDataObj)v.elementAt(counter);
     }
      tmp = array;
    }
    return (componentMapDataObj[])tmp;
  }
 }
