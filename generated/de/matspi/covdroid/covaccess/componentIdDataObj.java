package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class componentIdDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public componentIdDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String NAME  = "name";

  public componentIdDataObj ( String _name ) {
    this(new SoapObject("http://ws.coverity.com/v2", "componentIdDataObj"));
    addProperty(NAME, _name);
 }

  public String getname() {
    Object tmp = getProperty(NAME);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
