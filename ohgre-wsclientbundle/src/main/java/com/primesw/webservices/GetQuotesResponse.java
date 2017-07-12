
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.GetQuotesResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}GetQuotesResult" minOccurs="0"/>
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
    "getQuotesResult"
})
@XmlRootElement(name = "GetQuotesResponse")
public class GetQuotesResponse {

    @XmlElement(name = "GetQuotesResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected GetQuotesResult getQuotesResult;

    /**
     * Gets the value of the getQuotesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetQuotesResult }
     *     
     */
    public GetQuotesResult getGetQuotesResult() {
        return getQuotesResult;
    }

    /**
     * Sets the value of the getQuotesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetQuotesResult }
     *     
     */
    public void setGetQuotesResult(GetQuotesResult value) {
        this.getQuotesResult = value;
    }

}
