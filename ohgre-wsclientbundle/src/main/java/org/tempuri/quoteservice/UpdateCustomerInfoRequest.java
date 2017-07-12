
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
 *         &lt;element name="CustID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Premise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailCounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailZipPlusFour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceCounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceZipPlusFour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DoNotCallInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DoNotMailInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailPrefTransactionalCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailPrefSSEPromotionalCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailPrefAffiliatePromotionalCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailPref3rdPartyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailPrefNonTransactionalCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LanguageCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RAFTermsCondAcknowledgedInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "custID",
    "ldc",
    "account",
    "premise",
    "firstName",
    "lastName",
    "businessName",
    "mailAddress1",
    "mailAddress2",
    "mailCity",
    "mailCounty",
    "mailStateCode",
    "mailZipCode",
    "mailZipPlusFour",
    "serviceAddress1",
    "serviceAddress2",
    "serviceCity",
    "serviceCounty",
    "serviceStateCode",
    "serviceZipCode",
    "serviceZipPlusFour",
    "phoneNumber",
    "emailAddress",
    "doNotCallInd",
    "doNotMailInd",
    "emailPrefTransactionalCd",
    "emailPrefSSEPromotionalCd",
    "emailPrefAffiliatePromotionalCd",
    "emailPref3RdPartyCd",
    "emailPrefNonTransactionalCd",
    "languageCd",
    "rafTermsCondAcknowledgedInd"
})
@XmlRootElement(name = "UpdateCustomerInfoRequest")
public class UpdateCustomerInfoRequest {

    @XmlElement(name = "CustID")
    protected String custID;
    @XmlElement(name = "LDC")
    protected String ldc;
    @XmlElement(name = "Account")
    protected String account;
    @XmlElement(name = "Premise")
    protected String premise;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "BusinessName")
    protected String businessName;
    @XmlElement(name = "MailAddress1")
    protected String mailAddress1;
    @XmlElement(name = "MailAddress2")
    protected String mailAddress2;
    @XmlElement(name = "MailCity")
    protected String mailCity;
    @XmlElement(name = "MailCounty")
    protected String mailCounty;
    @XmlElement(name = "MailStateCode")
    protected String mailStateCode;
    @XmlElement(name = "MailZipCode")
    protected String mailZipCode;
    @XmlElement(name = "MailZipPlusFour")
    protected String mailZipPlusFour;
    @XmlElement(name = "ServiceAddress1")
    protected String serviceAddress1;
    @XmlElement(name = "ServiceAddress2")
    protected String serviceAddress2;
    @XmlElement(name = "ServiceCity")
    protected String serviceCity;
    @XmlElement(name = "ServiceCounty")
    protected String serviceCounty;
    @XmlElement(name = "ServiceStateCode")
    protected String serviceStateCode;
    @XmlElement(name = "ServiceZipCode")
    protected String serviceZipCode;
    @XmlElement(name = "ServiceZipPlusFour")
    protected String serviceZipPlusFour;
    @XmlElement(name = "PhoneNumber")
    protected String phoneNumber;
    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "DoNotCallInd")
    protected String doNotCallInd;
    @XmlElement(name = "DoNotMailInd")
    protected String doNotMailInd;
    @XmlElement(name = "EmailPrefTransactionalCd")
    protected String emailPrefTransactionalCd;
    @XmlElement(name = "EmailPrefSSEPromotionalCd")
    protected String emailPrefSSEPromotionalCd;
    @XmlElement(name = "EmailPrefAffiliatePromotionalCd")
    protected String emailPrefAffiliatePromotionalCd;
    @XmlElement(name = "EmailPref3rdPartyCd")
    protected String emailPref3RdPartyCd;
    @XmlElement(name = "EmailPrefNonTransactionalCd")
    protected String emailPrefNonTransactionalCd;
    @XmlElement(name = "LanguageCd")
    protected String languageCd;
    @XmlElement(name = "RAFTermsCondAcknowledgedInd")
    protected String rafTermsCondAcknowledgedInd;

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
     * Gets the value of the ldc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLDC() {
        return ldc;
    }

    /**
     * Sets the value of the ldc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLDC(String value) {
        this.ldc = value;
    }

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the premise property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremise() {
        return premise;
    }

    /**
     * Sets the value of the premise property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremise(String value) {
        this.premise = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the businessName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * Sets the value of the businessName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessName(String value) {
        this.businessName = value;
    }

    /**
     * Gets the value of the mailAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailAddress1() {
        return mailAddress1;
    }

    /**
     * Sets the value of the mailAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailAddress1(String value) {
        this.mailAddress1 = value;
    }

    /**
     * Gets the value of the mailAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailAddress2() {
        return mailAddress2;
    }

    /**
     * Sets the value of the mailAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailAddress2(String value) {
        this.mailAddress2 = value;
    }

    /**
     * Gets the value of the mailCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailCity() {
        return mailCity;
    }

    /**
     * Sets the value of the mailCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailCity(String value) {
        this.mailCity = value;
    }

    /**
     * Gets the value of the mailCounty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailCounty() {
        return mailCounty;
    }

    /**
     * Sets the value of the mailCounty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailCounty(String value) {
        this.mailCounty = value;
    }

    /**
     * Gets the value of the mailStateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailStateCode() {
        return mailStateCode;
    }

    /**
     * Sets the value of the mailStateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailStateCode(String value) {
        this.mailStateCode = value;
    }

    /**
     * Gets the value of the mailZipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailZipCode() {
        return mailZipCode;
    }

    /**
     * Sets the value of the mailZipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailZipCode(String value) {
        this.mailZipCode = value;
    }

    /**
     * Gets the value of the mailZipPlusFour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailZipPlusFour() {
        return mailZipPlusFour;
    }

    /**
     * Sets the value of the mailZipPlusFour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailZipPlusFour(String value) {
        this.mailZipPlusFour = value;
    }

    /**
     * Gets the value of the serviceAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceAddress1() {
        return serviceAddress1;
    }

    /**
     * Sets the value of the serviceAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceAddress1(String value) {
        this.serviceAddress1 = value;
    }

    /**
     * Gets the value of the serviceAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceAddress2() {
        return serviceAddress2;
    }

    /**
     * Sets the value of the serviceAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceAddress2(String value) {
        this.serviceAddress2 = value;
    }

    /**
     * Gets the value of the serviceCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCity() {
        return serviceCity;
    }

    /**
     * Sets the value of the serviceCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCity(String value) {
        this.serviceCity = value;
    }

    /**
     * Gets the value of the serviceCounty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceCounty() {
        return serviceCounty;
    }

    /**
     * Sets the value of the serviceCounty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceCounty(String value) {
        this.serviceCounty = value;
    }

    /**
     * Gets the value of the serviceStateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceStateCode() {
        return serviceStateCode;
    }

    /**
     * Sets the value of the serviceStateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceStateCode(String value) {
        this.serviceStateCode = value;
    }

    /**
     * Gets the value of the serviceZipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceZipCode() {
        return serviceZipCode;
    }

    /**
     * Sets the value of the serviceZipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceZipCode(String value) {
        this.serviceZipCode = value;
    }

    /**
     * Gets the value of the serviceZipPlusFour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceZipPlusFour() {
        return serviceZipPlusFour;
    }

    /**
     * Sets the value of the serviceZipPlusFour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceZipPlusFour(String value) {
        this.serviceZipPlusFour = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

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
     * Gets the value of the doNotCallInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoNotCallInd() {
        return doNotCallInd;
    }

    /**
     * Sets the value of the doNotCallInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoNotCallInd(String value) {
        this.doNotCallInd = value;
    }

    /**
     * Gets the value of the doNotMailInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoNotMailInd() {
        return doNotMailInd;
    }

    /**
     * Sets the value of the doNotMailInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoNotMailInd(String value) {
        this.doNotMailInd = value;
    }

    /**
     * Gets the value of the emailPrefTransactionalCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailPrefTransactionalCd() {
        return emailPrefTransactionalCd;
    }

    /**
     * Sets the value of the emailPrefTransactionalCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailPrefTransactionalCd(String value) {
        this.emailPrefTransactionalCd = value;
    }

    /**
     * Gets the value of the emailPrefSSEPromotionalCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailPrefSSEPromotionalCd() {
        return emailPrefSSEPromotionalCd;
    }

    /**
     * Sets the value of the emailPrefSSEPromotionalCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailPrefSSEPromotionalCd(String value) {
        this.emailPrefSSEPromotionalCd = value;
    }

    /**
     * Gets the value of the emailPrefAffiliatePromotionalCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailPrefAffiliatePromotionalCd() {
        return emailPrefAffiliatePromotionalCd;
    }

    /**
     * Sets the value of the emailPrefAffiliatePromotionalCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailPrefAffiliatePromotionalCd(String value) {
        this.emailPrefAffiliatePromotionalCd = value;
    }

    /**
     * Gets the value of the emailPref3RdPartyCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailPref3RdPartyCd() {
        return emailPref3RdPartyCd;
    }

    /**
     * Sets the value of the emailPref3RdPartyCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailPref3RdPartyCd(String value) {
        this.emailPref3RdPartyCd = value;
    }

    /**
     * Gets the value of the emailPrefNonTransactionalCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailPrefNonTransactionalCd() {
        return emailPrefNonTransactionalCd;
    }

    /**
     * Sets the value of the emailPrefNonTransactionalCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailPrefNonTransactionalCd(String value) {
        this.emailPrefNonTransactionalCd = value;
    }

    /**
     * Gets the value of the languageCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguageCd() {
        return languageCd;
    }

    /**
     * Sets the value of the languageCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguageCd(String value) {
        this.languageCd = value;
    }

    /**
     * Gets the value of the rafTermsCondAcknowledgedInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRAFTermsCondAcknowledgedInd() {
        return rafTermsCondAcknowledgedInd;
    }

    /**
     * Sets the value of the rafTermsCondAcknowledgedInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRAFTermsCondAcknowledgedInd(String value) {
        this.rafTermsCondAcknowledgedInd = value;
    }

}
