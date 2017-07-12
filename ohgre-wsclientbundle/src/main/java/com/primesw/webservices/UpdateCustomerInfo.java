
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.UpdateCustomerInfoRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}UpdateCustomerInfoRequest" minOccurs="0"/>
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
    "updateCustomerInfoRequest"
})
@XmlRootElement(name = "UpdateCustomerInfo")
public class UpdateCustomerInfo {

    @XmlElement(name = "UpdateCustomerInfoRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected UpdateCustomerInfoRequest updateCustomerInfoRequest;

    /**
     * Gets the value of the updateCustomerInfoRequest property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateCustomerInfoRequest }
     *     
     */
    public UpdateCustomerInfoRequest getUpdateCustomerInfoRequest() {
        return updateCustomerInfoRequest;
    }

    /**
     * Sets the value of the updateCustomerInfoRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateCustomerInfoRequest }
     *     
     */
    public void setUpdateCustomerInfoRequest(UpdateCustomerInfoRequest value) {
        this.updateCustomerInfoRequest = value;
    }

}
