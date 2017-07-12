
package com.primesw.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.tempuri.quoteservice.AddPreenrollmentResult;


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
 *         &lt;element ref="{http://tempuri.org/QuoteService.xsd}AddPreenrollmentResult" minOccurs="0"/>
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
    "addPreenrollmentResult"
})
@XmlRootElement(name = "AddPreenrollmentResponse")
public class AddPreenrollmentResponse {

    @XmlElement(name = "AddPreenrollmentResult", namespace = "http://tempuri.org/QuoteService.xsd")
    protected AddPreenrollmentResult addPreenrollmentResult;

    /**
     * Gets the value of the addPreenrollmentResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddPreenrollmentResult }
     *     
     */
    public AddPreenrollmentResult getAddPreenrollmentResult() {
        return addPreenrollmentResult;
    }

    /**
     * Sets the value of the addPreenrollmentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddPreenrollmentResult }
     *     
     */
    public void setAddPreenrollmentResult(AddPreenrollmentResult value) {
        this.addPreenrollmentResult = value;
    }

}
