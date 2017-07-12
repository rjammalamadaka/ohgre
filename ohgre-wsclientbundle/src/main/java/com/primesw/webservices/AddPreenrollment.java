
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.PreenrollmentRequest;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}PreenrollmentRequest" minOccurs="0"/>
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
    "preenrollmentRequest"
})
@XmlRootElement(name = "AddPreenrollment")
public class AddPreenrollment {

    @XmlElement(name = "PreenrollmentRequest", namespace = "http://tempuri.org/QuoteService.xsd")
    protected PreenrollmentRequest preenrollmentRequest;

    /**
     * Gets the value of the preenrollmentRequest property.
     * 
     * @return
     *     possible object is
     *     {@link PreenrollmentRequest }
     *     
     */
    public PreenrollmentRequest getPreenrollmentRequest() {
        return preenrollmentRequest;
    }

    /**
     * Sets the value of the preenrollmentRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreenrollmentRequest }
     *     
     */
    public void setPreenrollmentRequest(PreenrollmentRequest value) {
        this.preenrollmentRequest = value;
    }

}
