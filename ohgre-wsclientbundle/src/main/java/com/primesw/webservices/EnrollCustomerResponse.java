
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.EnrollCustomerResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}EnrollCustomerResult" minOccurs="0"/>
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
    "enrollCustomerResult"
})
@XmlRootElement(name = "EnrollCustomerResponse")
public class EnrollCustomerResponse {

    @XmlElement(name = "EnrollCustomerResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected EnrollCustomerResult enrollCustomerResult;

    /**
     * Gets the value of the enrollCustomerResult property.
     * 
     * @return
     *     possible object is
     *     {@link EnrollCustomerResult }
     *     
     */
    public EnrollCustomerResult getEnrollCustomerResult() {
        return enrollCustomerResult;
    }

    /**
     * Sets the value of the enrollCustomerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnrollCustomerResult }
     *     
     */
    public void setEnrollCustomerResult(EnrollCustomerResult value) {
        this.enrollCustomerResult = value;
    }

}
