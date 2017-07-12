
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.GetCustomerInfoRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}GetCustomerInfoRequest" minOccurs="0"/>
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
    "getCustomerInfoRequest"
})
@XmlRootElement(name = "GetCustomerInfo")
public class GetCustomerInfo {

    @XmlElement(name = "GetCustomerInfoRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected GetCustomerInfoRequest getCustomerInfoRequest;

    /**
     * Gets the value of the getCustomerInfoRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerInfoRequest }
     *     
     */
    public GetCustomerInfoRequest getGetCustomerInfoRequest() {
        return getCustomerInfoRequest;
    }

    /**
     * Sets the value of the getCustomerInfoRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerInfoRequest }
     *     
     */
    public void setGetCustomerInfoRequest(GetCustomerInfoRequest value) {
        this.getCustomerInfoRequest = value;
    }

}
