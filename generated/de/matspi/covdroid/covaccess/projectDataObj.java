package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class projectDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public projectDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String STREAMS  = "streams";

  public static final String DATECREATED  = "dateCreated";

  public static final String DATEMODIFIED  = "dateModified";

  public static final String DEFAULTTRIAGESCOPE  = "defaultTriageScope";

  public static final String DESCRIPTION  = "description";

  public static final String ID  = "id";

  public static final String PROJECTKEY  = "projectKey";

  public static final String USERCREATED  = "userCreated";

  public static final String USERMODIFIED  = "userModified";

  public projectDataObj ( streamDataObj[] _streams,java.util.Date dateCreated,java.util.Date dateModified,String defaultTriageScope,String _description,projectIdDataObj _id,Long projectKey,String userCreated,String userModified ) {
    this(new SoapObject("http://ws.coverity.com/v2", "projectDataObj"));
    addProperty(STREAMS, _streams);
    addProperty(DATECREATED, dateCreated);
    addProperty(DATEMODIFIED, dateModified);
    addProperty(DEFAULTTRIAGESCOPE, defaultTriageScope);
    addProperty(DESCRIPTION, _description);
    addProperty(ID, _id);
    addProperty(PROJECTKEY, projectKey);
    addProperty(USERCREATED, userCreated);
    addProperty(USERMODIFIED, userModified);
 }

  public streamDataObj[] getstreams() {
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
          v.addElement(new streamDataObj(value));
       }
     }
     streamDataObj[] array  = new streamDataObj[v.size()];
     for ( int counter = 0 ; counter < v.size() ; counter++ ) {
       array[counter] = (streamDataObj)v.elementAt(counter);
     }
      tmp = array;
    }
    return (streamDataObj[])tmp;
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
  public java.util.Date getdateModified() {
    Object tmp = getProperty(DATEMODIFIED);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof String ) {
      tmp = org.kobjects.isodate.IsoDate.stringToDate((String)tmp, org.kobjects.isodate.IsoDate.DATE_TIME);
    addProperty (DATEMODIFIED, tmp);
    }
    return (java.util.Date)tmp;
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
  public projectIdDataObj getid() {
    Object tmp = getProperty(ID);
    if ( tmp == null ) {
       return null;
    }
    if ( tmp instanceof SoapObject ) {
      tmp = new projectIdDataObj((SoapObject)tmp);
    }
    return (projectIdDataObj)tmp;
  }
  public Long getprojectKey() {
    Object tmp = getProperty(PROJECTKEY);
    if ( tmp == null ) {
       return null;
    }
    return Long.valueOf(tmp.toString());
  }
  public String getuserCreated() {
    Object tmp = getProperty(USERCREATED);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
  public String getuserModified() {
    Object tmp = getProperty(USERMODIFIED);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
