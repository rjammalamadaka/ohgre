package com.primesw.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2017-09-22T00:11:34.913-04:00
 * Generated source version: 2.6.2
 * 
 */
@WebService(targetNamespace = "http://primesw.com/webservices", name = "QuoteServiceSoap")
@XmlSeeAlso({ObjectFactory.class, org.tempuri.quoteservice.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface QuoteServiceSoap {

    @WebMethod(operationName = "GetLDCInfo", action = "http://primesw.com/webservices/GetLDCInfo")
    @WebResult(name = "GetLDCInfoResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public GetLDCInfoResponse getLDCInfo(
        @WebParam(partName = "parameters", name = "GetLDCInfo", targetNamespace = "http://primesw.com/webservices")
        GetLDCInfo parameters
    );

    @WebMethod(operationName = "CheckUserSecurity", action = "http://primesw.com/webservices/CheckUserSecurity")
    @WebResult(name = "CheckUserSecurityResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public CheckUserSecurityResponse checkUserSecurity(
        @WebParam(partName = "parameters", name = "CheckUserSecurity", targetNamespace = "http://primesw.com/webservices")
        CheckUserSecurity parameters
    );

    @WebMethod(operationName = "UpdateCustomerInfo", action = "http://primesw.com/webservices/UpdateCustomerInfo")
    @WebResult(name = "UpdateCustomerInfoResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public UpdateCustomerInfoResponse updateCustomerInfo(
        @WebParam(partName = "parameters", name = "UpdateCustomerInfo", targetNamespace = "http://primesw.com/webservices")
        UpdateCustomerInfo parameters
    );

    @WebMethod(operationName = "CheckRAFEligibility", action = "http://primesw.com/webservices/CheckRAFEligibility")
    @WebResult(name = "CheckRAFEligibilityResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public CheckRAFEligibilityResponse checkRAFEligibility(
        @WebParam(partName = "parameters", name = "CheckRAFEligibility", targetNamespace = "http://primesw.com/webservices")
        CheckRAFEligibility parameters
    );

    @WebMethod(operationName = "AddPreenrollment", action = "http://primesw.com/webservices/AddPreenrollment")
    @WebResult(name = "AddPreenrollmentResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public AddPreenrollmentResponse addPreenrollment(
        @WebParam(partName = "parameters", name = "AddPreenrollment", targetNamespace = "http://primesw.com/webservices")
        AddPreenrollment parameters
    );

    @WebMethod(operationName = "GetPromoCodeInfo", action = "http://primesw.com/webservices/GetPromoCodeInfo")
    @WebResult(name = "GetPromoCodeInfoResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public GetPromoCodeInfoResponse getPromoCodeInfo(
        @WebParam(partName = "parameters", name = "GetPromoCodeInfo", targetNamespace = "http://primesw.com/webservices")
        GetPromoCodeInfo parameters
    );

    @WebMethod(operationName = "AuthenticateCustomer", action = "http://primesw.com/webservices/AuthenticateCustomer")
    @WebResult(name = "AuthenticateCustomerResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public AuthenticateCustomerResponse authenticateCustomer(
        @WebParam(partName = "parameters", name = "AuthenticateCustomer", targetNamespace = "http://primesw.com/webservices")
        AuthenticateCustomer parameters
    );

    @WebMethod(operationName = "GetQuotes", action = "http://primesw.com/webservices/GetQuotes")
    @WebResult(name = "GetQuotesResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public GetQuotesResponse getQuotes(
        @WebParam(partName = "parameters", name = "GetQuotes", targetNamespace = "http://primesw.com/webservices")
        GetQuotes parameters
    );

    @WebMethod(operationName = "GetCustomerInfo", action = "http://primesw.com/webservices/GetCustomerInfo")
    @WebResult(name = "GetCustomerInfoResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public GetCustomerInfoResponse getCustomerInfo(
        @WebParam(partName = "parameters", name = "GetCustomerInfo", targetNamespace = "http://primesw.com/webservices")
        GetCustomerInfo parameters
    );

    @WebMethod(operationName = "TPVDispositionNotification", action = "http://primesw.com/webservices/TPVDispositionNotification")
    @WebResult(name = "TPVDispositionNotificationResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public TPVDispositionNotificationResponse tpvDispositionNotification(
        @WebParam(partName = "parameters", name = "TPVDispositionNotification", targetNamespace = "http://primesw.com/webservices")
        TPVDispositionNotification parameters
    );

    @WebMethod(operationName = "EnrollCustomer", action = "http://primesw.com/webservices/EnrollCustomer")
    @WebResult(name = "EnrollCustomerResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public EnrollCustomerResponse enrollCustomer(
        @WebParam(partName = "parameters", name = "EnrollCustomer", targetNamespace = "http://primesw.com/webservices")
        EnrollCustomer parameters
    );

    @WebMethod(operationName = "GetListOfValues", action = "http://primesw.com/webservices/GetListOfValues")
    @WebResult(name = "GetListOfValuesResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public GetListOfValuesResponse getListOfValues(
        @WebParam(partName = "parameters", name = "GetListOfValues", targetNamespace = "http://primesw.com/webservices")
        GetListOfValues parameters
    );

    @WebMethod(operationName = "GetNESBillDetailData", action = "http://primesw.com/webservices/GetNESBillDetailData")
    @WebResult(name = "GetNESBillDetailDataResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public GetNESBillDetailDataResponse getNESBillDetailData(
        @WebParam(partName = "parameters", name = "GetNESBillDetailData", targetNamespace = "http://primesw.com/webservices")
        GetNESBillDetailData parameters
    );

    @WebMethod(operationName = "SearchCustomers", action = "http://primesw.com/webservices/SearchCustomers")
    @WebResult(name = "SearchCustomersResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public SearchCustomersResponse searchCustomers(
        @WebParam(partName = "parameters", name = "SearchCustomers", targetNamespace = "http://primesw.com/webservices")
        SearchCustomers parameters
    );

    @WebMethod(operationName = "GetPromoCodesForEnrollment", action = "http://primesw.com/webservices/GetPromoCodesForEnrollment")
    @WebResult(name = "GetPromoCodesForEnrollmentResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public GetPromoCodesForEnrollmentResponse getPromoCodesForEnrollment(
        @WebParam(partName = "parameters", name = "GetPromoCodesForEnrollment", targetNamespace = "http://primesw.com/webservices")
        GetPromoCodesForEnrollment parameters
    );

    @WebMethod(operationName = "SendRealTimeEmail", action = "http://primesw.com/webservices/SendRealTimeEmail")
    @WebResult(name = "SendRealTimeEmailResponse", targetNamespace = "http://primesw.com/webservices", partName = "parameters")
    public SendRealTimeEmailResponse sendRealTimeEmail(
        @WebParam(partName = "parameters", name = "SendRealTimeEmail", targetNamespace = "http://primesw.com/webservices")
        SendRealTimeEmail parameters
    );
}
