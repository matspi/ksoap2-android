package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class componentDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public componentDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String COMPONENTID  = "componentId";

  public static final String EXCLUDECOMPONENT  = "excludeComponent";

  public static final String GROUPPERMISSIONS  = "groupPermissions";

  public static final String SUBSCRIBERS  = "subscribers";

  public componentDataObj ( componentIdDataObj componentId,Boolean excludeComponent,groupPermissionDataObj[] groupPermissions,String[] _subscribers ) {
    this(new SoapObject("http://ws.coverity.com/v2", "componentDataObj"));
    addProperty(COMPONENTID, componentId);
    addProperty(EXCLUDECOMPONENT, excludeComponent);
    addProperty(GROUPPERMISSIONS, groupPermissions);
    addProperty(SUBSCRIBERS, _subscribers);
 }

  public componentIdDataObj getcomponentId() {
    Object tmp = getProperty(COMPONENTID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new componentIdDataObj((SoapObject)tmp);
    }
    return (componentIdDataObj)tmp;
  }
  public Boolean isexcludeComponent() {
    Object tmp = getProperty(EXCLUDECOMPONENT);
    if ( tmp == null ) {
       return null;
    }
    return Boolean.valueOf(tmp.toString());
  }
  public groupPermissionDataObj[] getgroupPermissions() {
    Object tmp = getProperty(GROUPPERMISSIONS);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(GROUPPERMISSIONS )) {
          SoapObject value = (SoapObject)pi.getValue();
          v.addElement(new groupPermissionDataObj(value));
       }
     }
     groupPermissionDataObj[] array  = new groupPermissionDataObj[v.size()];
     for ( int counter = 0 ; counter < v.size() ; counter++ ) {
       array[counter] = (groupPermissionDataObj)v.elementAt(counter);
     }
      tmp = array;
    }
    return (groupPermissionDataObj[])tmp;
  }
  public String[] getsubscribers() {
    Object tmp = getProperty(SUBSCRIBERS);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
     java.util.Vector v = new java.util.Vector(3);
     for ( int counter = 0 ; counter < soapObject.getPropertyCount() ; counter++ ) {
        PropertyInfo pi = new PropertyInfo();
        soapObject.getPropertyInfo(counter, pi);
        if ( pi.getName().equals(SUBSCRIBERS )) {
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
 }
