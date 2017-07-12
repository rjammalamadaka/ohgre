
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.AuthenticateCustomerResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}AuthenticateCustomerResult" minOccurs="0"/>
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
    "authenticateCustomerResult"
})
@XmlRootElement(name = "AuthenticateCustomerResponse")
public class AuthenticateCustomerResponse {

    @XmlElement(name = "AuthenticateCustomerResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected AuthenticateCustomerResult authenticateCustomerResult;

    /**
     * Gets the value of the authenticateCustomerResult property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticateCustomerResult }
     *     
     */
    public AuthenticateCustomerResult getAuthenticateCustomerResult() {
        return authenticateCustomerResult;
    }

    /**
     * Sets the value of the authenticateCustomerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticateCustomerResult }
     *     
     */
    public void setAuthenticateCustomerResult(AuthenticateCustomerResult value) {
        this.authenticateCustomerResult = value;
    }

}
