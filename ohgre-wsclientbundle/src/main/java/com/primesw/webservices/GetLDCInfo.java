
package com.primesw.webservices;

import org.tempuri.quoteservice.GetLDCInfoRequest;

import javax.xml.bind.annotation.*;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}GetLDCInfoRequest" minOccurs="0"/>
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
    "getLDCInfoRequest"
})
@XmlRootElement(name = "GetLDCInfo")
public class GetLDCInfo {

    @XmlElement(name = "GetLDCInfoRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected GetLDCInfoRequest getLDCInfoRequest;

    /**
     * Gets the value of the getLDCInfoRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetLDCInfoRequest }
     *     
     */
    public GetLDCInfoRequest getGetLDCInfoRequest() {
        return getLDCInfoRequest;
    }

    /**
     * Sets the value of the getLDCInfoRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetLDCInfoRequest }
     *     
     */
    public void setGetLDCInfoRequest(GetLDCInfoRequest value) {
        this.getLDCInfoRequest = value;
    }

}
