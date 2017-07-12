
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.SendRealTimeEmailRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}SendRealTimeEmailRequest" minOccurs="0"/>
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
    "sendRealTimeEmailRequest"
})
@XmlRootElement(name = "SendRealTimeEmail")
public class SendRealTimeEmail {

    @XmlElement(name = "SendRealTimeEmailRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected SendRealTimeEmailRequest sendRealTimeEmailRequest;

    /**
     * Gets the value of the sendRealTimeEmailRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SendRealTimeEmailRequest }
     *     
     */
    public SendRealTimeEmailRequest getSendRealTimeEmailRequest() {
        return sendRealTimeEmailRequest;
    }

    /**
     * Sets the value of the sendRealTimeEmailRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendRealTimeEmailRequest }
     *     
     */
    public void setSendRealTimeEmailRequest(SendRealTimeEmailRequest value) {
        this.sendRealTimeEmailRequest = value;
    }

}
