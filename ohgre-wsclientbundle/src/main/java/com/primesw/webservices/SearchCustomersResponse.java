
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.SearchCustomersResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}SearchCustomersResult" minOccurs="0"/>
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
    "searchCustomersResult"
})
@XmlRootElement(name = "SearchCustomersResponse")
public class SearchCustomersResponse {

    @XmlElement(name = "SearchCustomersResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected SearchCustomersResult searchCustomersResult;

    /**
     * Gets the value of the searchCustomersResult property.
     * 
     * @return
     *     possible object is
     *     {@link SearchCustomersResult }
     *     
     */
    public SearchCustomersResult getSearchCustomersResult() {
        return searchCustomersResult;
    }

    /**
     * Sets the value of the searchCustomersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCustomersResult }
     *     
     */
    public void setSearchCustomersResult(SearchCustomersResult value) {
        this.searchCustomersResult = value;
    }

}
