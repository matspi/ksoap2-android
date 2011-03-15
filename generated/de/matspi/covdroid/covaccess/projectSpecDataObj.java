package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class projectSpecDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public projectSpecDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String STREAMS  = "streams";

  public static final String DEFAULTTRIAGESCOPE  = "defaultTriageScope";

  public static final String DESCRIPTION  = "description";

  public static final String NAME  = "name";

  public projectSpecDataObj ( streamSpecDataObj[] _streams,String defaultTriageScope,String _description,String _name ) {
    this(new SoapObject("http://ws.coverity.com/v2", "projectSpecDataObj"));
    addProperty(STREAMS, _streams);
    addProperty(DEFAULTTRIAGESCOPE, defaultTriageScope);
    addProperty(DESCRIPTION, _description);
    addProperty(NAME, _name);
 }

  public streamSpecDataObj[] getstreams() {
    Object tmp = getProperty(STREAMS);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(STREAMS )) {
          SoapObject value = (SoapObject)pi.getValue();
          v.addElement(new streamSpecDataObj(value));
       }
     }
     streamSpecDataObj[] array  = new streamSpecDataObj[v.size()];
     for ( int counter = 0 ; counter < v.size() ; counter++ ) {
       array[counter] = (streamSpecDataObj)v.elementAt(counter);
     }
      tmp = array;
    }
    return (streamSpecDataObj[])tmp;
  }
  public String getdefaultTriageScope() {
    Object tmp = getProperty(DEFAULTTRIAGESCOPE);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String getdescription() {
    Object tmp = getProperty(DESCRIPTION);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String getname() {
    Object tmp = getProperty(NAME);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
