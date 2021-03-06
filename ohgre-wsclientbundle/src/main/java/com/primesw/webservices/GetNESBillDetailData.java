
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.NESBillDetailRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}NESBillDetailRequest" minOccurs="0"/>
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
    "nesBillDetailRequest"
})
@XmlRootElement(name = "GetNESBillDetailData")
public class GetNESBillDetailData {

    @XmlElement(name = "NESBillDetailRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected NESBillDetailRequest nesBillDetailRequest;

    /**
     * Gets the value of the nesBillDetailRequest property.
     * 
     * @return
     *     possible object is
     *     {@link NESBillDetailRequest }
     *     
     */
    public NESBillDetailRequest getNESBillDetailRequest() {
        return nesBillDetailRequest;
    }

    /**
     * Sets the value of the nesBillDetailRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link NESBillDetailRequest }
     *     
     */
    public void setNESBillDetailRequest(NESBillDetailRequest value) {
        this.nesBillDetailRequest = value;
    }

}
