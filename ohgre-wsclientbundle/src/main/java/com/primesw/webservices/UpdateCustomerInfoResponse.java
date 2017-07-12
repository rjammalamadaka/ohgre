
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.UpdateCustomerInfoResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}UpdateCustomerInfoResult" minOccurs="0"/>
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
    "updateCustomerInfoResult"
})
@XmlRootElement(name = "UpdateCustomerInfoResponse")
public class UpdateCustomerInfoResponse {

    @XmlElement(name = "UpdateCustomerInfoResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected UpdateCustomerInfoResult updateCustomerInfoResult;

    /**
     * Gets the value of the updateCustomerInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateCustomerInfoResult }
     *     
     */
    public UpdateCustomerInfoResult getUpdateCustomerInfoResult() {
        return updateCustomerInfoResult;
    }

    /**
     * Sets the value of the updateCustomerInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateCustomerInfoResult }
     *     
     */
    public void setUpdateCustomerInfoResult(UpdateCustomerInfoResult value) {
        this.updateCustomerInfoResult = value;
    }

}
