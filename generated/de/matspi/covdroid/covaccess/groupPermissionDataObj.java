package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class groupPermissionDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public groupPermissionDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String ACCESSALLOWED  = "accessAllowed";

  public static final String GROUPID  = "groupId";

  public groupPermissionDataObj ( Boolean accessAllowed,groupIdDataObj groupId ) {
    this(new SoapObject("http://ws.coverity.com/v2", "groupPermissionDataObj"));
    addProperty(ACCESSALLOWED, accessAllowed);
    addProperty(GROUPID, groupId);
 }

  public Boolean isaccessAllowed() {
    Object tmp = getProperty(ACCESSALLOWED);
    if ( tmp == null ) {
       return null;
    }
    return Boolean.valueOf(tmp.toString());
  }
  public groupIdDataObj getgroupId() {
    Object tmp = getProperty(GROUPID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new groupIdDataObj((SoapObject)tmp);
    }
    return (groupIdDataObj)tmp;
  }
 }
