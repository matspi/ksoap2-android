package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class snapshotInfoDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public snapshotInfoDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String DATECREATED  = "dateCreated";

  public static final String DESCRIPTION  = "description";

  public static final String SNAPSHOTID  = "snapshotId";

  public static final String SOURCEVERSION  = "sourceVersion";

  public static final String TARGET  = "target";

  public snapshotInfoDataObj ( java.util.Date dateCreated,String _description,snapshotIdDataObj snapshotId,String sourceVersion,String _target ) {
    this(new SoapObject("http://ws.coverity.com/v2", "snapshotInfoDataObj"));
    addProperty(DATECREATED, dateCreated);
    addProperty(DESCRIPTION, _description);
    addProperty(SNAPSHOTID, snapshotId);
    addProperty(SOURCEVERSION, sourceVersion);
    addProperty(TARGET, _target);
 }

  public java.util.Date getdateCreated() {
    Object tmp = getProperty(DATECREATED);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof String ) {
      tmp = org.kobjects.isodate.IsoDate.stringToDate((String)tmp, org.kobjects.isodate.IsoDate.DATE_TIME);
    addProperty (DATECREATED, tmp);
    }
    return (java.util.Date)tmp;
  }
  public String getdescription() {
    Object tmp = getProperty(DESCRIPTION);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public snapshotIdDataObj getsnapshotId() {
    Object tmp = getProperty(SNAPSHOTID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new snapshotIdDataObj((SoapObject)tmp);
    }
    return (snapshotIdDataObj)tmp;
  }
  public String getsourceVersion() {
    Object tmp = getProperty(SOURCEVERSION);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String gettarget() {
    Object tmp = getProperty(TARGET);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
