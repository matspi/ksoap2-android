package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class snapshotFilterSpecDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public snapshotFilterSpecDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String DESCRIPTIONPATTERN  = "descriptionPattern";

  public static final String ENDDATE  = "endDate";

  public static final String STARTDATE  = "startDate";

  public static final String TARGETPATTERN  = "targetPattern";

  public static final String VERSIONPATTERN  = "versionPattern";

  public snapshotFilterSpecDataObj ( String descriptionPattern,java.util.Date endDate,java.util.Date startDate,String targetPattern,String versionPattern ) {
    this(new SoapObject("http://ws.coverity.com/v2", "snapshotFilterSpecDataObj"));
    addProperty(DESCRIPTIONPATTERN, descriptionPattern);
    addProperty(ENDDATE, endDate);
    addProperty(STARTDATE, startDate);
    addProperty(TARGETPATTERN, targetPattern);
    addProperty(VERSIONPATTERN, versionPattern);
 }

  public String getdescriptionPattern() {
    Object tmp = getProperty(DESCRIPTIONPATTERN);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public java.util.Date getendDate() {
    Object tmp = getProperty(ENDDATE);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof String ) {
      tmp = org.kobjects.isodate.IsoDate.stringToDate((String)tmp, org.kobjects.isodate.IsoDate.DATE_TIME);
    addProperty (ENDDATE, tmp);
    }
    return (java.util.Date)tmp;
  }
  public java.util.Date getstartDate() {
    Object tmp = getProperty(STARTDATE);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof String ) {
      tmp = org.kobjects.isodate.IsoDate.stringToDate((String)tmp, org.kobjects.isodate.IsoDate.DATE_TIME);
    addProperty (STARTDATE, tmp);
    }
    return (java.util.Date)tmp;
  }
  public String gettargetPattern() {
    Object tmp = getProperty(TARGETPATTERN);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String getversionPattern() {
    Object tmp = getProperty(VERSIONPATTERN);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
