package com.macquarium.ong.vo;

import java.util.Date;

public class Enrollment {
    private String id;
    private String custID;
    private Date createdDate;
    private int apiStatus;
    private String ldc;
    private String account;
    private String premise;
    private String firstName;
    private String lastName;
    private String businessName;
    private String mailAddress1;
    private String mailAddress2;
    private String mailCity;
    private String mailCounty;
    private String mailStateCode;
    private String mailZipCode;
    private String mailZipPlusFour;
    private String serviceAddress1;
    private String serviceAddress2;
    private String serviceCity;
    private String serviceCounty;
    private String serviceStateCode;
    private String serviceZipCode;
    private String serviceZipPlusFour;
    private String phoneNumber;
    private String emailAddress;
    private String doNotCallInd;
    private String doNotMailINd;
    private String emailPrefTranctionalCd;
    private String emailPrefSSEPromotionalCd;
    private String emailPrefAffiliatePromotionalCd;
    private String emailPref3rdPartyCd;
    private String emailPrefNonTransactionalCd;
    private String languageCd;
    private String mailAddressVerified;
    private String serviceAddressVerified;
    private String productCode;
    private String overrideFixPricePerThermCd;
    private String overrideFixPricePerTherm;
    private String overrideVarPriceAddOnPerTherm;
    private String overrideCtrctDurationMonths;
    private Date overrideCtrctTermDate;
    private String rafCode;
    private String enrolledByUserId;
    private String authorizationCode;
    private String authorizationLevel;
    private String channelID;
    private String promotionCode;
    private String campaignID;
    private String webSiteURL;
    private String custLeadSourceCode;
    private  String actionIfContractExists;
    private String preventCancelFeeifContractExists;
    private String bypassCreditCheckInd;
    private Date soldDate;
    private String bypassCIRInd;
    private String expectedQuoteAmt;
    private String tpvRequiredInd;
    private String emailTypeCode;
    private String alternateEmailAddress;
    private String editOnlyInd;
    private String b2BCustomerInd;
    private String expressConsentInd;
    private String brokerID;
    private Date delaySendToUtilDate;
    private String renewalProductCode;
    private String renewalFixPricePerThermCd;
    private String renewalFixPricePerTherm;
    private String renewalVarPriceAddOnPerTherm;
    private String renewalCtrctDurationMonths;
    private Date renewalCtrctTermDate;
    private String sourceSystemReferenceID;

    private String serviceTransferAuthFlag;
    private String authorityToSwitchFlag;
    private String agreeToTermsFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(int apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getLdc() {
        return ldc;
    }

    public void setLdc(String ldc) {
        this.ldc = ldc;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getMailAddress1() {
        return mailAddress1;
    }

    public void setMailAddress1(String mailAddress1) {
        this.mailAddress1 = mailAddress1;
    }

    public String getMailAddress2() {
        return mailAddress2;
    }

    public void setMailAddress2(String mailAddress2) {
        this.mailAddress2 = mailAddress2;
    }

    public String getMailCity() {
        return mailCity;
    }

    public void setMailCity(String mailCity) {
        this.mailCity = mailCity;
    }

    public String getMailCounty() {
        return mailCounty;
    }

    public void setMailCounty(String mailCounty) {
        this.mailCounty = mailCounty;
    }

    public String getMailStateCode() {
        return mailStateCode;
    }

    public void setMailStateCode(String mailStateCode) {
        this.mailStateCode = mailStateCode;
    }

    public String getMailZipCode() {
        return mailZipCode;
    }

    public void setMailZipCode(String mailZipCode) {
        this.mailZipCode = mailZipCode;
    }

    public String getMailZipPlusFour() {
        return mailZipPlusFour;
    }

    public void setMailZipPlusFour(String mailZipPlusFour) {
        this.mailZipPlusFour = mailZipPlusFour;
    }

    public String getServiceAddress1() {
        return serviceAddress1;
    }

    public void setServiceAddress1(String serviceAddress1) {
        this.serviceAddress1 = serviceAddress1;
    }

    public String getServiceAddress2() {
        return serviceAddress2;
    }

    public void setServiceAddress2(String serviceAddress2) {
        this.serviceAddress2 = serviceAddress2;
    }

    public String getServiceCity() {
        return serviceCity;
    }

    public void setServiceCity(String serviceCity) {
        this.serviceCity = serviceCity;
    }

    public String getServiceCounty() {
        return serviceCounty;
    }

    public void setServiceCounty(String serviceCounty) {
        this.serviceCounty = serviceCounty;
    }

    public String getServiceStateCode() {
        return serviceStateCode;
    }

    public void setServiceStateCode(String serviceStateCode) {
        this.serviceStateCode = serviceStateCode;
    }

    public String getServiceZipCode() {
        return serviceZipCode;
    }

    public void setServiceZipCode(String serviceZipCode) {
        this.serviceZipCode = serviceZipCode;
    }

    public String getServiceZipPlusFour() {
        return serviceZipPlusFour;
    }

    public void setServiceZipPlusFour(String serviceZipPlusFour) {
        this.serviceZipPlusFour = serviceZipPlusFour;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDoNotCallInd() {
        return doNotCallInd;
    }

    public void setDoNotCallInd(String doNotCallInd) {
        this.doNotCallInd = doNotCallInd;
    }

    public String getDoNotMailINd() {
        return doNotMailINd;
    }

    public void setDoNotMailINd(String doNotMailINd) {
        this.doNotMailINd = doNotMailINd;
    }

    public String getEmailPrefTranctionalCd() {
        return emailPrefTranctionalCd;
    }

    public void setEmailPrefTranctionalCd(String emailPrefTranctionalCd) {
        this.emailPrefTranctionalCd = emailPrefTranctionalCd;
    }

    public String getEmailPrefSSEPromotionalCd() {
        return emailPrefSSEPromotionalCd;
    }

    public void setEmailPrefSSEPromotionalCd(String emailPrefSSEPromotionalCd) {
        this.emailPrefSSEPromotionalCd = emailPrefSSEPromotionalCd;
    }

    public String getEmailPrefAffiliatePromotionalCd() {
        return emailPrefAffiliatePromotionalCd;
    }

    public void setEmailPrefAffiliatePromotionalCd(String emailPrefAffiliatePromotionalCd) {
        this.emailPrefAffiliatePromotionalCd = emailPrefAffiliatePromotionalCd;
    }

    public String getEmailPref3rdPartyCd() {
        return emailPref3rdPartyCd;
    }

    public void setEmailPref3rdPartyCd(String emailPref3rdPartyCd) {
        this.emailPref3rdPartyCd = emailPref3rdPartyCd;
    }

    public String getEmailPrefNonTransactionalCd() {
        return emailPrefNonTransactionalCd;
    }

    public void setEmailPrefNonTransactionalCd(String emailPrefNonTransactionalCd) {
        this.emailPrefNonTransactionalCd = emailPrefNonTransactionalCd;
    }

    public String getLanguageCd() {
        return languageCd;
    }

    public void setLanguageCd(String languageCd) {
        this.languageCd = languageCd;
    }

    public String getMailAddressVerified() {
        return mailAddressVerified;
    }

    public void setMailAddressVerified(String mailAddressVerified) {
        this.mailAddressVerified = mailAddressVerified;
    }

    public String getServiceAddressVerified() {
        return serviceAddressVerified;
    }

    public void setServiceAddressVerified(String serviceAddressVerified) {
        this.serviceAddressVerified = serviceAddressVerified;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOverrideFixPricePerThermCd() {
        return overrideFixPricePerThermCd;
    }

    public void setOverrideFixPricePerThermCd(String overrideFixPricePerThermCd) {
        this.overrideFixPricePerThermCd = overrideFixPricePerThermCd;
    }

    public String getOverrideFixPricePerTherm() {
        return overrideFixPricePerTherm;
    }

    public void setOverrideFixPricePerTherm(String overrideFixPricePerTherm) {
        this.overrideFixPricePerTherm = overrideFixPricePerTherm;
    }

    public String getOverrideVarPriceAddOnPerTherm() {
        return overrideVarPriceAddOnPerTherm;
    }

    public void setOverrideVarPriceAddOnPerTherm(String overrideVarPriceAddOnPerTherm) {
        this.overrideVarPriceAddOnPerTherm = overrideVarPriceAddOnPerTherm;
    }

    public String getOverrideCtrctDurationMonths() {
        return overrideCtrctDurationMonths;
    }

    public void setOverrideCtrctDurationMonths(String overrideCtrctDurationMonths) {
        this.overrideCtrctDurationMonths = overrideCtrctDurationMonths;
    }

    public Date getOverrideCtrctTermDate() {
        return overrideCtrctTermDate;
    }

    public void setOverrideCtrctTermDate(Date overrideCtrctTermDate) {
        this.overrideCtrctTermDate = overrideCtrctTermDate;
    }

    public String getRafCode() {
        return rafCode;
    }

    public void setRafCode(String rafCode) {
        this.rafCode = rafCode;
    }

    public String getEnrolledByUserId() {
        return enrolledByUserId;
    }

    public void setEnrolledByUserId(String enrolledByUserId) {
        this.enrolledByUserId = enrolledByUserId;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getAuthorizationLevel() {
        return authorizationLevel;
    }

    public void setAuthorizationLevel(String authorizationLevel) {
        this.authorizationLevel = authorizationLevel;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(String campaignID) {
        this.campaignID = campaignID;
    }

    public String getWebSiteURL() {
        return webSiteURL;
    }

    public void setWebSiteURL(String webSiteURL) {
        this.webSiteURL = webSiteURL;
    }

    public String getCustLeadSourceCode() {
        return custLeadSourceCode;
    }

    public void setCustLeadSourceCode(String custLeadSourceCode) {
        this.custLeadSourceCode = custLeadSourceCode;
    }

    public String getActionIfContractExists() {
        return actionIfContractExists;
    }

    public void setActionIfContractExists(String actionIfContractExists) {
        this.actionIfContractExists = actionIfContractExists;
    }

    public String getPreventCancelFeeifContractExists() {
        return preventCancelFeeifContractExists;
    }

    public void setPreventCancelFeeifContractExists(String preventCancelFeeifContractExists) {
        this.preventCancelFeeifContractExists = preventCancelFeeifContractExists;
    }

    public String getBypassCreditCheckInd() {
        return bypassCreditCheckInd;
    }

    public void setBypassCreditCheckInd(String bypassCreditCheckInd) {
        this.bypassCreditCheckInd = bypassCreditCheckInd;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public String getBypassCIRInd() {
        return bypassCIRInd;
    }

    public void setBypassCIRInd(String bypassCIRInd) {
        this.bypassCIRInd = bypassCIRInd;
    }

    public String getExpectedQuoteAmt() {
        return expectedQuoteAmt;
    }

    public void setExpectedQuoteAmt(String expectedQuoteAmt) {
        this.expectedQuoteAmt = expectedQuoteAmt;
    }

    public String getTpvRequiredInd() {
        return tpvRequiredInd;
    }

    public void setTpvRequiredInd(String tpvRequiredInd) {
        this.tpvRequiredInd = tpvRequiredInd;
    }

    public String getEmailTypeCode() {
        return emailTypeCode;
    }

    public void setEmailTypeCode(String emailTypeCode) {
        this.emailTypeCode = emailTypeCode;
    }

    public String getAlternateEmailAddress() {
        return alternateEmailAddress;
    }

    public void setAlternateEmailAddress(String alternateEmailAddress) {
        this.alternateEmailAddress = alternateEmailAddress;
    }

    public String getEditOnlyInd() {
        return editOnlyInd;
    }

    public void setEditOnlyInd(String editOnlyInd) {
        this.editOnlyInd = editOnlyInd;
    }

    public String getB2BCustomerInd() {
        return b2BCustomerInd;
    }

    public void setB2BCustomerInd(String b2BCustomerInd) {
        this.b2BCustomerInd = b2BCustomerInd;
    }

    public String getExpressConsentInd() {
        return expressConsentInd;
    }

    public void setExpressConsentInd(String expressConsentInd) {
        this.expressConsentInd = expressConsentInd;
    }

    public String getBrokerID() {
        return brokerID;
    }

    public void setBrokerID(String brokerID) {
        this.brokerID = brokerID;
    }

    public Date getDelaySendToUtilDate() {
        return delaySendToUtilDate;
    }

    public void setDelaySendToUtilDate(Date delaySendToUtilDate) {
        this.delaySendToUtilDate = delaySendToUtilDate;
    }

    public String getRenewalProductCode() {
        return renewalProductCode;
    }

    public void setRenewalProductCode(String renewalProductCode) {
        this.renewalProductCode = renewalProductCode;
    }

    public String getRenewalFixPricePerThermCd() {
        return renewalFixPricePerThermCd;
    }

    public void setRenewalFixPricePerThermCd(String renewalFixPricePerThermCd) {
        this.renewalFixPricePerThermCd = renewalFixPricePerThermCd;
    }

    public String getRenewalFixPricePerTherm() {
        return renewalFixPricePerTherm;
    }

    public void setRenewalFixPricePerTherm(String renewalFixPricePerTherm) {
        this.renewalFixPricePerTherm = renewalFixPricePerTherm;
    }

    public String getRenewalVarPriceAddOnPerTherm() {
        return renewalVarPriceAddOnPerTherm;
    }

    public void setRenewalVarPriceAddOnPerTherm(String renewalVarPriceAddOnPerTherm) {
        this.renewalVarPriceAddOnPerTherm = renewalVarPriceAddOnPerTherm;
    }

    public String getRenewalCtrctDurationMonths() {
        return renewalCtrctDurationMonths;
    }

    public void setRenewalCtrctDurationMonths(String renewalCtrctDurationMonths) {
        this.renewalCtrctDurationMonths = renewalCtrctDurationMonths;
    }

    public Date getRenewalCtrctTermDate() {
        return renewalCtrctTermDate;
    }

    public void setRenewalCtrctTermDate(Date renewalCtrctTermDate) {
        this.renewalCtrctTermDate = renewalCtrctTermDate;
    }

    public String getSourceSystemReferenceID() {
        return sourceSystemReferenceID;
    }

    public void setSourceSystemReferenceID(String sourceSystemReferenceID) {
        this.sourceSystemReferenceID = sourceSystemReferenceID;
    }
    
    public String getServiceTransferAuthFlag() {
        return serviceTransferAuthFlag;
    }

    public void setServiceTransferAuthFlag(String serviceTransferAuthFlag) {
        this.serviceTransferAuthFlag = serviceTransferAuthFlag;
    }

    public String getAuthorityToSwitchFlag() {
        return authorityToSwitchFlag;
    }

    public void setAuthorityToSwitchFlag(String authorityToSwitchFlag) {
        this.authorityToSwitchFlag = authorityToSwitchFlag;
    }

    public String getAgreeToTermsFlag() {
        return agreeToTermsFlag;
    }

    public void setAgreeToTermsFlag(String agreeToTermsFlag) {
        this.agreeToTermsFlag = agreeToTermsFlag;
    }
}
