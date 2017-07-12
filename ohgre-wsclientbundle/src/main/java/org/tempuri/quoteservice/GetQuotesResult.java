
package org.tempuri.quoteservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="ResponseStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerNodeCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ComtiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CustID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Premise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BusinessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MailAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MailAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MailCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MailCounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MailStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MailZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MailZipPlusFour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceCounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceZipPlusFour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DoNotCallInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DoNotMailInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EmailPrefTransactionalCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EmailPrefSSEPromotionalCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EmailPrefAffiliatePromotionalCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EmailPref3rdPartyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EmailPrefNonTransactionalCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LanguageCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RateClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="MeterNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CustomerSelectInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ExistingCustomerInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ActiveContractInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="AccountStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LDCDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="B2BCustomerInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CampaignID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="WebSiteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ChannelID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CreditCheckRequiredInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CreditCheckStatCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Message" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="MsgLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ProductNodeCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Product" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ProductDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="QuoteDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="EstimatedFirstFlowDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CanQuoteInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ContractPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FixedPricePerThermCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FixedPricePerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="VarPriceBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="VarPriceBasisAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="VarPriceAddOnPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="VarPriceTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ComboFixedPricePct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="VarCapLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MonthlyCapCostChrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="VarCapCostPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MonthlyCustChrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DiscChrgPerBill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SFBWinterCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SFBWinterAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SFBSummerCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SFBSummerAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ComboProductAllocTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CtrctDurationMonths" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CtrctTermDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PriceChangeFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PPCEarlyTermChargeAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="EarlyTermChargeAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Message" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="MsgLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "responseStatus",
    "responseMessage",
    "customerNodeCnt",
    "comtiKey",
    "customer"
})
@XmlRootElement(name = "GetQuotesResult")
public class GetQuotesResult {

    @XmlElement(name = "ResponseStatus")
    protected String responseStatus;
    @XmlElement(name = "ResponseMessage")
    protected String responseMessage;
    @XmlElement(name = "CustomerNodeCnt")
    protected String customerNodeCnt;
    @XmlElement(name = "ComtiKey")
    protected String comtiKey;
    @XmlElement(name = "Customer")
    protected List<GetQuotesResult.Customer> customer;

    /**
     * Gets the value of the responseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the value of the responseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseStatus(String value) {
        this.responseStatus = value;
    }

    /**
     * Gets the value of the responseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Sets the value of the responseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseMessage(String value) {
        this.responseMessage = value;
    }

    /**
     * Gets the value of the customerNodeCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerNodeCnt() {
        return customerNodeCnt;
    }

    /**
     * Sets the value of the customerNodeCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerNodeCnt(String value) {
        this.customerNodeCnt = value;
    }

    /**
     * Gets the value of the comtiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComtiKey() {
        return comtiKey;
    }

    /**
     * Sets the value of the comtiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComtiKey(String value) {
        this.comtiKey = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetQuotesResult.Customer }
     * 
     * 
     */
    public List<GetQuotesResult.Customer> getCustomer() {
        if (customer == null) {
            customer = new ArrayList<GetQuotesResult.Customer>();
        }
        return this.customer;
    }


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
     *         &lt;element name="RateClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="MeterNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CustomerSelectInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ExistingCustomerInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ActiveContractInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="AccountStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="LDCDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="B2BCustomerInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CampaignID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="WebSiteID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ChannelID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CreditCheckRequiredInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CreditCheckStatCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Message" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="MsgLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ProductNodeCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Product" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ProductDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="QuoteDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="EstimatedFirstFlowDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CanQuoteInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ContractPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FixedPricePerThermCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FixedPricePerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="VarPriceBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="VarPriceBasisAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="VarPriceAddOnPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="VarPriceTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ComboFixedPricePct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="VarCapLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MonthlyCapCostChrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="VarCapCostPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MonthlyCustChrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DiscChrgPerBill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SFBWinterCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SFBWinterAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SFBSummerCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SFBSummerAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ComboProductAllocTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CtrctDurationMonths" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CtrctTermDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PriceChangeFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PPCEarlyTermChargeAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="EarlyTermChargeAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Message" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="MsgLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "rateClass",
        "meterNumber",
        "customerSelectInd",
        "existingCustomerInd",
        "activeContractInd",
        "accountStatus",
        "ldcDesc",
        "b2BCustomerInd",
        "promotionCode",
        "campaignID",
        "webSiteID",
        "channelID",
        "creditCheckRequiredInd",
        "creditCheckStatCd",
        "message",
        "productNodeCnt",
        "product"
    })
    public static class Customer {

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
        @XmlElement(name = "RateClass")
        protected String rateClass;
        @XmlElement(name = "MeterNumber")
        protected String meterNumber;
        @XmlElement(name = "CustomerSelectInd")
        protected String customerSelectInd;
        @XmlElement(name = "ExistingCustomerInd")
        protected String existingCustomerInd;
        @XmlElement(name = "ActiveContractInd")
        protected String activeContractInd;
        @XmlElement(name = "AccountStatus")
        protected String accountStatus;
        @XmlElement(name = "LDCDesc")
        protected String ldcDesc;
        @XmlElement(name = "B2BCustomerInd")
        protected String b2BCustomerInd;
        @XmlElement(name = "PromotionCode")
        protected String promotionCode;
        @XmlElement(name = "CampaignID")
        protected String campaignID;
        @XmlElement(name = "WebSiteID")
        protected String webSiteID;
        @XmlElement(name = "ChannelID")
        protected String channelID;
        @XmlElement(name = "CreditCheckRequiredInd")
        protected String creditCheckRequiredInd;
        @XmlElement(name = "CreditCheckStatCd")
        protected String creditCheckStatCd;
        @XmlElement(name = "Message")
        protected List<GetQuotesResult.Customer.Message> message;
        @XmlElement(name = "ProductNodeCnt")
        protected String productNodeCnt;
        @XmlElement(name = "Product")
        protected List<GetQuotesResult.Customer.Product> product;

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
         * Gets the value of the customerSelectInd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCustomerSelectInd() {
            return customerSelectInd;
        }

        /**
         * Sets the value of the customerSelectInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCustomerSelectInd(String value) {
            this.customerSelectInd = value;
        }

        /**
         * Gets the value of the existingCustomerInd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExistingCustomerInd() {
            return existingCustomerInd;
        }

        /**
         * Sets the value of the existingCustomerInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExistingCustomerInd(String value) {
            this.existingCustomerInd = value;
        }

        /**
         * Gets the value of the activeContractInd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getActiveContractInd() {
            return activeContractInd;
        }

        /**
         * Sets the value of the activeContractInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setActiveContractInd(String value) {
            this.activeContractInd = value;
        }

        /**
         * Gets the value of the accountStatus property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccountStatus() {
            return accountStatus;
        }

        /**
         * Sets the value of the accountStatus property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccountStatus(String value) {
            this.accountStatus = value;
        }

        /**
         * Gets the value of the ldcDesc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLDCDesc() {
            return ldcDesc;
        }

        /**
         * Sets the value of the ldcDesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLDCDesc(String value) {
            this.ldcDesc = value;
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
         * Gets the value of the creditCheckRequiredInd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCreditCheckRequiredInd() {
            return creditCheckRequiredInd;
        }

        /**
         * Sets the value of the creditCheckRequiredInd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCreditCheckRequiredInd(String value) {
            this.creditCheckRequiredInd = value;
        }

        /**
         * Gets the value of the creditCheckStatCd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCreditCheckStatCd() {
            return creditCheckStatCd;
        }

        /**
         * Sets the value of the creditCheckStatCd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCreditCheckStatCd(String value) {
            this.creditCheckStatCd = value;
        }

        /**
         * Gets the value of the message property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the message property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMessage().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetQuotesResult.Customer.Message }
         * 
         * 
         */
        public List<GetQuotesResult.Customer.Message> getMessage() {
            if (message == null) {
                message = new ArrayList<GetQuotesResult.Customer.Message>();
            }
            return this.message;
        }

        /**
         * Gets the value of the productNodeCnt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProductNodeCnt() {
            return productNodeCnt;
        }

        /**
         * Sets the value of the productNodeCnt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProductNodeCnt(String value) {
            this.productNodeCnt = value;
        }

        /**
         * Gets the value of the product property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the product property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProduct().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetQuotesResult.Customer.Product }
         * 
         * 
         */
        public List<GetQuotesResult.Customer.Product> getProduct() {
            if (product == null) {
                product = new ArrayList<GetQuotesResult.Customer.Product>();
            }
            return this.product;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="MsgLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Message {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "MsgLevel")
            protected String msgLevel;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the msgLevel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMsgLevel() {
                return msgLevel;
            }

            /**
             * Sets the value of the msgLevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMsgLevel(String value) {
                this.msgLevel = value;
            }

        }


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
         *         &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ProductDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="QuoteDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="EstimatedFirstFlowDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CanQuoteInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ContractPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FixedPricePerThermCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FixedPricePerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="VarPriceBasisCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="VarPriceBasisAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="VarPriceAddOnPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="VarPriceTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ComboFixedPricePct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="VarCapLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MonthlyCapCostChrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="VarCapCostPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MonthlyCustChrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DiscChrgPerBill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SFBWinterCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SFBWinterAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SFBSummerCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SFBSummerAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ComboProductAllocTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CtrctDurationMonths" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CtrctTermDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PriceChangeFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PPCEarlyTermChargeAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="EarlyTermChargeAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Message" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="MsgLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "productCode",
            "productDescription",
            "quoteDescription",
            "estimatedFirstFlowDate",
            "canQuoteInd",
            "contractPrice",
            "fixedPricePerThermCd",
            "fixedPricePerTherm",
            "varPriceBasisCd",
            "varPriceBasisAmt",
            "varPriceAddOnPerTherm",
            "varPriceTotal",
            "comboFixedPricePct",
            "varCapLimit",
            "monthlyCapCostChrg",
            "varCapCostPerTherm",
            "monthlyCustChrg",
            "discChrgPerBill",
            "sfbWinterCnt",
            "sfbWinterAmt",
            "sfbSummerCnt",
            "sfbSummerAmt",
            "comboProductAllocTypeCd",
            "ctrctDurationMonths",
            "ctrctTermDate",
            "priceChangeFrequency",
            "ppcEarlyTermChargeAmt",
            "earlyTermChargeAmt",
            "message"
        })
        public static class Product {

            @XmlElement(name = "ProductCode")
            protected String productCode;
            @XmlElement(name = "ProductDescription")
            protected String productDescription;
            @XmlElement(name = "QuoteDescription")
            protected String quoteDescription;
            @XmlElement(name = "EstimatedFirstFlowDate")
            protected String estimatedFirstFlowDate;
            @XmlElement(name = "CanQuoteInd")
            protected String canQuoteInd;
            @XmlElement(name = "ContractPrice")
            protected String contractPrice;
            @XmlElement(name = "FixedPricePerThermCd")
            protected String fixedPricePerThermCd;
            @XmlElement(name = "FixedPricePerTherm")
            protected String fixedPricePerTherm;
            @XmlElement(name = "VarPriceBasisCd")
            protected String varPriceBasisCd;
            @XmlElement(name = "VarPriceBasisAmt")
            protected String varPriceBasisAmt;
            @XmlElement(name = "VarPriceAddOnPerTherm")
            protected String varPriceAddOnPerTherm;
            @XmlElement(name = "VarPriceTotal")
            protected String varPriceTotal;
            @XmlElement(name = "ComboFixedPricePct")
            protected String comboFixedPricePct;
            @XmlElement(name = "VarCapLimit")
            protected String varCapLimit;
            @XmlElement(name = "MonthlyCapCostChrg")
            protected String monthlyCapCostChrg;
            @XmlElement(name = "VarCapCostPerTherm")
            protected String varCapCostPerTherm;
            @XmlElement(name = "MonthlyCustChrg")
            protected String monthlyCustChrg;
            @XmlElement(name = "DiscChrgPerBill")
            protected String discChrgPerBill;
            @XmlElement(name = "SFBWinterCnt")
            protected String sfbWinterCnt;
            @XmlElement(name = "SFBWinterAmt")
            protected String sfbWinterAmt;
            @XmlElement(name = "SFBSummerCnt")
            protected String sfbSummerCnt;
            @XmlElement(name = "SFBSummerAmt")
            protected String sfbSummerAmt;
            @XmlElement(name = "ComboProductAllocTypeCd")
            protected String comboProductAllocTypeCd;
            @XmlElement(name = "CtrctDurationMonths")
            protected String ctrctDurationMonths;
            @XmlElement(name = "CtrctTermDate")
            protected String ctrctTermDate;
            @XmlElement(name = "PriceChangeFrequency")
            protected String priceChangeFrequency;
            @XmlElement(name = "PPCEarlyTermChargeAmt")
            protected String ppcEarlyTermChargeAmt;
            @XmlElement(name = "EarlyTermChargeAmt")
            protected String earlyTermChargeAmt;
            @XmlElement(name = "Message")
            protected List<GetQuotesResult.Customer.Product.Message> message;

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
             * Gets the value of the productDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProductDescription() {
                return productDescription;
            }

            /**
             * Sets the value of the productDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProductDescription(String value) {
                this.productDescription = value;
            }

            /**
             * Gets the value of the quoteDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuoteDescription() {
                return quoteDescription;
            }

            /**
             * Sets the value of the quoteDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuoteDescription(String value) {
                this.quoteDescription = value;
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
             * Gets the value of the canQuoteInd property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCanQuoteInd() {
                return canQuoteInd;
            }

            /**
             * Sets the value of the canQuoteInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCanQuoteInd(String value) {
                this.canQuoteInd = value;
            }

            /**
             * Gets the value of the contractPrice property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getContractPrice() {
                return contractPrice;
            }

            /**
             * Sets the value of the contractPrice property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setContractPrice(String value) {
                this.contractPrice = value;
            }

            /**
             * Gets the value of the fixedPricePerThermCd property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFixedPricePerThermCd() {
                return fixedPricePerThermCd;
            }

            /**
             * Sets the value of the fixedPricePerThermCd property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFixedPricePerThermCd(String value) {
                this.fixedPricePerThermCd = value;
            }

            /**
             * Gets the value of the fixedPricePerTherm property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFixedPricePerTherm() {
                return fixedPricePerTherm;
            }

            /**
             * Sets the value of the fixedPricePerTherm property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFixedPricePerTherm(String value) {
                this.fixedPricePerTherm = value;
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
             * Gets the value of the varPriceBasisAmt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVarPriceBasisAmt() {
                return varPriceBasisAmt;
            }

            /**
             * Sets the value of the varPriceBasisAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVarPriceBasisAmt(String value) {
                this.varPriceBasisAmt = value;
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
             * Gets the value of the varPriceTotal property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVarPriceTotal() {
                return varPriceTotal;
            }

            /**
             * Sets the value of the varPriceTotal property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVarPriceTotal(String value) {
                this.varPriceTotal = value;
            }

            /**
             * Gets the value of the comboFixedPricePct property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getComboFixedPricePct() {
                return comboFixedPricePct;
            }

            /**
             * Sets the value of the comboFixedPricePct property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setComboFixedPricePct(String value) {
                this.comboFixedPricePct = value;
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
             * Gets the value of the monthlyCapCostChrg property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMonthlyCapCostChrg() {
                return monthlyCapCostChrg;
            }

            /**
             * Sets the value of the monthlyCapCostChrg property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMonthlyCapCostChrg(String value) {
                this.monthlyCapCostChrg = value;
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
             * Gets the value of the monthlyCustChrg property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMonthlyCustChrg() {
                return monthlyCustChrg;
            }

            /**
             * Sets the value of the monthlyCustChrg property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMonthlyCustChrg(String value) {
                this.monthlyCustChrg = value;
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
             * Gets the value of the sfbWinterCnt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSFBWinterCnt() {
                return sfbWinterCnt;
            }

            /**
             * Sets the value of the sfbWinterCnt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSFBWinterCnt(String value) {
                this.sfbWinterCnt = value;
            }

            /**
             * Gets the value of the sfbWinterAmt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSFBWinterAmt() {
                return sfbWinterAmt;
            }

            /**
             * Sets the value of the sfbWinterAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSFBWinterAmt(String value) {
                this.sfbWinterAmt = value;
            }

            /**
             * Gets the value of the sfbSummerCnt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSFBSummerCnt() {
                return sfbSummerCnt;
            }

            /**
             * Sets the value of the sfbSummerCnt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSFBSummerCnt(String value) {
                this.sfbSummerCnt = value;
            }

            /**
             * Gets the value of the sfbSummerAmt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSFBSummerAmt() {
                return sfbSummerAmt;
            }

            /**
             * Sets the value of the sfbSummerAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSFBSummerAmt(String value) {
                this.sfbSummerAmt = value;
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
             * Gets the value of the ctrctDurationMonths property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCtrctDurationMonths() {
                return ctrctDurationMonths;
            }

            /**
             * Sets the value of the ctrctDurationMonths property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCtrctDurationMonths(String value) {
                this.ctrctDurationMonths = value;
            }

            /**
             * Gets the value of the ctrctTermDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCtrctTermDate() {
                return ctrctTermDate;
            }

            /**
             * Sets the value of the ctrctTermDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCtrctTermDate(String value) {
                this.ctrctTermDate = value;
            }

            /**
             * Gets the value of the priceChangeFrequency property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPriceChangeFrequency() {
                return priceChangeFrequency;
            }

            /**
             * Sets the value of the priceChangeFrequency property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPriceChangeFrequency(String value) {
                this.priceChangeFrequency = value;
            }

            /**
             * Gets the value of the ppcEarlyTermChargeAmt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPPCEarlyTermChargeAmt() {
                return ppcEarlyTermChargeAmt;
            }

            /**
             * Sets the value of the ppcEarlyTermChargeAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPPCEarlyTermChargeAmt(String value) {
                this.ppcEarlyTermChargeAmt = value;
            }

            /**
             * Gets the value of the earlyTermChargeAmt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEarlyTermChargeAmt() {
                return earlyTermChargeAmt;
            }

            /**
             * Sets the value of the earlyTermChargeAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEarlyTermChargeAmt(String value) {
                this.earlyTermChargeAmt = value;
            }

            /**
             * Gets the value of the message property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the message property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getMessage().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link GetQuotesResult.Customer.Product.Message }
             * 
             * 
             */
            public List<GetQuotesResult.Customer.Product.Message> getMessage() {
                if (message == null) {
                    message = new ArrayList<GetQuotesResult.Customer.Product.Message>();
                }
                return this.message;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="MsgLevel" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Message {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "MsgLevel")
                protected String msgLevel;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the msgLevel property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getMsgLevel() {
                    return msgLevel;
                }

                /**
                 * Sets the value of the msgLevel property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setMsgLevel(String value) {
                    this.msgLevel = value;
                }

            }

        }

    }

}
