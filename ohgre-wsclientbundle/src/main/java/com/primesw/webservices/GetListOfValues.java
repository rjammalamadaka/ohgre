
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.GetListOfValuesRequest;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}GetListOfValuesRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getListOfValuesRequest"
})
@XmlRootElement(name = "GetListOfValues")
public class GetListOfValues {

    @XmlElement(name = "GetListOfValuesRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected GetListOfValuesRequest getListOfValuesRequest;

    /**
     * Gets the value of the getListOfValuesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetListOfValuesRequest }
     *     
     */
    public GetListOfValuesRequest getGetListOfValuesRequest() {
        return getListOfValuesRequest;
    }

    /**
     * Sets the value of the getListOfValuesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetListOfValuesRequest }
     *     
     */
    public void setGetListOfValuesRequest(GetListOfValuesRequest value) {
        this.getListOfValuesRequest = value;
    }

}
