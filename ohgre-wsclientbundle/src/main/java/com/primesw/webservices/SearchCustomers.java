
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.SearchCustomersRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}SearchCustomersRequest" minOccurs="0"/>
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
    "searchCustomersRequest"
})
@XmlRootElement(name = "SearchCustomers")
public class SearchCustomers {

    @XmlElement(name = "SearchCustomersRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected SearchCustomersRequest searchCustomersRequest;

    /**
     * Gets the value of the searchCustomersRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SearchCustomersRequest }
     *     
     */
    public SearchCustomersRequest getSearchCustomersRequest() {
        return searchCustomersRequest;
    }

    /**
     * Sets the value of the searchCustomersRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchCustomersRequest }
     *     
     */
    public void setSearchCustomersRequest(SearchCustomersRequest value) {
        this.searchCustomersRequest = value;
    }

}
