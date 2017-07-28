
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.GetPromoCodeInfoResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}GetPromoCodeInfoResult" minOccurs="0"/>
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
    "getPromoCodeInfoResult"
})
@XmlRootElement(name = "GetPromoCodeInfoResponse")
public class GetPromoCodeInfoResponse {

    @XmlElement(name = "GetPromoCodeInfoResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected GetPromoCodeInfoResult getPromoCodeInfoResult;

    /**
     * Gets the value of the getPromoCodeInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetPromoCodeInfoResult }
     *     
     */
    public GetPromoCodeInfoResult getGetPromoCodeInfoResult() {
        return getPromoCodeInfoResult;
    }

    /**
     * Sets the value of the getPromoCodeInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPromoCodeInfoResult }
     *     
     */
    public void setGetPromoCodeInfoResult(GetPromoCodeInfoResult value) {
        this.getPromoCodeInfoResult = value;
    }

}
