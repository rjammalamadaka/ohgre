
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.SendRealTimeEmailResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}SendRealTimeEmailResult" minOccurs="0"/>
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
    "sendRealTimeEmailResult"
})
@XmlRootElement(name = "SendRealTimeEmailResponse")
public class SendRealTimeEmailResponse {

    @XmlElement(name = "SendRealTimeEmailResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected SendRealTimeEmailResult sendRealTimeEmailResult;

    /**
     * Gets the value of the sendRealTimeEmailResult property.
     * 
     * @return
     *     possible object is
     *     {@link SendRealTimeEmailResult }
     *     
     */
    public SendRealTimeEmailResult getSendRealTimeEmailResult() {
        return sendRealTimeEmailResult;
    }

    /**
     * Sets the value of the sendRealTimeEmailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendRealTimeEmailResult }
     *     
     */
    public void setSendRealTimeEmailResult(SendRealTimeEmailResult value) {
        this.sendRealTimeEmailResult = value;
    }

}
