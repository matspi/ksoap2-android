package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class componentMapFilterSpecDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public componentMapFilterSpecDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String NAMEPATTERN  = "namePattern";

  public componentMapFilterSpecDataObj ( String namePattern ) {
    this(new SoapObject("http://ws.coverity.com/v2", "componentMapFilterSpecDataObj"));
    addProperty(NAMEPATTERN, namePattern);
 }

  public String getnamePattern() {
    Object tmp = getProperty(NAMEPATTERN);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
