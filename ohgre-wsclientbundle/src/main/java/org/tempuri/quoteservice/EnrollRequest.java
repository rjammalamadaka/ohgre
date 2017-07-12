
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
 *         &lt;element name="MailAddressVerified" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceAddressVerified" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PromoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RAFCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnrolledByUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChannelID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CampaignID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WebSiteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustLeadSourceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnrollConfirmationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionIfContractExists" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreventCancelFeeifContractExists" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BypassCreditCheckInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SoldDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BypassCIRInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpectedQuoteAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TPVRequiredInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AlternateEmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EditOnlyInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="B2BCustomerInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrokerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DelaySendToUtilDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalFixPricePerThermCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalFixPricePerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalVarPriceAddOnPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalCtrctDurationMonths" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalCtrctTermDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceSystemReferenceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "mailAddressVerified",
    "serviceAddressVerified",
    "productCode",
    "promoCode",
    "rafCode",
    "enrolledByUserId",
    "authorizationCode",
    "authorizationLevel",
    "channelID",
    "promotionCode",
    "campaignID",
    "webSiteID",
    "custLeadSourceCode",
    "enrollConfirmationNumber",
    "actionIfContractExists",
    "preventCancelFeeifContractExists",
    "bypassCreditCheckInd",
    "soldDate",
    "bypassCIRInd",
    "expectedQuoteAmt",
    "tpvRequiredInd",
    "emailTypeCode",
    "alternateEmailAddress",
    "editOnlyInd",
    "b2BCustomerInd",
    "brokerID",
    "delaySendToUtilDate",
    "renewalProductCode",
    "renewalFixPricePerThermCd",
    "renewalFixPricePerTherm",
    "renewalVarPriceAddOnPerTherm",
    "renewalCtrctDurationMonths",
    "renewalCtrctTermDate",
    "sourceSystemReferenceID"
})
@XmlRootElement(name = "EnrollRequest")
public class EnrollRequest {

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
    @XmlElement(name = "MailAddressVerified")
    protected String mailAddressVerified;
    @XmlElement(name = "ServiceAddressVerified")
    protected String serviceAddressVerified;
    @XmlElement(name = "ProductCode")
    protected String productCode;
    @XmlElement(name = "PromoCode")
    protected String promoCode;
    @XmlElement(name = "RAFCode")
    protected String rafCode;
    @XmlElement(name = "EnrolledByUserId")
    protected String enrolledByUserId;
    @XmlElement(name = "AuthorizationCode")
    protected String authorizationCode;
    @XmlElement(name = "AuthorizationLevel")
    protected String authorizationLevel;
    @XmlElement(name = "ChannelID")
    protected String channelID;
    @XmlElement(name = "PromotionCode")
    protected String promotionCode;
    @XmlElement(name = "CampaignID")
    protected String campaignID;
    @XmlElement(name = "WebSiteID")
    protected String webSiteID;
    @XmlElement(name = "CustLeadSourceCode")
    protected String custLeadSourceCode;
    @XmlElement(name = "EnrollConfirmationNumber")
    protected String enrollConfirmationNumber;
    @XmlElement(name = "ActionIfContractExists")
    protected String actionIfContractExists;
    @XmlElement(name = "PreventCancelFeeifContractExists")
    protected String preventCancelFeeifContractExists;
    @XmlElement(name = "BypassCreditCheckInd")
    protected String bypassCreditCheckInd;
    @XmlElement(name = "SoldDate")
    protected String soldDate;
    @XmlElement(name = "BypassCIRInd")
    protected String bypassCIRInd;
    @XmlElement(name = "ExpectedQuoteAmt")
    protected String expectedQuoteAmt;
    @XmlElement(name = "TPVRequiredInd")
    protected String tpvRequiredInd;
    @XmlElement(name = "EmailTypeCode")
    protected String emailTypeCode;
    @XmlElement(name = "AlternateEmailAddress")
    protected String alternateEmailAddress;
    @XmlElement(name = "EditOnlyInd")
    protected String editOnlyInd;
    @XmlElement(name = "B2BCustomerInd")
    protected String b2BCustomerInd;
    @XmlElement(name = "BrokerID")
    protected String brokerID;
    @XmlElement(name = "DelaySendToUtilDate")
    protected String delaySendToUtilDate;
    @XmlElement(name = "RenewalProductCode")
    protected String renewalProductCode;
    @XmlElement(name = "RenewalFixPricePerThermCd")
    protected String renewalFixPricePerThermCd;
    @XmlElement(name = "RenewalFixPricePerTherm")
    protected String renewalFixPricePerTherm;
    @XmlElement(name = "RenewalVarPriceAddOnPerTherm")
    protected String renewalVarPriceAddOnPerTherm;
    @XmlElement(name = "RenewalCtrctDurationMonths")
    protected String renewalCtrctDurationMonths;
    @XmlElement(name = "RenewalCtrctTermDate")
    protected String renewalCtrctTermDate;
    @XmlElement(name = "SourceSystemReferenceID")
    protected String sourceSystemReferenceID;

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
     * Gets the value of the mailAddressVerified property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailAddressVerified() {
        return mailAddressVerified;
    }

    /**
     * Sets the value of the mailAddressVerified property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailAddressVerified(String value) {
        this.mailAddressVerified = value;
    }

    /**
     * Gets the value of the serviceAddressVerified property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceAddressVerified() {
        return serviceAddressVerified;
    }

    /**
     * Sets the value of the serviceAddressVerified property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceAddressVerified(String value) {
        this.serviceAddressVerified = value;
    }

    /**
     * Gets the value of the productCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the promoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the value of the promoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoCode(String value) {
        this.promoCode = value;
    }

    /**
     * Gets the value of the rafCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRAFCode() {
        return rafCode;
    }

    /**
     * Sets the value of the rafCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRAFCode(String value) {
        this.rafCode = value;
    }

    /**
     * Gets the value of the enrolledByUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnrolledByUserId() {
        return enrolledByUserId;
    }

    /**
     * Sets the value of the enrolledByUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnrolledByUserId(String value) {
        this.enrolledByUserId = value;
    }

    /**
     * Gets the value of the authorizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    /**
     * Sets the value of the authorizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationCode(String value) {
        this.authorizationCode = value;
    }

    /**
     * Gets the value of the authorizationLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationLevel() {
        return authorizationLevel;
    }

    /**
     * Sets the value of the authorizationLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationLevel(String value) {
        this.authorizationLevel = value;
    }

    /**
     * Gets the value of the channelID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelID() {
        return channelID;
    }

    /**
     * Sets the value of the channelID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelID(String value) {
        this.channelID = value;
    }

    /**
     * Gets the value of the promotionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionCode() {
        return promotionCode;
    }

    /**
     * Sets the value of the promotionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionCode(String value) {
        this.promotionCode = value;
    }

    /**
     * Gets the value of the campaignID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignID() {
        return campaignID;
    }

    /**
     * Sets the value of the campaignID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignID(String value) {
        this.campaignID = value;
    }

    /**
     * Gets the value of the webSiteID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebSiteID() {
        return webSiteID;
    }

    /**
     * Sets the value of the webSiteID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebSiteID(String value) {
        this.webSiteID = value;
    }

    /**
     * Gets the value of the custLeadSourceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustLeadSourceCode() {
        return custLeadSourceCode;
    }

    /**
     * Sets the value of the custLeadSourceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustLeadSourceCode(String value) {
        this.custLeadSourceCode = value;
    }

    /**
     * Gets the value of the enrollConfirmationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnrollConfirmationNumber() {
        return enrollConfirmationNumber;
    }

    /**
     * Sets the value of the enrollConfirmationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnrollConfirmationNumber(String value) {
        this.enrollConfirmationNumber = value;
    }

    /**
     * Gets the value of the actionIfContractExists property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionIfContractExists() {
        return actionIfContractExists;
    }

    /**
     * Sets the value of the actionIfContractExists property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionIfContractExists(String value) {
        this.actionIfContractExists = value;
    }

    /**
     * Gets the value of the preventCancelFeeifContractExists property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreventCancelFeeifContractExists() {
        return preventCancelFeeifContractExists;
    }

    /**
     * Sets the value of the preventCancelFeeifContractExists property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreventCancelFeeifContractExists(String value) {
        this.preventCancelFeeifContractExists = value;
    }

    /**
     * Gets the value of the bypassCreditCheckInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBypassCreditCheckInd() {
        return bypassCreditCheckInd;
    }

    /**
     * Sets the value of the bypassCreditCheckInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBypassCreditCheckInd(String value) {
        this.bypassCreditCheckInd = value;
    }

    /**
     * Gets the value of the soldDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoldDate() {
        return soldDate;
    }

    /**
     * Sets the value of the soldDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoldDate(String value) {
        this.soldDate = value;
    }

    /**
     * Gets the value of the bypassCIRInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBypassCIRInd() {
        return bypassCIRInd;
    }

    /**
     * Sets the value of the bypassCIRInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBypassCIRInd(String value) {
        this.bypassCIRInd = value;
    }

    /**
     * Gets the value of the expectedQuoteAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpectedQuoteAmt() {
        return expectedQuoteAmt;
    }

    /**
     * Sets the value of the expectedQuoteAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpectedQuoteAmt(String value) {
        this.expectedQuoteAmt = value;
    }

    /**
     * Gets the value of the tpvRequiredInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTPVRequiredInd() {
        return tpvRequiredInd;
    }

    /**
     * Sets the value of the tpvRequiredInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTPVRequiredInd(String value) {
        this.tpvRequiredInd = value;
    }

    /**
     * Gets the value of the emailTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailTypeCode() {
        return emailTypeCode;
    }

    /**
     * Sets the value of the emailTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailTypeCode(String value) {
        this.emailTypeCode = value;
    }

    /**
     * Gets the value of the alternateEmailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateEmailAddress() {
        return alternateEmailAddress;
    }

    /**
     * Sets the value of the alternateEmailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateEmailAddress(String value) {
        this.alternateEmailAddress = value;
    }

    /**
     * Gets the value of the editOnlyInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditOnlyInd() {
        return editOnlyInd;
    }

    /**
     * Sets the value of the editOnlyInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditOnlyInd(String value) {
        this.editOnlyInd = value;
    }

    /**
     * Gets the value of the b2BCustomerInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getB2BCustomerInd() {
        return b2BCustomerInd;
    }

    /**
     * Sets the value of the b2BCustomerInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setB2BCustomerInd(String value) {
        this.b2BCustomerInd = value;
    }

    /**
     * Gets the value of the brokerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrokerID() {
        return brokerID;
    }

    /**
     * Sets the value of the brokerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrokerID(String value) {
        this.brokerID = value;
    }

    /**
     * Gets the value of the delaySendToUtilDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelaySendToUtilDate() {
        return delaySendToUtilDate;
    }

    /**
     * Sets the value of the delaySendToUtilDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelaySendToUtilDate(String value) {
        this.delaySendToUtilDate = value;
    }

    /**
     * Gets the value of the renewalProductCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalProductCode() {
        return renewalProductCode;
    }

    /**
     * Sets the value of the renewalProductCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalProductCode(String value) {
        this.renewalProductCode = value;
    }

    /**
     * Gets the value of the renewalFixPricePerThermCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalFixPricePerThermCd() {
        return renewalFixPricePerThermCd;
    }

    /**
     * Sets the value of the renewalFixPricePerThermCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalFixPricePerThermCd(String value) {
        this.renewalFixPricePerThermCd = value;
    }

    /**
     * Gets the value of the renewalFixPricePerTherm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalFixPricePerTherm() {
        return renewalFixPricePerTherm;
    }

    /**
     * Sets the value of the renewalFixPricePerTherm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalFixPricePerTherm(String value) {
        this.renewalFixPricePerTherm = value;
    }

    /**
     * Gets the value of the renewalVarPriceAddOnPerTherm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalVarPriceAddOnPerTherm() {
        return renewalVarPriceAddOnPerTherm;
    }

    /**
     * Sets the value of the renewalVarPriceAddOnPerTherm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalVarPriceAddOnPerTherm(String value) {
        this.renewalVarPriceAddOnPerTherm = value;
    }

    /**
     * Gets the value of the renewalCtrctDurationMonths property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalCtrctDurationMonths() {
        return renewalCtrctDurationMonths;
    }

    /**
     * Sets the value of the renewalCtrctDurationMonths property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalCtrctDurationMonths(String value) {
        this.renewalCtrctDurationMonths = value;
    }

    /**
     * Gets the value of the renewalCtrctTermDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalCtrctTermDate() {
        return renewalCtrctTermDate;
    }

    /**
     * Sets the value of the renewalCtrctTermDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalCtrctTermDate(String value) {
        this.renewalCtrctTermDate = value;
    }

    /**
     * Gets the value of the sourceSystemReferenceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceSystemReferenceID() {
        return sourceSystemReferenceID;
    }

    /**
     * Sets the value of the sourceSystemReferenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceSystemReferenceID(String value) {
        this.sourceSystemReferenceID = value;
    }

}
