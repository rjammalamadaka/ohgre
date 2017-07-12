
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.CheckUserSecurityRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}CheckUserSecurityRequest" minOccurs="0"/>
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
    "checkUserSecurityRequest"
})
@XmlRootElement(name = "CheckUserSecurity")
public class CheckUserSecurity {

    @XmlElement(name = "CheckUserSecurityRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected CheckUserSecurityRequest checkUserSecurityRequest;

    /**
     * Gets the value of the checkUserSecurityRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CheckUserSecurityRequest }
     *     
     */
    public CheckUserSecurityRequest getCheckUserSecurityRequest() {
        return checkUserSecurityRequest;
    }

    /**
     * Sets the value of the checkUserSecurityRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckUserSecurityRequest }
     *     
     */
    public void setCheckUserSecurityRequest(CheckUserSecurityRequest value) {
        this.checkUserSecurityRequest = value;
    }

}
