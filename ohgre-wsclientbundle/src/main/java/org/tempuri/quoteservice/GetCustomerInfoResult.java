
package org.tempuri.quoteservice;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="ResponseStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RateClassDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductDescFriendly" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductFinePrintText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductPlanDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PromoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PromoDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustLeadSourceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustLeadSourceDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrokerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SoldDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContractStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContractTermDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UtilityActivationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UtilityDeactivationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContractPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PricePerUnitCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PricePerUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VarPriceBasisCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VarPriceBasisAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VarPriceAddOnPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VarPriceTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ComboFixPricePct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VarCapLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MonthlyCapCostCharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VarCapCostPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MonthlyCustCharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiscChargePerBill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SFBWinterCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SFBWinterAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SFBSummerCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SFBSummerAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PricingDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastRateChangeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EarlyTermChargeAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FixVarProductCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalContractExistsInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalProductDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalProductDescFriendly" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalProductFinePrintText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalProductPlanDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalProductType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalProductCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalContractPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalPricePerUnitCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalPricePerUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalVarPriceBasisCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalVarPriceBasisAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalVarPriceAddOnPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalVarPriceTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalComboFixPricePct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalVarCapLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalMonthlyCapCostCharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalVarCapCostPerTherm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalMonthlyCustCharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalDiscChargePerBill" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalSFBWinterCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalSFBWinterAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalSFBSummerCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalSFBSummerAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalPricingDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalPromoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalPromoDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalCustLeadSourceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalCustLeadSourceDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalContractStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalContractTermDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalFixVarProductCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RenewalBrokerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvalidEmailAddrInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InvalidEmailAddrValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupplierBudgetPlanAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DSMParticipantPlanInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GiftCardNodeCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GiftCard" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ProductCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ProductDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GiftCardSummaryDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ContractStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SoldDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GiftCardCreateDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GiftCardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GiftCardDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GiftCardTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GiftCardStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GiftCardStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GiftCardAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="GiftCardWaitPeriodDays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="SentToProviderDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ConfirmedByProviderDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CancelDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ConfirmationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RAFCustId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RejectReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="NoteText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RAFTermsCondAcknowledgedInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RAFTermsCondAcknowledgedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "customerName",
    "rateClassDesc",
    "productCode",
    "productDesc",
    "productDescFriendly",
    "productFinePrintText",
    "productPlanDesc",
    "productType",
    "productCategory",
    "promoCode",
    "promoDesc",
    "custLeadSourceCode",
    "custLeadSourceDesc",
    "brokerID",
    "soldDate",
    "contractStartDate",
    "contractTermDate",
    "utilityActivationDate",
    "utilityDeactivationDate",
    "uom",
    "contractPrice",
    "pricePerUnitCode",
    "pricePerUnit",
    "varPriceBasisCode",
    "varPriceBasisAmt",
    "varPriceAddOnPerTherm",
    "varPriceTotal",
    "comboFixPricePct",
    "varCapLimit",
    "monthlyCapCostCharge",
    "varCapCostPerTherm",
    "monthlyCustCharge",
    "discChargePerBill",
    "sfbWinterCnt",
    "sfbWinterAmt",
    "sfbSummerCnt",
    "sfbSummerAmt",
    "pricingDesc",
    "lastRateChangeDate",
    "earlyTermChargeAmt",
    "fixVarProductCd",
    "renewalContractExistsInd",
    "renewalProductCode",
    "renewalProductDesc",
    "renewalProductDescFriendly",
    "renewalProductFinePrintText",
    "renewalProductPlanDesc",
    "renewalProductType",
    "renewalProductCategory",
    "renewalContractPrice",
    "renewalPricePerUnitCode",
    "renewalPricePerUnit",
    "renewalVarPriceBasisCode",
    "renewalVarPriceBasisAmt",
    "renewalVarPriceAddOnPerTherm",
    "renewalVarPriceTotal",
    "renewalComboFixPricePct",
    "renewalVarCapLimit",
    "renewalMonthlyCapCostCharge",
    "renewalVarCapCostPerTherm",
    "renewalMonthlyCustCharge",
    "renewalDiscChargePerBill",
    "renewalSFBWinterCnt",
    "renewalSFBWinterAmt",
    "renewalSFBSummerCnt",
    "renewalSFBSummerAmt",
    "renewalPricingDesc",
    "renewalPromoCode",
    "renewalPromoDesc",
    "renewalCustLeadSourceCode",
    "renewalCustLeadSourceDesc",
    "renewalContractStartDate",
    "renewalContractTermDate",
    "renewalFixVarProductCd",
    "renewalBrokerID",
    "invalidEmailAddrInd",
    "invalidEmailAddrValue",
    "supplierBudgetPlanAmt",
    "dsmParticipantPlanInd",
    "giftCardNodeCnt",
    "giftCard",
    "rafTermsCondAcknowledgedInd",
    "rafTermsCondAcknowledgedDate"
})
@XmlRootElement(name = "GetCustomerInfoResult")
public class GetCustomerInfoResult {

    @XmlElement(name = "ResponseStatus")
    protected String responseStatus;
    @XmlElement(name = "ResponseMessage")
    protected String responseMessage;
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
    @XmlElement(name = "CustomerName")
    protected String customerName;
    @XmlElement(name = "RateClassDesc")
    protected String rateClassDesc;
    @XmlElement(name = "ProductCode")
    protected String productCode;
    @XmlElement(name = "ProductDesc")
    protected String productDesc;
    @XmlElement(name = "ProductDescFriendly")
    protected String productDescFriendly;
    @XmlElement(name = "ProductFinePrintText")
    protected String productFinePrintText;
    @XmlElement(name = "ProductPlanDesc")
    protected String productPlanDesc;
    @XmlElement(name = "ProductType")
    protected String productType;
    @XmlElement(name = "ProductCategory")
    protected String productCategory;
    @XmlElement(name = "PromoCode")
    protected String promoCode;
    @XmlElement(name = "PromoDesc")
    protected String promoDesc;
    @XmlElement(name = "CustLeadSourceCode")
    protected String custLeadSourceCode;
    @XmlElement(name = "CustLeadSourceDesc")
    protected String custLeadSourceDesc;
    @XmlElement(name = "BrokerID")
    protected String brokerID;
    @XmlElement(name = "SoldDate")
    protected String soldDate;
    @XmlElement(name = "ContractStartDate")
    protected String contractStartDate;
    @XmlElement(name = "ContractTermDate")
    protected String contractTermDate;
    @XmlElement(name = "UtilityActivationDate")
    protected String utilityActivationDate;
    @XmlElement(name = "UtilityDeactivationDate")
    protected String utilityDeactivationDate;
    @XmlElement(name = "UOM")
    protected String uom;
    @XmlElement(name = "ContractPrice")
    protected String contractPrice;
    @XmlElement(name = "PricePerUnitCode")
    protected String pricePerUnitCode;
    @XmlElement(name = "PricePerUnit")
    protected String pricePerUnit;
    @XmlElement(name = "VarPriceBasisCode")
    protected String varPriceBasisCode;
    @XmlElement(name = "VarPriceBasisAmt")
    protected String varPriceBasisAmt;
    @XmlElement(name = "VarPriceAddOnPerTherm")
    protected String varPriceAddOnPerTherm;
    @XmlElement(name = "VarPriceTotal")
    protected String varPriceTotal;
    @XmlElement(name = "ComboFixPricePct")
    protected String comboFixPricePct;
    @XmlElement(name = "VarCapLimit")
    protected String varCapLimit;
    @XmlElement(name = "MonthlyCapCostCharge")
    protected String monthlyCapCostCharge;
    @XmlElement(name = "VarCapCostPerTherm")
    protected String varCapCostPerTherm;
    @XmlElement(name = "MonthlyCustCharge")
    protected String monthlyCustCharge;
    @XmlElement(name = "DiscChargePerBill")
    protected String discChargePerBill;
    @XmlElement(name = "SFBWinterCnt")
    protected String sfbWinterCnt;
    @XmlElement(name = "SFBWinterAmt")
    protected String sfbWinterAmt;
    @XmlElement(name = "SFBSummerCnt")
    protected String sfbSummerCnt;
    @XmlElement(name = "SFBSummerAmt")
    protected String sfbSummerAmt;
    @XmlElement(name = "PricingDesc")
    protected String pricingDesc;
    @XmlElement(name = "LastRateChangeDate")
    protected String lastRateChangeDate;
    @XmlElement(name = "EarlyTermChargeAmt")
    protected String earlyTermChargeAmt;
    @XmlElement(name = "FixVarProductCd")
    protected String fixVarProductCd;
    @XmlElement(name = "RenewalContractExistsInd")
    protected String renewalContractExistsInd;
    @XmlElement(name = "RenewalProductCode")
    protected String renewalProductCode;
    @XmlElement(name = "RenewalProductDesc")
    protected String renewalProductDesc;
    @XmlElement(name = "RenewalProductDescFriendly")
    protected String renewalProductDescFriendly;
    @XmlElement(name = "RenewalProductFinePrintText")
    protected String renewalProductFinePrintText;
    @XmlElement(name = "RenewalProductPlanDesc")
    protected String renewalProductPlanDesc;
    @XmlElement(name = "RenewalProductType")
    protected String renewalProductType;
    @XmlElement(name = "RenewalProductCategory")
    protected String renewalProductCategory;
    @XmlElement(name = "RenewalContractPrice")
    protected String renewalContractPrice;
    @XmlElement(name = "RenewalPricePerUnitCode")
    protected String renewalPricePerUnitCode;
    @XmlElement(name = "RenewalPricePerUnit")
    protected String renewalPricePerUnit;
    @XmlElement(name = "RenewalVarPriceBasisCode")
    protected String renewalVarPriceBasisCode;
    @XmlElement(name = "RenewalVarPriceBasisAmt")
    protected String renewalVarPriceBasisAmt;
    @XmlElement(name = "RenewalVarPriceAddOnPerTherm")
    protected String renewalVarPriceAddOnPerTherm;
    @XmlElement(name = "RenewalVarPriceTotal")
    protected String renewalVarPriceTotal;
    @XmlElement(name = "RenewalComboFixPricePct")
    protected String renewalComboFixPricePct;
    @XmlElement(name = "RenewalVarCapLimit")
    protected String renewalVarCapLimit;
    @XmlElement(name = "RenewalMonthlyCapCostCharge")
    protected String renewalMonthlyCapCostCharge;
    @XmlElement(name = "RenewalVarCapCostPerTherm")
    protected String renewalVarCapCostPerTherm;
    @XmlElement(name = "RenewalMonthlyCustCharge")
    protected String renewalMonthlyCustCharge;
    @XmlElement(name = "RenewalDiscChargePerBill")
    protected String renewalDiscChargePerBill;
    @XmlElement(name = "RenewalSFBWinterCnt")
    protected String renewalSFBWinterCnt;
    @XmlElement(name = "RenewalSFBWinterAmt")
    protected String renewalSFBWinterAmt;
    @XmlElement(name = "RenewalSFBSummerCnt")
    protected String renewalSFBSummerCnt;
    @XmlElement(name = "RenewalSFBSummerAmt")
    protected String renewalSFBSummerAmt;
    @XmlElement(name = "RenewalPricingDesc")
    protected String renewalPricingDesc;
    @XmlElement(name = "RenewalPromoCode")
    protected String renewalPromoCode;
    @XmlElement(name = "RenewalPromoDesc")
    protected String renewalPromoDesc;
    @XmlElement(name = "RenewalCustLeadSourceCode")
    protected String renewalCustLeadSourceCode;
    @XmlElement(name = "RenewalCustLeadSourceDesc")
    protected String renewalCustLeadSourceDesc;
    @XmlElement(name = "RenewalContractStartDate")
    protected String renewalContractStartDate;
    @XmlElement(name = "RenewalContractTermDate")
    protected String renewalContractTermDate;
    @XmlElement(name = "RenewalFixVarProductCd")
    protected String renewalFixVarProductCd;
    @XmlElement(name = "RenewalBrokerID")
    protected String renewalBrokerID;
    @XmlElement(name = "InvalidEmailAddrInd")
    protected String invalidEmailAddrInd;
    @XmlElement(name = "InvalidEmailAddrValue")
    protected String invalidEmailAddrValue;
    @XmlElement(name = "SupplierBudgetPlanAmt")
    protected String supplierBudgetPlanAmt;
    @XmlElement(name = "DSMParticipantPlanInd")
    protected String dsmParticipantPlanInd;
    @XmlElement(name = "GiftCardNodeCnt")
    protected String giftCardNodeCnt;
    @XmlElement(name = "GiftCard")
    protected List<GetCustomerInfoResult.GiftCard> giftCard;
    @XmlElement(name = "RAFTermsCondAcknowledgedInd")
    protected String rafTermsCondAcknowledgedInd;
    @XmlElement(name = "RAFTermsCondAcknowledgedDate")
    protected String rafTermsCondAcknowledgedDate;

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
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the rateClassDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateClassDesc() {
        return rateClassDesc;
    }

    /**
     * Sets the value of the rateClassDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateClassDesc(String value) {
        this.rateClassDesc = value;
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
     * Gets the value of the productDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * Sets the value of the productDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductDesc(String value) {
        this.productDesc = value;
    }

    /**
     * Gets the value of the productDescFriendly property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductDescFriendly() {
        return productDescFriendly;
    }

    /**
     * Sets the value of the productDescFriendly property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductDescFriendly(String value) {
        this.productDescFriendly = value;
    }

    /**
     * Gets the value of the productFinePrintText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductFinePrintText() {
        return productFinePrintText;
    }

    /**
     * Sets the value of the productFinePrintText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductFinePrintText(String value) {
        this.productFinePrintText = value;
    }

    /**
     * Gets the value of the productPlanDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductPlanDesc() {
        return productPlanDesc;
    }

    /**
     * Sets the value of the productPlanDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductPlanDesc(String value) {
        this.productPlanDesc = value;
    }

    /**
     * Gets the value of the productType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductType() {
        return productType;
    }

    /**
     * Sets the value of the productType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductType(String value) {
        this.productType = value;
    }

    /**
     * Gets the value of the productCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCategory() {
        return productCategory;
    }

    /**
     * Sets the value of the productCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCategory(String value) {
        this.productCategory = value;
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
     * Gets the value of the promoDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoDesc() {
        return promoDesc;
    }

    /**
     * Sets the value of the promoDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoDesc(String value) {
        this.promoDesc = value;
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
     * Gets the value of the custLeadSourceDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustLeadSourceDesc() {
        return custLeadSourceDesc;
    }

    /**
     * Sets the value of the custLeadSourceDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustLeadSourceDesc(String value) {
        this.custLeadSourceDesc = value;
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
     * Gets the value of the contractStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractStartDate() {
        return contractStartDate;
    }

    /**
     * Sets the value of the contractStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractStartDate(String value) {
        this.contractStartDate = value;
    }

    /**
     * Gets the value of the contractTermDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractTermDate() {
        return contractTermDate;
    }

    /**
     * Sets the value of the contractTermDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractTermDate(String value) {
        this.contractTermDate = value;
    }

    /**
     * Gets the value of the utilityActivationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtilityActivationDate() {
        return utilityActivationDate;
    }

    /**
     * Sets the value of the utilityActivationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtilityActivationDate(String value) {
        this.utilityActivationDate = value;
    }

    /**
     * Gets the value of the utilityDeactivationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtilityDeactivationDate() {
        return utilityDeactivationDate;
    }

    /**
     * Sets the value of the utilityDeactivationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtilityDeactivationDate(String value) {
        this.utilityDeactivationDate = value;
    }

    /**
     * Gets the value of the uom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUOM() {
        return uom;
    }

    /**
     * Sets the value of the uom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUOM(String value) {
        this.uom = value;
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
     * Gets the value of the pricePerUnitCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricePerUnitCode() {
        return pricePerUnitCode;
    }

    /**
     * Sets the value of the pricePerUnitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricePerUnitCode(String value) {
        this.pricePerUnitCode = value;
    }

    /**
     * Gets the value of the pricePerUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricePerUnit() {
        return pricePerUnit;
    }

    /**
     * Sets the value of the pricePerUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricePerUnit(String value) {
        this.pricePerUnit = value;
    }

    /**
     * Gets the value of the varPriceBasisCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVarPriceBasisCode() {
        return varPriceBasisCode;
    }

    /**
     * Sets the value of the varPriceBasisCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVarPriceBasisCode(String value) {
        this.varPriceBasisCode = value;
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
     * Gets the value of the monthlyCapCostCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonthlyCapCostCharge() {
        return monthlyCapCostCharge;
    }

    /**
     * Sets the value of the monthlyCapCostCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthlyCapCostCharge(String value) {
        this.monthlyCapCostCharge = value;
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
     * Gets the value of the monthlyCustCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonthlyCustCharge() {
        return monthlyCustCharge;
    }

    /**
     * Sets the value of the monthlyCustCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonthlyCustCharge(String value) {
        this.monthlyCustCharge = value;
    }

    /**
     * Gets the value of the discChargePerBill property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscChargePerBill() {
        return discChargePerBill;
    }

    /**
     * Sets the value of the discChargePerBill property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscChargePerBill(String value) {
        this.discChargePerBill = value;
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
     * Gets the value of the pricingDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricingDesc() {
        return pricingDesc;
    }

    /**
     * Sets the value of the pricingDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricingDesc(String value) {
        this.pricingDesc = value;
    }

    /**
     * Gets the value of the lastRateChangeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastRateChangeDate() {
        return lastRateChangeDate;
    }

    /**
     * Sets the value of the lastRateChangeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastRateChangeDate(String value) {
        this.lastRateChangeDate = value;
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
     * Gets the value of the fixVarProductCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixVarProductCd() {
        return fixVarProductCd;
    }

    /**
     * Sets the value of the fixVarProductCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixVarProductCd(String value) {
        this.fixVarProductCd = value;
    }

    /**
     * Gets the value of the renewalContractExistsInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalContractExistsInd() {
        return renewalContractExistsInd;
    }

    /**
     * Sets the value of the renewalContractExistsInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalContractExistsInd(String value) {
        this.renewalContractExistsInd = value;
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
     * Gets the value of the renewalProductDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalProductDesc() {
        return renewalProductDesc;
    }

    /**
     * Sets the value of the renewalProductDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalProductDesc(String value) {
        this.renewalProductDesc = value;
    }

    /**
     * Gets the value of the renewalProductDescFriendly property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalProductDescFriendly() {
        return renewalProductDescFriendly;
    }

    /**
     * Sets the value of the renewalProductDescFriendly property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalProductDescFriendly(String value) {
        this.renewalProductDescFriendly = value;
    }

    /**
     * Gets the value of the renewalProductFinePrintText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalProductFinePrintText() {
        return renewalProductFinePrintText;
    }

    /**
     * Sets the value of the renewalProductFinePrintText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalProductFinePrintText(String value) {
        this.renewalProductFinePrintText = value;
    }

    /**
     * Gets the value of the renewalProductPlanDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalProductPlanDesc() {
        return renewalProductPlanDesc;
    }

    /**
     * Sets the value of the renewalProductPlanDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalProductPlanDesc(String value) {
        this.renewalProductPlanDesc = value;
    }

    /**
     * Gets the value of the renewalProductType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalProductType() {
        return renewalProductType;
    }

    /**
     * Sets the value of the renewalProductType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalProductType(String value) {
        this.renewalProductType = value;
    }

    /**
     * Gets the value of the renewalProductCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalProductCategory() {
        return renewalProductCategory;
    }

    /**
     * Sets the value of the renewalProductCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalProductCategory(String value) {
        this.renewalProductCategory = value;
    }

    /**
     * Gets the value of the renewalContractPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalContractPrice() {
        return renewalContractPrice;
    }

    /**
     * Sets the value of the renewalContractPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalContractPrice(String value) {
        this.renewalContractPrice = value;
    }

    /**
     * Gets the value of the renewalPricePerUnitCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalPricePerUnitCode() {
        return renewalPricePerUnitCode;
    }

    /**
     * Sets the value of the renewalPricePerUnitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalPricePerUnitCode(String value) {
        this.renewalPricePerUnitCode = value;
    }

    /**
     * Gets the value of the renewalPricePerUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalPricePerUnit() {
        return renewalPricePerUnit;
    }

    /**
     * Sets the value of the renewalPricePerUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalPricePerUnit(String value) {
        this.renewalPricePerUnit = value;
    }

    /**
     * Gets the value of the renewalVarPriceBasisCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalVarPriceBasisCode() {
        return renewalVarPriceBasisCode;
    }

    /**
     * Sets the value of the renewalVarPriceBasisCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalVarPriceBasisCode(String value) {
        this.renewalVarPriceBasisCode = value;
    }

    /**
     * Gets the value of the renewalVarPriceBasisAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalVarPriceBasisAmt() {
        return renewalVarPriceBasisAmt;
    }

    /**
     * Sets the value of the renewalVarPriceBasisAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalVarPriceBasisAmt(String value) {
        this.renewalVarPriceBasisAmt = value;
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
     * Gets the value of the renewalVarPriceTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalVarPriceTotal() {
        return renewalVarPriceTotal;
    }

    /**
     * Sets the value of the renewalVarPriceTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalVarPriceTotal(String value) {
        this.renewalVarPriceTotal = value;
    }

    /**
     * Gets the value of the renewalComboFixPricePct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalComboFixPricePct() {
        return renewalComboFixPricePct;
    }

    /**
     * Sets the value of the renewalComboFixPricePct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalComboFixPricePct(String value) {
        this.renewalComboFixPricePct = value;
    }

    /**
     * Gets the value of the renewalVarCapLimit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalVarCapLimit() {
        return renewalVarCapLimit;
    }

    /**
     * Sets the value of the renewalVarCapLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalVarCapLimit(String value) {
        this.renewalVarCapLimit = value;
    }

    /**
     * Gets the value of the renewalMonthlyCapCostCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalMonthlyCapCostCharge() {
        return renewalMonthlyCapCostCharge;
    }

    /**
     * Sets the value of the renewalMonthlyCapCostCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalMonthlyCapCostCharge(String value) {
        this.renewalMonthlyCapCostCharge = value;
    }

    /**
     * Gets the value of the renewalVarCapCostPerTherm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalVarCapCostPerTherm() {
        return renewalVarCapCostPerTherm;
    }

    /**
     * Sets the value of the renewalVarCapCostPerTherm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalVarCapCostPerTherm(String value) {
        this.renewalVarCapCostPerTherm = value;
    }

    /**
     * Gets the value of the renewalMonthlyCustCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalMonthlyCustCharge() {
        return renewalMonthlyCustCharge;
    }

    /**
     * Sets the value of the renewalMonthlyCustCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalMonthlyCustCharge(String value) {
        this.renewalMonthlyCustCharge = value;
    }

    /**
     * Gets the value of the renewalDiscChargePerBill property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalDiscChargePerBill() {
        return renewalDiscChargePerBill;
    }

    /**
     * Sets the value of the renewalDiscChargePerBill property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalDiscChargePerBill(String value) {
        this.renewalDiscChargePerBill = value;
    }

    /**
     * Gets the value of the renewalSFBWinterCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalSFBWinterCnt() {
        return renewalSFBWinterCnt;
    }

    /**
     * Sets the value of the renewalSFBWinterCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalSFBWinterCnt(String value) {
        this.renewalSFBWinterCnt = value;
    }

    /**
     * Gets the value of the renewalSFBWinterAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalSFBWinterAmt() {
        return renewalSFBWinterAmt;
    }

    /**
     * Sets the value of the renewalSFBWinterAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalSFBWinterAmt(String value) {
        this.renewalSFBWinterAmt = value;
    }

    /**
     * Gets the value of the renewalSFBSummerCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalSFBSummerCnt() {
        return renewalSFBSummerCnt;
    }

    /**
     * Sets the value of the renewalSFBSummerCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalSFBSummerCnt(String value) {
        this.renewalSFBSummerCnt = value;
    }

    /**
     * Gets the value of the renewalSFBSummerAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalSFBSummerAmt() {
        return renewalSFBSummerAmt;
    }

    /**
     * Sets the value of the renewalSFBSummerAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalSFBSummerAmt(String value) {
        this.renewalSFBSummerAmt = value;
    }

    /**
     * Gets the value of the renewalPricingDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalPricingDesc() {
        return renewalPricingDesc;
    }

    /**
     * Sets the value of the renewalPricingDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalPricingDesc(String value) {
        this.renewalPricingDesc = value;
    }

    /**
     * Gets the value of the renewalPromoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalPromoCode() {
        return renewalPromoCode;
    }

    /**
     * Sets the value of the renewalPromoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalPromoCode(String value) {
        this.renewalPromoCode = value;
    }

    /**
     * Gets the value of the renewalPromoDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalPromoDesc() {
        return renewalPromoDesc;
    }

    /**
     * Sets the value of the renewalPromoDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalPromoDesc(String value) {
        this.renewalPromoDesc = value;
    }

    /**
     * Gets the value of the renewalCustLeadSourceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalCustLeadSourceCode() {
        return renewalCustLeadSourceCode;
    }

    /**
     * Sets the value of the renewalCustLeadSourceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalCustLeadSourceCode(String value) {
        this.renewalCustLeadSourceCode = value;
    }

    /**
     * Gets the value of the renewalCustLeadSourceDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalCustLeadSourceDesc() {
        return renewalCustLeadSourceDesc;
    }

    /**
     * Sets the value of the renewalCustLeadSourceDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalCustLeadSourceDesc(String value) {
        this.renewalCustLeadSourceDesc = value;
    }

    /**
     * Gets the value of the renewalContractStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalContractStartDate() {
        return renewalContractStartDate;
    }

    /**
     * Sets the value of the renewalContractStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalContractStartDate(String value) {
        this.renewalContractStartDate = value;
    }

    /**
     * Gets the value of the renewalContractTermDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalContractTermDate() {
        return renewalContractTermDate;
    }

    /**
     * Sets the value of the renewalContractTermDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalContractTermDate(String value) {
        this.renewalContractTermDate = value;
    }

    /**
     * Gets the value of the renewalFixVarProductCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalFixVarProductCd() {
        return renewalFixVarProductCd;
    }

    /**
     * Sets the value of the renewalFixVarProductCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalFixVarProductCd(String value) {
        this.renewalFixVarProductCd = value;
    }

    /**
     * Gets the value of the renewalBrokerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenewalBrokerID() {
        return renewalBrokerID;
    }

    /**
     * Sets the value of the renewalBrokerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenewalBrokerID(String value) {
        this.renewalBrokerID = value;
    }

    /**
     * Gets the value of the invalidEmailAddrInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvalidEmailAddrInd() {
        return invalidEmailAddrInd;
    }

    /**
     * Sets the value of the invalidEmailAddrInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvalidEmailAddrInd(String value) {
        this.invalidEmailAddrInd = value;
    }

    /**
     * Gets the value of the invalidEmailAddrValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvalidEmailAddrValue() {
        return invalidEmailAddrValue;
    }

    /**
     * Sets the value of the invalidEmailAddrValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvalidEmailAddrValue(String value) {
        this.invalidEmailAddrValue = value;
    }

    /**
     * Gets the value of the supplierBudgetPlanAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierBudgetPlanAmt() {
        return supplierBudgetPlanAmt;
    }

    /**
     * Sets the value of the supplierBudgetPlanAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierBudgetPlanAmt(String value) {
        this.supplierBudgetPlanAmt = value;
    }

    /**
     * Gets the value of the dsmParticipantPlanInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSMParticipantPlanInd() {
        return dsmParticipantPlanInd;
    }

    /**
     * Sets the value of the dsmParticipantPlanInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSMParticipantPlanInd(String value) {
        this.dsmParticipantPlanInd = value;
    }

    /**
     * Gets the value of the giftCardNodeCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftCardNodeCnt() {
        return giftCardNodeCnt;
    }

    /**
     * Sets the value of the giftCardNodeCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftCardNodeCnt(String value) {
        this.giftCardNodeCnt = value;
    }

    /**
     * Gets the value of the giftCard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the giftCard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGiftCard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetCustomerInfoResult.GiftCard }
     * 
     * 
     */
    public List<GetCustomerInfoResult.GiftCard> getGiftCard() {
        if (giftCard == null) {
            giftCard = new ArrayList<GetCustomerInfoResult.GiftCard>();
        }
        return this.giftCard;
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

    /**
     * Gets the value of the rafTermsCondAcknowledgedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRAFTermsCondAcknowledgedDate() {
        return rafTermsCondAcknowledgedDate;
    }

    /**
     * Sets the value of the rafTermsCondAcknowledgedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRAFTermsCondAcknowledgedDate(String value) {
        this.rafTermsCondAcknowledgedDate = value;
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
     *         &lt;element name="GiftCardSummaryDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ContractStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SoldDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GiftCardCreateDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GiftCardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GiftCardDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GiftCardTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GiftCardStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GiftCardStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GiftCardAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="GiftCardWaitPeriodDays" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="SentToProviderDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ConfirmedByProviderDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CancelDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ConfirmationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RAFCustId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RejectReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="NoteText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "giftCardSummaryDescription",
        "contractStartDate",
        "soldDate",
        "giftCardCreateDate",
        "giftCardCode",
        "giftCardDescription",
        "giftCardTypeCode",
        "giftCardStatusCode",
        "giftCardStatusDescription",
        "giftCardAmount",
        "giftCardWaitPeriodDays",
        "sentToProviderDate",
        "confirmedByProviderDate",
        "cancelDate",
        "confirmationNumber",
        "rafCustId",
        "rejectReasonCode",
        "noteText"
    })
    public static class GiftCard {

        @XmlElement(name = "ProductCode")
        protected String productCode;
        @XmlElement(name = "ProductDescription")
        protected String productDescription;
        @XmlElement(name = "GiftCardSummaryDescription")
        protected String giftCardSummaryDescription;
        @XmlElement(name = "ContractStartDate")
        protected String contractStartDate;
        @XmlElement(name = "SoldDate")
        protected String soldDate;
        @XmlElement(name = "GiftCardCreateDate")
        protected String giftCardCreateDate;
        @XmlElement(name = "GiftCardCode")
        protected String giftCardCode;
        @XmlElement(name = "GiftCardDescription")
        protected String giftCardDescription;
        @XmlElement(name = "GiftCardTypeCode")
        protected String giftCardTypeCode;
        @XmlElement(name = "GiftCardStatusCode")
        protected String giftCardStatusCode;
        @XmlElement(name = "GiftCardStatusDescription")
        protected String giftCardStatusDescription;
        @XmlElement(name = "GiftCardAmount")
        protected String giftCardAmount;
        @XmlElement(name = "GiftCardWaitPeriodDays")
        protected String giftCardWaitPeriodDays;
        @XmlElement(name = "SentToProviderDate")
        protected String sentToProviderDate;
        @XmlElement(name = "ConfirmedByProviderDate")
        protected String confirmedByProviderDate;
        @XmlElement(name = "CancelDate")
        protected String cancelDate;
        @XmlElement(name = "ConfirmationNumber")
        protected String confirmationNumber;
        @XmlElement(name = "RAFCustId")
        protected String rafCustId;
        @XmlElement(name = "RejectReasonCode")
        protected String rejectReasonCode;
        @XmlElement(name = "NoteText")
        protected String noteText;

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
         * Gets the value of the giftCardSummaryDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiftCardSummaryDescription() {
            return giftCardSummaryDescription;
        }

        /**
         * Sets the value of the giftCardSummaryDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiftCardSummaryDescription(String value) {
            this.giftCardSummaryDescription = value;
        }

        /**
         * Gets the value of the contractStartDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContractStartDate() {
            return contractStartDate;
        }

        /**
         * Sets the value of the contractStartDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContractStartDate(String value) {
            this.contractStartDate = value;
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
         * Gets the value of the giftCardCreateDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiftCardCreateDate() {
            return giftCardCreateDate;
        }

        /**
         * Sets the value of the giftCardCreateDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiftCardCreateDate(String value) {
            this.giftCardCreateDate = value;
        }

        /**
         * Gets the value of the giftCardCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiftCardCode() {
            return giftCardCode;
        }

        /**
         * Sets the value of the giftCardCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiftCardCode(String value) {
            this.giftCardCode = value;
        }

        /**
         * Gets the value of the giftCardDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiftCardDescription() {
            return giftCardDescription;
        }

        /**
         * Sets the value of the giftCardDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiftCardDescription(String value) {
            this.giftCardDescription = value;
        }

        /**
         * Gets the value of the giftCardTypeCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiftCardTypeCode() {
            return giftCardTypeCode;
        }

        /**
         * Sets the value of the giftCardTypeCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiftCardTypeCode(String value) {
            this.giftCardTypeCode = value;
        }

        /**
         * Gets the value of the giftCardStatusCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiftCardStatusCode() {
            return giftCardStatusCode;
        }

        /**
         * Sets the value of the giftCardStatusCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiftCardStatusCode(String value) {
            this.giftCardStatusCode = value;
        }

        /**
         * Gets the value of the giftCardStatusDescription property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiftCardStatusDescription() {
            return giftCardStatusDescription;
        }

        /**
         * Sets the value of the giftCardStatusDescription property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiftCardStatusDescription(String value) {
            this.giftCardStatusDescription = value;
        }

        /**
         * Gets the value of the giftCardAmount property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiftCardAmount() {
            return giftCardAmount;
        }

        /**
         * Sets the value of the giftCardAmount property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiftCardAmount(String value) {
            this.giftCardAmount = value;
        }

        /**
         * Gets the value of the giftCardWaitPeriodDays property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGiftCardWaitPeriodDays() {
            return giftCardWaitPeriodDays;
        }

        /**
         * Sets the value of the giftCardWaitPeriodDays property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGiftCardWaitPeriodDays(String value) {
            this.giftCardWaitPeriodDays = value;
        }

        /**
         * Gets the value of the sentToProviderDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSentToProviderDate() {
            return sentToProviderDate;
        }

        /**
         * Sets the value of the sentToProviderDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSentToProviderDate(String value) {
            this.sentToProviderDate = value;
        }

        /**
         * Gets the value of the confirmedByProviderDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConfirmedByProviderDate() {
            return confirmedByProviderDate;
        }

        /**
         * Sets the value of the confirmedByProviderDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConfirmedByProviderDate(String value) {
            this.confirmedByProviderDate = value;
        }

        /**
         * Gets the value of the cancelDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCancelDate() {
            return cancelDate;
        }

        /**
         * Sets the value of the cancelDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCancelDate(String value) {
            this.cancelDate = value;
        }

        /**
         * Gets the value of the confirmationNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConfirmationNumber() {
            return confirmationNumber;
        }

        /**
         * Sets the value of the confirmationNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConfirmationNumber(String value) {
            this.confirmationNumber = value;
        }

        /**
         * Gets the value of the rafCustId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRAFCustId() {
            return rafCustId;
        }

        /**
         * Sets the value of the rafCustId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRAFCustId(String value) {
            this.rafCustId = value;
        }

        /**
         * Gets the value of the rejectReasonCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRejectReasonCode() {
            return rejectReasonCode;
        }

        /**
         * Sets the value of the rejectReasonCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRejectReasonCode(String value) {
            this.rejectReasonCode = value;
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

    }

}
