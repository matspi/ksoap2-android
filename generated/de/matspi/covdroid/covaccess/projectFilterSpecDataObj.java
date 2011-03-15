package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class projectFilterSpecDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public projectFilterSpecDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String DESCRIPTIONPATTERN  = "descriptionPattern";

  public static final String NAMEPATTERN  = "namePattern";

  public projectFilterSpecDataObj ( String descriptionPattern,String namePattern ) {
    this(new SoapObject("http://ws.coverity.com/v2", "projectFilterSpecDataObj"));
    addProperty(DESCRIPTIONPATTERN, descriptionPattern);
    addProperty(NAMEPATTERN, namePattern);
 }

  public String getdescriptionPattern() {
    Object tmp = getProperty(DESCRIPTIONPATTERN);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String getnamePattern() {
    Object tmp = getProperty(NAMEPATTERN);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
