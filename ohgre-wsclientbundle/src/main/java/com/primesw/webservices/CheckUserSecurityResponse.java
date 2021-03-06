
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.CheckUserSecurityResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}CheckUserSecurityResult" minOccurs="0"/>
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
    "checkUserSecurityResult"
})
@XmlRootElement(name = "CheckUserSecurityResponse")
public class CheckUserSecurityResponse {

    @XmlElement(name = "CheckUserSecurityResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected CheckUserSecurityResult checkUserSecurityResult;

    /**
     * Gets the value of the checkUserSecurityResult property.
     * 
     * @return
     *     possible object is
     *     {@link CheckUserSecurityResult }
     *     
     */
    public CheckUserSecurityResult getCheckUserSecurityResult() {
        return checkUserSecurityResult;
    }

    /**
     * Sets the value of the checkUserSecurityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckUserSecurityResult }
     *     
     */
    public void setCheckUserSecurityResult(CheckUserSecurityResult value) {
        this.checkUserSecurityResult = value;
    }

}
