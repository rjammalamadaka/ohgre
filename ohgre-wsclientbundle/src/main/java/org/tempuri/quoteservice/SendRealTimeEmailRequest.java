
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
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UpdateCustEmailAddressInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ListID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="TemplateID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CampaignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RealmID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OverrideEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OverrideCustID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "emailAddress",
    "custID",
    "emailType",
    "updateCustEmailAddressInd",
    "listID",
    "templateID",
    "campaignName",
    "realmID",
    "overrideEmailAddress",
    "overrideCustID"
})
@XmlRootElement(name = "SendRealTimeEmailRequest")
public class SendRealTimeEmailRequest {

    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "CustID")
    protected String custID;
    @XmlElement(name = "EmailType")
    protected String emailType;
    @XmlElement(name = "UpdateCustEmailAddressInd")
    protected String updateCustEmailAddressInd;
    @XmlElement(name = "ListID")
    protected Object listID;
    @XmlElement(name = "TemplateID")
    protected String templateID;
    @XmlElement(name = "CampaignName")
    protected String campaignName;
    @XmlElement(name = "RealmID")
    protected String realmID;
    @XmlElement(name = "OverrideEmailAddress")
    protected String overrideEmailAddress;
    @XmlElement(name = "OverrideCustID")
    protected String overrideCustID;

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the custID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustID() {
        return custID;
    }

    /**
     * Sets the value of the custID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustID(String value) {
        this.custID = value;
    }

    /**
     * Gets the value of the emailType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailType() {
        return emailType;
    }

    /**
     * Sets the value of the emailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailType(String value) {
        this.emailType = value;
    }

    /**
     * Gets the value of the updateCustEmailAddressInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateCustEmailAddressInd() {
        return updateCustEmailAddressInd;
    }

    /**
     * Sets the value of the updateCustEmailAddressInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateCustEmailAddressInd(String value) {
        this.updateCustEmailAddressInd = value;
    }

    /**
     * Gets the value of the listID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getListID() {
        return listID;
    }

    /**
     * Sets the value of the listID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setListID(Object value) {
        this.listID = value;
    }

    /**
     * Gets the value of the templateID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateID() {
        return templateID;
    }

    /**
     * Sets the value of the templateID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateID(String value) {
        this.templateID = value;
    }

    /**
     * Gets the value of the campaignName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Sets the value of the campaignName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignName(String value) {
        this.campaignName = value;
    }

    /**
     * Gets the value of the realmID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealmID() {
        return realmID;
    }

    /**
     * Sets the value of the realmID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealmID(String value) {
        this.realmID = value;
    }

    /**
     * Gets the value of the overrideEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverrideEmailAddress() {
        return overrideEmailAddress;
    }

    /**
     * Sets the value of the overrideEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverrideEmailAddress(String value) {
        this.overrideEmailAddress = value;
    }

    /**
     * Gets the value of the overrideCustID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverrideCustID() {
        return overrideCustID;
    }

    /**
     * Sets the value of the overrideCustID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverrideCustID(String value) {
        this.overrideCustID = value;
    }

}
