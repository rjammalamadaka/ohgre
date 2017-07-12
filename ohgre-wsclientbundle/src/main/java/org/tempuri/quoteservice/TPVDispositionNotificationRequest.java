
package org.tempuri.quoteservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="TPVCaseID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConfirmedIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RejectionMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CallDurationSeconds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "tpvCaseID",
    "confirmedIndicator",
    "rejectionMessage",
    "callDurationSeconds"
})
@XmlRootElement(name = "TPVDispositionNotificationRequest")
public class TPVDispositionNotificationRequest {

    @XmlElement(name = "TPVCaseID")
    protected String tpvCaseID;
    @XmlElement(name = "ConfirmedIndicator")
    protected String confirmedIndicator;
    @XmlElement(name = "RejectionMessage")
    protected String rejectionMessage;
    @XmlElement(name = "CallDurationSeconds")
    protected String callDurationSeconds;

    /**
     * Gets the value of the tpvCaseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTPVCaseID() {
        return tpvCaseID;
    }

    /**
     * Sets the value of the tpvCaseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTPVCaseID(String value) {
        this.tpvCaseID = value;
    }

    /**
     * Gets the value of the confirmedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmedIndicator() {
        return confirmedIndicator;
    }

    /**
     * Sets the value of the confirmedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmedIndicator(String value) {
        this.confirmedIndicator = value;
    }

    /**
     * Gets the value of the rejectionMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRejectionMessage() {
        return rejectionMessage;
    }

    /**
     * Sets the value of the rejectionMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRejectionMessage(String value) {
        this.rejectionMessage = value;
    }

    /**
     * Gets the value of the callDurationSeconds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallDurationSeconds() {
        return callDurationSeconds;
    }

    /**
     * Sets the value of the callDurationSeconds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallDurationSeconds(String value) {
        this.callDurationSeconds = value;
    }

}
