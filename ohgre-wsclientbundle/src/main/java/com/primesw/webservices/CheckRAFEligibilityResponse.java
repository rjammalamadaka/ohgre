
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.CheckRAFEligibilityResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}CheckRAFEligibilityResult" minOccurs="0"/>
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
    "checkRAFEligibilityResult"
})
@XmlRootElement(name = "CheckRAFEligibilityResponse")
public class CheckRAFEligibilityResponse {

    @XmlElement(name = "CheckRAFEligibilityResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected CheckRAFEligibilityResult checkRAFEligibilityResult;

    /**
     * Gets the value of the checkRAFEligibilityResult property.
     * 
     * @return
     *     possible object is
     *     {@link CheckRAFEligibilityResult }
     *     
     */
    public CheckRAFEligibilityResult getCheckRAFEligibilityResult() {
        return checkRAFEligibilityResult;
    }

    /**
     * Sets the value of the checkRAFEligibilityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckRAFEligibilityResult }
     *     
     */
    public void setCheckRAFEligibilityResult(CheckRAFEligibilityResult value) {
        this.checkRAFEligibilityResult = value;
    }

}
