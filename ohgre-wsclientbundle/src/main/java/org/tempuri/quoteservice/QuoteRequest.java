
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
 *         &lt;element name="LDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MeterNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceZipPlusFour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RateClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MeterReadDayCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MuniTaxAuthCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PremiseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EstimatedMoveInDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SoldDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnrolledByUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CampaignID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WebSiteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChannelID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditCheckRequestedInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ldc",
    "account",
    "phoneNumber",
    "ssn",
    "meterNumber",
    "primaryProduct",
    "serviceAddress",
    "serviceCity",
    "serviceState",
    "serviceZipCode",
    "serviceZipPlusFour",
    "rateClass",
    "meterReadDayCd",
    "muniTaxAuthCd",
    "premiseId",
    "estimatedMoveInDate",
    "soldDate",
    "enrolledByUserId",
    "authorizationCode",
    "authorizationLevel",
    "promotionCode",
    "campaignID",
    "webSiteID",
    "channelID",
    "creditCheckRequestedInd"
})
@XmlRootElement(name = "QuoteRequest")
public class QuoteRequest {

    @XmlElement(name = "LDC")
    protected String ldc;
    @XmlElement(name = "Account")
    protected String account;
    @XmlElement(name = "PhoneNumber")
    protected String phoneNumber;
    @XmlElement(name = "SSN")
    protected String ssn;
    @XmlElement(name = "MeterNumber")
    protected String meterNumber;
    @XmlElement(name = "PrimaryProduct")
    protected String primaryProduct;
    @XmlElement(name = "ServiceAddress")
    protected String serviceAddress;
    @XmlElement(name = "ServiceCity")
    protected String serviceCity;
    @XmlElement(name = "ServiceState")
    protected String serviceState;
    @XmlElement(name = "ServiceZipCode")
    protected String serviceZipCode;
    @XmlElement(name = "ServiceZipPlusFour")
    protected String serviceZipPlusFour;
    @XmlElement(name = "RateClass")
    protected String rateClass;
    @XmlElement(name = "MeterReadDayCd")
    protected String meterReadDayCd;
    @XmlElement(name = "MuniTaxAuthCd")
    protected String muniTaxAuthCd;
    @XmlElement(name = "PremiseId")
    protected String premiseId;
    @XmlElement(name = "EstimatedMoveInDate")
    protected String estimatedMoveInDate;
    @XmlElement(name = "SoldDate")
    protected String soldDate;
    @XmlElement(name = "EnrolledByUserId")
    protected String enrolledByUserId;
    @XmlElement(name = "AuthorizationCode")
    protected String authorizationCode;
    @XmlElement(name = "AuthorizationLevel")
    protected String authorizationLevel;
    @XmlElement(name = "PromotionCode")
    protected String promotionCode;
    @XmlElement(name = "CampaignID")
    protected String campaignID;
    @XmlElement(name = "WebSiteID")
    protected String webSiteID;
    @XmlElement(name = "ChannelID")
    protected String channelID;
    @XmlElement(name = "CreditCheckRequestedInd")
    protected String creditCheckRequestedInd;

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
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSN(String value) {
        this.ssn = value;
    }

    /**
     * Gets the value of the meterNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeterNumber() {
        return meterNumber;
    }

    /**
     * Sets the value of the meterNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeterNumber(String value) {
        this.meterNumber = value;
    }

    /**
     * Gets the value of the primaryProduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryProduct() {
        return primaryProduct;
    }

    /**
     * Sets the value of the primaryProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryProduct(String value) {
        this.primaryProduct = value;
    }

    /**
     * Gets the value of the serviceAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceAddress() {
        return serviceAddress;
    }

    /**
     * Sets the value of the serviceAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceAddress(String value) {
        this.serviceAddress = value;
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
     * Gets the value of the serviceState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceState() {
        return serviceState;
    }

    /**
     * Sets the value of the serviceState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceState(String value) {
        this.serviceState = value;
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
     * Gets the value of the rateClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateClass() {
        return rateClass;
    }

    /**
     * Sets the value of the rateClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateClass(String value) {
        this.rateClass = value;
    }

    /**
     * Gets the value of the meterReadDayCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeterReadDayCd() {
        return meterReadDayCd;
    }

    /**
     * Sets the value of the meterReadDayCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeterReadDayCd(String value) {
        this.meterReadDayCd = value;
    }

    /**
     * Gets the value of the muniTaxAuthCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMuniTaxAuthCd() {
        return muniTaxAuthCd;
    }

    /**
     * Sets the value of the muniTaxAuthCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMuniTaxAuthCd(String value) {
        this.muniTaxAuthCd = value;
    }

    /**
     * Gets the value of the premiseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiseId() {
        return premiseId;
    }

    /**
     * Sets the value of the premiseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiseId(String value) {
        this.premiseId = value;
    }

    /**
     * Gets the value of the estimatedMoveInDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstimatedMoveInDate() {
        return estimatedMoveInDate;
    }

    /**
     * Sets the value of the estimatedMoveInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstimatedMoveInDate(String value) {
        this.estimatedMoveInDate = value;
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
     * Gets the value of the creditCheckRequestedInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCheckRequestedInd() {
        return creditCheckRequestedInd;
    }

    /**
     * Sets the value of the creditCheckRequestedInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCheckRequestedInd(String value) {
        this.creditCheckRequestedInd = value;
    }

}
