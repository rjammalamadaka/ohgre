
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.TPVDispositionNotificationResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}TPVDispositionNotificationResult" minOccurs="0"/>
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
    "tpvDispositionNotificationResult"
})
@XmlRootElement(name = "TPVDispositionNotificationResponse")
public class TPVDispositionNotificationResponse {

    @XmlElement(name = "TPVDispositionNotificationResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected TPVDispositionNotificationResult tpvDispositionNotificationResult;

    /**
     * Gets the value of the tpvDispositionNotificationResult property.
     * 
     * @return
     *     possible object is
     *     {@link TPVDispositionNotificationResult }
     *     
     */
    public TPVDispositionNotificationResult getTPVDispositionNotificationResult() {
        return tpvDispositionNotificationResult;
    }

    /**
     * Sets the value of the tpvDispositionNotificationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPVDispositionNotificationResult }
     *     
     */
    public void setTPVDispositionNotificationResult(TPVDispositionNotificationResult value) {
        this.tpvDispositionNotificationResult = value;
    }

}
