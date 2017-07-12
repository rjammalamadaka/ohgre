
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
 *         &lt;element name="channel_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pre_enroll_prvdr_sold_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vend_trans_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enroll_user_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ldc_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auth_acct_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auth_last_4_ssn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auth_area_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auth_phone_nbr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expctd_move_in_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estimated_first_flow_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rate_class" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bus_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srvc_addr_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srvc_addr_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srvc_city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srvc_st_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srvc_zip_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srvc_zip_cd_4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail_addr_1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail_addr_2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail_st_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail_city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail_zip_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail_zip_cd_4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alt_area_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alt_phone_nbr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="e_mail_addr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ignite_ldc_premise_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enrolled_product_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ctrct_price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fix_price_per_therm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="var_price_basis_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="var_price_add_on_per_therm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="combo_fix_price_pct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="var_cap_limit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mnthly_cap_cost_chrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="var_cap_cost_per_therm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mnthly_cust_chrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disc_chrg_per_bill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="combo_product_alloc_type_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srvc_addr_validation_ind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mail_addr_validation_ind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="credit_validation_ind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promo_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="note_text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="add_with_error_ind" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "channelId",
    "preEnrollPrvdrSoldDate",
    "vendTransId",
    "enrollUserId",
    "ldcCd",
    "authAcctId",
    "authLast4Ssn",
    "authAreaCd",
    "authPhoneNbr",
    "expctdMoveInDate",
    "estimatedFirstFlowDate",
    "rateClass",
    "firstName",
    "lastName",
    "busName",
    "srvcAddr1",
    "srvcAddr2",
    "srvcCity",
    "srvcStCd",
    "srvcZipCd",
    "srvcZipCd4",
    "mailAddr1",
    "mailAddr2",
    "mailStCd",
    "mailCity",
    "mailZipCd",
    "mailZipCd4",
    "altAreaCd",
    "altPhoneNbr",
    "eMailAddr",
    "languageCd",
    "igniteLdcPremiseId",
    "enrolledProductCd",
    "ctrctPrice",
    "fixPricePerTherm",
    "varPriceBasisCd",
    "varPriceAddOnPerTherm",
    "comboFixPricePct",
    "varCapLimit",
    "mnthlyCapCostChrg",
    "varCapCostPerTherm",
    "mnthlyCustChrg",
    "discChrgPerBill",
    "comboProductAllocTypeCd",
    "srvcAddrValidationInd",
    "mailAddrValidationInd",
    "creditValidationInd",
    "promoCd",
    "noteText",
    "addWithErrorInd"
})
@XmlRootElement(name = "PreenrollmentRequest")
public class PreenrollmentRequest {

    @XmlElement(name = "channel_id")
    protected String channelId;
    @XmlElement(name = "pre_enroll_prvdr_sold_date")
    protected String preEnrollPrvdrSoldDate;
    @XmlElement(name = "vend_trans_id")
    protected String vendTransId;
    @XmlElement(name = "enroll_user_id")
    protected String enrollUserId;
    @XmlElement(name = "ldc_cd")
    protected String ldcCd;
    @XmlElement(name = "auth_acct_id")
    protected String authAcctId;
    @XmlElement(name = "auth_last_4_ssn")
    protected String authLast4Ssn;
    @XmlElement(name = "auth_area_cd")
    protected String authAreaCd;
    @XmlElement(name = "auth_phone_nbr")
    protected String authPhoneNbr;
    @XmlElement(name = "expctd_move_in_date")
    protected String expctdMoveInDate;
    @XmlElement(name = "estimated_first_flow_date")
    protected String estimatedFirstFlowDate;
    @XmlElement(name = "rate_class")
    protected String rateClass;
    @XmlElement(name = "first_name")
    protected String firstName;
    @XmlElement(name = "last_name")
    protected String lastName;
    @XmlElement(name = "bus_name")
    protected String busName;
    @XmlElement(name = "srvc_addr_1")
    protected String srvcAddr1;
    @XmlElement(name = "srvc_addr_2")
    protected String srvcAddr2;
    @XmlElement(name = "srvc_city")
    protected String srvcCity;
    @XmlElement(name = "srvc_st_cd")
    protected String srvcStCd;
    @XmlElement(name = "srvc_zip_cd")
    protected String srvcZipCd;
    @XmlElement(name = "srvc_zip_cd_4")
    protected String srvcZipCd4;
    @XmlElement(name = "mail_addr_1")
    protected String mailAddr1;
    @XmlElement(name = "mail_addr_2")
    protected String mailAddr2;
    @XmlElement(name = "mail_st_cd")
    protected String mailStCd;
    @XmlElement(name = "mail_city")
    protected String mailCity;
    @XmlElement(name = "mail_zip_cd")
    protected String mailZipCd;
    @XmlElement(name = "mail_zip_cd_4")
    protected String mailZipCd4;
    @XmlElement(name = "alt_area_cd")
    protected String altAreaCd;
    @XmlElement(name = "alt_phone_nbr")
    protected String altPhoneNbr;
    @XmlElement(name = "e_mail_addr")
    protected String eMailAddr;
    @XmlElement(name = "language_cd")
    protected String languageCd;
    @XmlElement(name = "ignite_ldc_premise_id")
    protected String igniteLdcPremiseId;
    @XmlElement(name = "enrolled_product_cd")
    protected String enrolledProductCd;
    @XmlElement(name = "ctrct_price")
    protected String ctrctPrice;
    @XmlElement(name = "fix_price_per_therm")
    protected String fixPricePerTherm;
    @XmlElement(name = "var_price_basis_cd")
    protected String varPriceBasisCd;
    @XmlElement(name = "var_price_add_on_per_therm")
    protected String varPriceAddOnPerTherm;
    @XmlElement(name = "combo_fix_price_pct")
    protected String comboFixPricePct;
    @XmlElement(name = "var_cap_limit")
    protected String varCapLimit;
    @XmlElement(name = "mnthly_cap_cost_chrg")
    protected String mnthlyCapCostChrg;
    @XmlElement(name = "var_cap_cost_per_therm")
    protected String varCapCostPerTherm;
    @XmlElement(name = "mnthly_cust_chrg")
    protected String mnthlyCustChrg;
    @XmlElement(name = "disc_chrg_per_bill")
    protected String discChrgPerBill;
    @XmlElement(name = "combo_product_alloc_type_cd")
    protected String comboProductAllocTypeCd;
    @XmlElement(name = "srvc_addr_validation_ind")
    protected String srvcAddrValidationInd;
    @XmlElement(name = "mail_addr_validation_ind")
    protected String mailAddrValidationInd;
    @XmlElement(name = "credit_validation_ind")
    protected String creditValidationInd;
    @XmlElement(name = "promo_cd")
    protected String promoCd;
    @XmlElement(name = "note_text")
    protected String noteText;
    @XmlElement(name = "add_with_error_ind")
    protected String addWithErrorInd;

    /**
     * Gets the value of the channelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Sets the value of the channelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelId(String value) {
        this.channelId = value;
    }

    /**
     * Gets the value of the preEnrollPrvdrSoldDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreEnrollPrvdrSoldDate() {
        return preEnrollPrvdrSoldDate;
    }

    /**
     * Sets the value of the preEnrollPrvdrSoldDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreEnrollPrvdrSoldDate(String value) {
        this.preEnrollPrvdrSoldDate = value;
    }

    /**
     * Gets the value of the vendTransId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendTransId() {
        return vendTransId;
    }

    /**
     * Sets the value of the vendTransId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendTransId(String value) {
        this.vendTransId = value;
    }

    /**
     * Gets the value of the enrollUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnrollUserId() {
        return enrollUserId;
    }

    /**
     * Sets the value of the enrollUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnrollUserId(String value) {
        this.enrollUserId = value;
    }

    /**
     * Gets the value of the ldcCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLdcCd() {
        return ldcCd;
    }

    /**
     * Sets the value of the ldcCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLdcCd(String value) {
        this.ldcCd = value;
    }

    /**
     * Gets the value of the authAcctId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthAcctId() {
        return authAcctId;
    }

    /**
     * Sets the value of the authAcctId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthAcctId(String value) {
        this.authAcctId = value;
    }

    /**
     * Gets the value of the authLast4Ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthLast4Ssn() {
        return authLast4Ssn;
    }

    /**
     * Sets the value of the authLast4Ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthLast4Ssn(String value) {
        this.authLast4Ssn = value;
    }

    /**
     * Gets the value of the authAreaCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthAreaCd() {
        return authAreaCd;
    }

    /**
     * Sets the value of the authAreaCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthAreaCd(String value) {
        this.authAreaCd = value;
    }

    /**
     * Gets the value of the authPhoneNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthPhoneNbr() {
        return authPhoneNbr;
    }

    /**
     * Sets the value of the authPhoneNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthPhoneNbr(String value) {
        this.authPhoneNbr = value;
    }

    /**
     * Gets the value of the expctdMoveInDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpctdMoveInDate() {
        return expctdMoveInDate;
    }

    /**
     * Sets the value of the expctdMoveInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpctdMoveInDate(String value) {
        this.expctdMoveInDate = value;
    }

    /**
     * Gets the value of the estimatedFirstFlowDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstimatedFirstFlowDate() {
        return estimatedFirstFlowDate;
    }

    /**
     * Sets the value of the estimatedFirstFlowDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstimatedFirstFlowDate(String value) {
        this.estimatedFirstFlowDate = value;
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
     * Gets the value of the busName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusName() {
        return busName;
    }

    /**
     * Sets the value of the busName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusName(String value) {
        this.busName = value;
    }

    /**
     * Gets the value of the srvcAddr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrvcAddr1() {
        return srvcAddr1;
    }

    /**
     * Sets the value of the srvcAddr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrvcAddr1(String value) {
        this.srvcAddr1 = value;
    }

    /**
     * Gets the value of the srvcAddr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrvcAddr2() {
        return srvcAddr2;
    }

    /**
     * Sets the value of the srvcAddr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrvcAddr2(String value) {
        this.srvcAddr2 = value;
    }

    /**
     * Gets the value of the srvcCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrvcCity() {
        return srvcCity;
    }

    /**
     * Sets the value of the srvcCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrvcCity(String value) {
        this.srvcCity = value;
    }

    /**
     * Gets the value of the srvcStCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrvcStCd() {
        return srvcStCd;
    }

    /**
     * Sets the value of the srvcStCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrvcStCd(String value) {
        this.srvcStCd = value;
    }

    /**
     * Gets the value of the srvcZipCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrvcZipCd() {
        return srvcZipCd;
    }

    /**
     * Sets the value of the srvcZipCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrvcZipCd(String value) {
        this.srvcZipCd = value;
    }

    /**
     * Gets the value of the srvcZipCd4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrvcZipCd4() {
        return srvcZipCd4;
    }

    /**
     * Sets the value of the srvcZipCd4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrvcZipCd4(String value) {
        this.srvcZipCd4 = value;
    }

    /**
     * Gets the value of the mailAddr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailAddr1() {
        return mailAddr1;
    }

    /**
     * Sets the value of the mailAddr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailAddr1(String value) {
        this.mailAddr1 = value;
    }

    /**
     * Gets the value of the mailAddr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailAddr2() {
        return mailAddr2;
    }

    /**
     * Sets the value of the mailAddr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailAddr2(String value) {
        this.mailAddr2 = value;
    }

    /**
     * Gets the value of the mailStCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailStCd() {
        return mailStCd;
    }

    /**
     * Sets the value of the mailStCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailStCd(String value) {
        this.mailStCd = value;
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
     * Gets the value of the mailZipCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailZipCd() {
        return mailZipCd;
    }

    /**
     * Sets the value of the mailZipCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailZipCd(String value) {
        this.mailZipCd = value;
    }

    /**
     * Gets the value of the mailZipCd4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailZipCd4() {
        return mailZipCd4;
    }

    /**
     * Sets the value of the mailZipCd4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailZipCd4(String value) {
        this.mailZipCd4 = value;
    }

    /**
     * Gets the value of the altAreaCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAltAreaCd() {
        return altAreaCd;
    }

    /**
     * Sets the value of the altAreaCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAltAreaCd(String value) {
        this.altAreaCd = value;
    }

    /**
     * Gets the value of the altPhoneNbr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAltPhoneNbr() {
        return altPhoneNbr;
    }

    /**
     * Sets the value of the altPhoneNbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAltPhoneNbr(String value) {
        this.altPhoneNbr = value;
    }

    /**
     * Gets the value of the eMailAddr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMailAddr() {
        return eMailAddr;
    }

    /**
     * Sets the value of the eMailAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMailAddr(String value) {
        this.eMailAddr = value;
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
     * Gets the value of the igniteLdcPremiseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIgniteLdcPremiseId() {
        return igniteLdcPremiseId;
    }

    /**
     * Sets the value of the igniteLdcPremiseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIgniteLdcPremiseId(String value) {
        this.igniteLdcPremiseId = value;
    }

    /**
     * Gets the value of the enrolledProductCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnrolledProductCd() {
        return enrolledProductCd;
    }

    /**
     * Sets the value of the enrolledProductCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnrolledProductCd(String value) {
        this.enrolledProductCd = value;
    }

    /**
     * Gets the value of the ctrctPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtrctPrice() {
        return ctrctPrice;
    }

    /**
     * Sets the value of the ctrctPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtrctPrice(String value) {
        this.ctrctPrice = value;
    }

    /**
     * Gets the value of the fixPricePerTherm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixPricePerTherm() {
        return fixPricePerTherm;
    }

    /**
     * Sets the value of the fixPricePerTherm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixPricePerTherm(String value) {
        this.fixPricePerTherm = value;
    }

    /**
     * Gets the value of the varPriceBasisCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVarPriceBasisCd() {
        return varPriceBasisCd;
    }

    /**
     * Sets the value of the varPriceBasisCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVarPriceBasisCd(String value) {
        this.varPriceBasisCd = value;
    }

    /**
     * Gets the value of the varPriceAddOnPerTherm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVarPriceAddOnPerTherm() {
        return varPriceAddOnPerTherm;
    }

    /**
     * Sets the value of the varPriceAddOnPerTherm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVarPriceAddOnPerTherm(String value) {
        this.varPriceAddOnPerTherm = value;
    }

    /**
     * Gets the value of the comboFixPricePct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboFixPricePct() {
        return comboFixPricePct;
    }

    /**
     * Sets the value of the comboFixPricePct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboFixPricePct(String value) {
        this.comboFixPricePct = value;
    }

    /**
     * Gets the value of the varCapLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVarCapLimit() {
        return varCapLimit;
    }

    /**
     * Sets the value of the varCapLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVarCapLimit(String value) {
        this.varCapLimit = value;
    }

    /**
     * Gets the value of the mnthlyCapCostChrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMnthlyCapCostChrg() {
        return mnthlyCapCostChrg;
    }

    /**
     * Sets the value of the mnthlyCapCostChrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMnthlyCapCostChrg(String value) {
        this.mnthlyCapCostChrg = value;
    }

    /**
     * Gets the value of the varCapCostPerTherm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVarCapCostPerTherm() {
        return varCapCostPerTherm;
    }

    /**
     * Sets the value of the varCapCostPerTherm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVarCapCostPerTherm(String value) {
        this.varCapCostPerTherm = value;
    }

    /**
     * Gets the value of the mnthlyCustChrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMnthlyCustChrg() {
        return mnthlyCustChrg;
    }

    /**
     * Sets the value of the mnthlyCustChrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMnthlyCustChrg(String value) {
        this.mnthlyCustChrg = value;
    }

    /**
     * Gets the value of the discChrgPerBill property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscChrgPerBill() {
        return discChrgPerBill;
    }

    /**
     * Sets the value of the discChrgPerBill property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscChrgPerBill(String value) {
        this.discChrgPerBill = value;
    }

    /**
     * Gets the value of the comboProductAllocTypeCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComboProductAllocTypeCd() {
        return comboProductAllocTypeCd;
    }

    /**
     * Sets the value of the comboProductAllocTypeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComboProductAllocTypeCd(String value) {
        this.comboProductAllocTypeCd = value;
    }

    /**
     * Gets the value of the srvcAddrValidationInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrvcAddrValidationInd() {
        return srvcAddrValidationInd;
    }

    /**
     * Sets the value of the srvcAddrValidationInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrvcAddrValidationInd(String value) {
        this.srvcAddrValidationInd = value;
    }

    /**
     * Gets the value of the mailAddrValidationInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailAddrValidationInd() {
        return mailAddrValidationInd;
    }

    /**
     * Sets the value of the mailAddrValidationInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailAddrValidationInd(String value) {
        this.mailAddrValidationInd = value;
    }

    /**
     * Gets the value of the creditValidationInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditValidationInd() {
        return creditValidationInd;
    }

    /**
     * Sets the value of the creditValidationInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditValidationInd(String value) {
        this.creditValidationInd = value;
    }

    /**
     * Gets the value of the promoCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoCd() {
        return promoCd;
    }

    /**
     * Sets the value of the promoCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoCd(String value) {
        this.promoCd = value;
    }

    /**
     * Gets the value of the noteText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteText() {
        return noteText;
    }

    /**
     * Sets the value of the noteText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteText(String value) {
        this.noteText = value;
    }

    /**
     * Gets the value of the addWithErrorInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddWithErrorInd() {
        return addWithErrorInd;
    }

    /**
     * Sets the value of the addWithErrorInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddWithErrorInd(String value) {
        this.addWithErrorInd = value;
    }

}
