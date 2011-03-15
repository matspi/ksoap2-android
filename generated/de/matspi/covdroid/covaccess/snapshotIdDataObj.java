package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class snapshotIdDataObj extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public snapshotIdDataObj(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String ID  = "id";

  public snapshotIdDataObj ( Long _id ) {
    this(new SoapObject("http://ws.coverity.com/v2", "snapshotIdDataObj"));
    addProperty(ID, _id);
 }

  public Long getid() {
    Object tmp = getProperty(ID);
    if ( tmp == null ) {
       return null;
    }
    return Long.valueOf(tmp.toString());
  }
 }
