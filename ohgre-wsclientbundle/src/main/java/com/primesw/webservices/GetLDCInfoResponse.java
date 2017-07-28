
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.GetLDCInfoResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}GetLDCInfoResult" minOccurs="0"/>
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
    "getLDCInfoResult"
})
@XmlRootElement(name = "GetLDCInfoResponse")
public class GetLDCInfoResponse {

    @XmlElement(name = "GetLDCInfoResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected GetLDCInfoResult getLDCInfoResult;

    /**
     * Gets the value of the getLDCInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetLDCInfoResult }
     *     
     */
    public GetLDCInfoResult getGetLDCInfoResult() {
        return getLDCInfoResult;
    }

    /**
     * Sets the value of the getLDCInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetLDCInfoResult }
     *     
     */
    public void setGetLDCInfoResult(GetLDCInfoResult value) {
        this.getLDCInfoResult = value;
    }

}
