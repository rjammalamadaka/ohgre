
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.GetPromoCodeInfoRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}GetPromoCodeInfoRequest" minOccurs="0"/>
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
    "getPromoCodeInfoRequest"
})
@XmlRootElement(name = "GetPromoCodeInfo")
public class GetPromoCodeInfo {

    @XmlElement(name = "GetPromoCodeInfoRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected GetPromoCodeInfoRequest getPromoCodeInfoRequest;

    /**
     * Gets the value of the getPromoCodeInfoRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetPromoCodeInfoRequest }
     *     
     */
    public GetPromoCodeInfoRequest getGetPromoCodeInfoRequest() {
        return getPromoCodeInfoRequest;
    }

    /**
     * Sets the value of the getPromoCodeInfoRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPromoCodeInfoRequest }
     *     
     */
    public void setGetPromoCodeInfoRequest(GetPromoCodeInfoRequest value) {
        this.getPromoCodeInfoRequest = value;
    }

}
