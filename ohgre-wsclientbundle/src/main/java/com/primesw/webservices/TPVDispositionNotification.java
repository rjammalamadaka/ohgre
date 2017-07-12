
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.TPVDispositionNotificationRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}TPVDispositionNotificationRequest" minOccurs="0"/>
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
    "tpvDispositionNotificationRequest"
})
@XmlRootElement(name = "TPVDispositionNotification")
public class TPVDispositionNotification {

    @XmlElement(name = "TPVDispositionNotificationRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected TPVDispositionNotificationRequest tpvDispositionNotificationRequest;

    /**
     * Gets the value of the tpvDispositionNotificationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TPVDispositionNotificationRequest }
     *     
     */
    public TPVDispositionNotificationRequest getTPVDispositionNotificationRequest() {
        return tpvDispositionNotificationRequest;
    }

    /**
     * Sets the value of the tpvDispositionNotificationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPVDispositionNotificationRequest }
     *     
     */
    public void setTPVDispositionNotificationRequest(TPVDispositionNotificationRequest value) {
        this.tpvDispositionNotificationRequest = value;
    }

}
