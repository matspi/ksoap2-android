/*
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 package org.ksoap2.wsdl;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;

/**
 *    Marshal the "getStatus" call.  This is a wrapper for a SoapObject.
 *    
 *    <s:element name="GetStatus">
 *      <s:complexType>
 *        <s:attribute name="LocaleID" type="s:string"/>
 *        <s:attribute name="ClientRequestHandle" type="s:string"/>
 *      </s:complexType>
 *    </s:element>

 
 */
public abstract class SoapObjectWrapper {
  
  
  /** The soap object that we are creating. */
  protected SoapObject soapObject;
  
  /** Create the object. */
  public SoapObjectWrapper(SoapObject soapObject) {
    this.soapObject = soapObject;
  }
  
  /** Returns an envelope for which this object is the bodyout. A new envelope is created on each
   * invocation.
   */
  public SoapSerializationEnvelope getEnvelope () {
    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.bodyOut = this;
    envelope.implicitTypes = true;
    envelope.setAddAdornments(false);
    return envelope;
  }

  /**
   * @return Returns the soapObject.
   */
  public SoapObject getSoapObject() {
    return soapObject;
  }
  
  /** Add the attribute.  This method will silent ignore values that are null. If the value
   * is non-null then the id must be non-null. 
   */
  public void addAttribute(String id, Object value) {
    if ( value != null ) {
      soapObject.addAttribute(id, value);
    }
  }
  
   /** Returns the attribute value or null if the attribute is unknown.  Optional WSDL attributes that are
    * not provided will thus be null and not throw a Runtime Exception.  Null values should be acceptable to
    * the callers of this method since some attributes are optional.  I dislike runtime exceptions,
    * if you really want an exception, use hard exception.  Normally I'd avocate throwing a hard exception over 
    * returning null, except that the concept of an "optional" parameter implies that the code must handle 
    * parameters that are not passed and such a situation is not an error but part of the design.
    */
   public Object getAttribute(String id) {
     Object ret = null;
     try {
       ret = soapObject.getAttribute(id);
     } catch (RuntimeException blah ) {
       // ignore
     }
     return ret;
   }
 
   /** Add the property.  This method will silent ignore values that are null. If the value
    * is non-null then the id must be non-null. 
    */
   public void addProperty(String id, Object value) {
     if ( value != null ) {
       soapObject.addProperty(id, value);
     }
   }
   
    /** Returns the property value or null if the property is unknown.  Optional WSDL properties that are
     * not provided will thus be null and not throw a Runtime Exception.  Null values should be acceptable to
     * the callers of this method since some attributes are optional.  I dislike runtime exceptions,
     * if you really want an exception, use hard exception.  Normally I'd avocate throwing a hard exception over 
     * returning null, except that the concept of an "optional" parameter implies that the code must handle 
     * parameters that are not passed and such a situation is not an error but part of the design.
     */
    public Object getProperty(String id) {
      Object ret = null;
      try {
        ret = soapObject.getProperty(id);
      } catch (RuntimeException blah ) {
        // ignore
      }
      return ret;
    }
  

    
} 
