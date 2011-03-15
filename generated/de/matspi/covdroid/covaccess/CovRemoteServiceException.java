package de.matspi.covdroid.covaccess;

import org.ksoap2.serialization.*;
import org.ksoap2.wsdl.*;

public class CovRemoteServiceException extends SoapObjectWrapper {

      public static final String NAMESPACE = "http://ws.coverity.com/v2";
    public CovRemoteServiceException(SoapObject soapObject) {
    super(soapObject);
  }
  public static final String ERRORCODE  = "errorCode";

  public static final String MESSAGE  = "message";

  public CovRemoteServiceException ( Integer errorCode,String _message ) {
    this(new SoapObject("http://ws.coverity.com/v2", "CovRemoteServiceException"));
    addProperty(ERRORCODE, errorCode);
    addProperty(MESSAGE, _message);
 }

  public Integer geterrorCode() {
    Object tmp = getProperty(ERRORCODE);
    if ( tmp == null ) {
       return null;
    }
    return Integer.valueOf(tmp.toString());
  }
  public String getmessage() {
    Object tmp = getProperty(MESSAGE);
    if ( tmp == null ) {
       return null;
    }
    return ((String)tmp.toString());
  }
 }
