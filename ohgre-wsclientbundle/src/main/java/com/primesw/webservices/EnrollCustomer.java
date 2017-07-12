
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.EnrollRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}EnrollRequest" minOccurs="0"/>
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
    "enrollRequest"
})
@XmlRootElement(name = "EnrollCustomer")
public class EnrollCustomer {

    @XmlElement(name = "EnrollRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected EnrollRequest enrollRequest;

    /**
     * Gets the value of the enrollRequest property.
     * 
     * @return
     *     possible object is
     *     {@link EnrollRequest }
     *     
     */
    public EnrollRequest getEnrollRequest() {
        return enrollRequest;
    }

    /**
     * Sets the value of the enrollRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnrollRequest }
     *     
     */
    public void setEnrollRequest(EnrollRequest value) {
        this.enrollRequest = value;
    }

}
