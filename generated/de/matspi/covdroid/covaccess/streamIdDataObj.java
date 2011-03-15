package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class streamIdDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public streamIdDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String NAME  = "name";

  public static final String TYPE  = "type";

  public streamIdDataObj ( String _name,String _type ) {
    this(new SoapObject("http://ws.coverity.com/v2", "streamIdDataObj"));
    addProperty(NAME, _name);
    addProperty(TYPE, _type);
 }

  public String getname() {
    Object tmp = getProperty(NAME);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String gettype() {
    Object tmp = getProperty(TYPE);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
