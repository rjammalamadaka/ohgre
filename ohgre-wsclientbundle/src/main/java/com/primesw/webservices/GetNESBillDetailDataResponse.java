
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.GetNESBillDetailDataResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}GetNESBillDetailDataResult" minOccurs="0"/>
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
    "getNESBillDetailDataResult"
})
@XmlRootElement(name = "GetNESBillDetailDataResponse")
public class GetNESBillDetailDataResponse {

    @XmlElement(name = "GetNESBillDetailDataResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected GetNESBillDetailDataResult getNESBillDetailDataResult;

    /**
     * Gets the value of the getNESBillDetailDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetNESBillDetailDataResult }
     *     
     */
    public GetNESBillDetailDataResult getGetNESBillDetailDataResult() {
        return getNESBillDetailDataResult;
    }

    /**
     * Sets the value of the getNESBillDetailDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetNESBillDetailDataResult }
     *     
     */
    public void setGetNESBillDetailDataResult(GetNESBillDetailDataResult value) {
        this.getNESBillDetailDataResult = value;
    }

}
