package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class streamFilterSpecDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public streamFilterSpecDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String LANGUAGELIST  = "languageList";

  public static final String TYPELIST  = "typeList";

  public static final String DESCRIPTIONPATTERN  = "descriptionPattern";

  public static final String NAMEPATTERN  = "namePattern";

  public streamFilterSpecDataObj ( String[] languageList,String[] typeList,String descriptionPattern,String namePattern ) {
    this(new SoapObject("http://ws.coverity.com/v2", "streamFilterSpecDataObj"));
    addProperty(LANGUAGELIST, languageList);
    addProperty(TYPELIST, typeList);
    addProperty(DESCRIPTIONPATTERN, descriptionPattern);
    addProperty(NAMEPATTERN, namePattern);
 }

  public String[] getlanguageList() {
    Object tmp = getProperty(LANGUAGELIST);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(LANGUAGELIST )) {
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
  public String[] gettypeList() {
    Object tmp = getProperty(TYPELIST);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(TYPELIST )) {
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
