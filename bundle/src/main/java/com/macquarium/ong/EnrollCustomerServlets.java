package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tempuri.quoteservice.EnrollCustomerResult;
import org.tempuri.quoteservice.EnrollRequest;
import org.tempuri.quoteservice.SendRealTimeEmailRequest;
import org.tempuri.quoteservice.SendRealTimeEmailResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.macquarium.ong.vo.Enrollment;
import com.macquarium.ong.vo.RequestResponseVo;
import com.primesw.webservices.EnrollCustomer;
import com.primesw.webservices.EnrollCustomerResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import com.primesw.webservices.SendRealTimeEmail;
import com.primesw.webservices.SendRealTimeEmailResponse;


@SlingServlet(paths="/bin/enrollCustomer", methods = "POST", metatype=true)
public class EnrollCustomerServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {


	private Logger logger = LoggerFactory.getLogger(EnrollCustomerServlets.class);
	private static final long serialVersionUID = 2598426539166789515L;
	@Reference
	private CommonConfigService commonConfigService;

	@Reference
	private SendEmailService sendEmailService;

	@Reference
	private RequestResponseDaoService requestResponseDaoService;

	@Reference
	private EnrollmentDaoService enrollmentDaoService;

	private HashMap<String,String> mailContent=new HashMap<String,String>(8);

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj=new JSONObject();
		logger.info(" --> EnrollCustomerServlets doPost -->");
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		JSONObject jObj = null;
		URL url=null;
		logger.info("mapper create");
		ObjectMapper mapper = new ObjectMapper();
		try {
			logger.info(sb.toString());
			jObj = new JSONObject(sb.toString());
			String endPointUrl=	commonConfigService.getPrimeEndPoint();
			logger.info("Prime End PointUrl :"+endPointUrl);
			url = new URL(endPointUrl);
			String referrer = request.getHeader("referer");
			String portalName=getParameterInfo(jObj,"portalName");
			String domain=request.getServerName();
			long startTime = System.currentTimeMillis();
			logger.info("Start Time :"+startTime);
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeEndPoint());
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			EnrollRequest enrollRequest =new EnrollRequest();
			Enrollment enrollment =new Enrollment();
			String LDC=getParameterInfo(jObj,"LDC");
			String fixedPricePerTherm=getParameterInfo(jObj,"fixedPricePerTherm");
			enrollment.setPrice(fixedPricePerTherm);
			String rateClassCode=getParameterInfo(jObj,"rateClassCode");
			if(rateClassCode.equals("01")){
				enrollment.setCustomerType("Residential");
			}else if(rateClassCode.equals("04")){
				enrollment.setCustomerType("Commercial");
			}
			String tcversion=getParameterInfo(jObj,"tcversion");
			enrollment.setTcVersion(tcversion);
			enrollRequest.setLDC(LDC);
			enrollment.setLdc(LDC);
			String CustLeadSourceCode=getParameterInfo(jObj,"CustLeadSourceCode");
			enrollRequest.setCustLeadSourceCode(CustLeadSourceCode);
			enrollment.setCustLeadSourceCode(CustLeadSourceCode);
			String PromotionCode=getParameterInfo(jObj,"PromotionCode");
			enrollRequest.setPromotionCode(PromotionCode);
			enrollment.setPromotionCode(PromotionCode);
			String account=getParameterInfo(jObj,"account");
			enrollRequest.setAccount(account);
			enrollment.setAccount(account);

			String businessName=getParameterInfo(jObj,"businessName");
			enrollRequest.setBusinessName(businessName);
			enrollment.setBusinessName(businessName);
			String firstName	=getParameterInfo(jObj,"firstName");
			enrollRequest.setFirstName(firstName);
			enrollment.setFirstName(firstName);

			String lastName=getParameterInfo(jObj,"lastName");
			enrollRequest.setLastName(lastName);
			enrollment.setLastName(lastName);
			String mailAddress1=getParameterInfo(jObj,"mailAddress1");
			enrollRequest.setMailAddress1(mailAddress1);
			enrollment.setMailAddress1(mailAddress1);
			String mailAddress2=getParameterInfo(jObj,"mailAddress2");
			enrollRequest.setMailAddress2(mailAddress2);
			enrollment.setMailAddress2(mailAddress2);
			String mailCity=getParameterInfo(jObj,"mailCity");
			enrollRequest.setMailCity(mailCity);
			enrollment.setMailCity(mailCity);
			String mailStateCode=getParameterInfo(jObj,"mailStateCode");
			enrollRequest.setMailStateCode(mailStateCode);
			enrollment.setMailStateCode(mailStateCode);
			String mailZipCode=getParameterInfo(jObj,"mailZipCode");
			enrollRequest.setMailZipCode(mailZipCode);
			enrollment.setMailZipCode(mailZipCode);
			String phoneNumber=getParameterInfo(jObj,"phoneNumber");
			enrollRequest.setPhoneNumber(phoneNumber);
			enrollment.setPhoneNumber(phoneNumber);
			String premise=getParameterInfo(jObj,"premise");
			enrollRequest.setPremise(premise);
			enrollment.setPremise(premise);
			String productCode=getParameterInfo(jObj,"productCode");
			enrollRequest.setProductCode(productCode);
			enrollment.setProductCode(productCode);
			String responseStatus=getParameterInfo(jObj,"responseStatus");
			String responsemessage=getParameterInfo(jObj, "responseMessage");
			String renewalContractExistsInd=getParameterInfo(jObj,"renewalContractExistsInd");
			String existingCustomerStatus=getParameterInfo(jObj,"existingCustomerStatus");
			if(responseStatus.equals("0")){
				if(existingCustomerStatus.equals("Active")){
					if(renewalContractExistsInd.equals("Y")){
						enrollment.setTransactionType("PPC-RS");
					}else{
						enrollment.setTransactionType("PPC");
					}
				}else{
					enrollment.setTransactionType("ReEnroll");
				}
				if(renewalContractExistsInd.equals("Y")){
					enrollRequest.setActionIfContractExists("3");
					enrollment.setActionIfContractExists("3");
				}else if(renewalContractExistsInd.equals("N")){
					enrollRequest.setActionIfContractExists("1");
					enrollment.setActionIfContractExists("1");
				}
			}else if(responseStatus.equals("1")){
				enrollRequest.setActionIfContractExists("1");
				enrollment.setActionIfContractExists("1");
				enrollment.setTransactionType("Enroll");

			}
			String serviceAddress1=getParameterInfo(jObj,"serviceAddress1");
			enrollRequest.setServiceAddress1(serviceAddress1);
			enrollment.setServiceAddress1(serviceAddress1);
			String serviceAddress2=getParameterInfo(jObj,"serviceAddress2");
			enrollRequest.setServiceAddress2(serviceAddress2);
			enrollment.setServiceAddress2(serviceAddress2);
			String serviceCity=getParameterInfo(jObj,"serviceCity");
			enrollRequest.setServiceCity(serviceCity);
			enrollment.setServiceCity(serviceCity);
			String serviceStateCode=getParameterInfo(jObj,"serviceStateCode");
			enrollRequest.setServiceStateCode(serviceStateCode);
			enrollment.setServiceStateCode(serviceStateCode);
			String serviceZipCode=getParameterInfo(jObj,"serviceZipCode");
			enrollment.setServiceZipCode(serviceZipCode);
			String emailid=getParameterInfo(jObj, "emailAddress");
			String specialoffer=getParameterInfo(jObj, "specialoffer");
			String custID=getParameterInfo(jObj, "custID");
			if(specialoffer =="true"){
				//enrollRequest.setEmailPrefSSEPromotionalCd("Y");
				enrollRequest.setEmailPrefNonTransactionalCd("Y");
				enrollment.setEmailPrefNonTransactionalCd("Y");
			}else{
				enrollRequest.setEmailPrefNonTransactionalCd("N");
				enrollment.setEmailPrefNonTransactionalCd("N");
			}
			enrollRequest.setEmailAddress(emailid);
			enrollment.setEmailAddress(emailid);
			String portalname=getParameterInfo(jObj,"portalname");
			if(portalname.equals("oh")){
				enrollRequest.setEnrolledByUserId("Web Enroll-ONG");
				enrollment.setEnrolledByUserId("Web Enroll-ONG");
			}else if(portalname.equals("gre")){
				enrollRequest.setEnrolledByUserId("Web Enroll-GRE");
				enrollment.setEnrolledByUserId("Web Enroll-GRE");
			}

			String altrnateEmailAddress=getParameterInfo(jObj,"alternateEmailAddress");
			String emailTypeCode=getParameterInfo(jObj,"emailTypeCode");
			enrollRequest.setAlternateEmailAddress(altrnateEmailAddress);
			enrollRequest.setEmailTypeCode(emailTypeCode);
			enrollRequest.setServiceZipCode(serviceZipCode);
			enrollment.setServiceZipCode(serviceZipCode);
			//enrollRequest.setEmailPrefTransactionalCd("Y");
			enrollment.setEmailPrefTranctionalCd("Y");
			//Need to make it as dynamic
			enrollRequest.setAuthorizationCode("internal");
			enrollment.setAuthorizationCode("internal");
			enrollRequest.setAuthorizationLevel("3");
			enrollment.setAuthorizationLevel("3");
			enrollRequest.setChannelID("Online");
			enrollment.setChannelID("Online");

			Calendar currentCalendar = Calendar.getInstance();
			java.sql.Date todayDate = new java.sql.Date(currentCalendar.getTime().getTime());
			enrollment.setCreatedDate(todayDate);

			enrollment.setCustID("");
			String RAFCode=getParameterInfo(jObj,"RAFCode");
			enrollment.setRafCode(RAFCode);
			enrollment.setAuthorityToSwitchFlag("Y");
			enrollment.setAgreeToTermsFlag("Y");
			enrollment.setServiceTransferAuthFlag("Y");
			enrollRequest.setRAFCode(RAFCode);
			logger.info("Inserting enrollment info to data base");
			int generatedKey=enrollmentDaoService.insertEnrollment(enrollment);
			logger.info("Generated key after database insertion");
			logger.info(String.valueOf(generatedKey));
			enrollRequest.setEnrollConfirmationNumber(Integer.toString(generatedKey));
			EnrollCustomer parameters=new EnrollCustomer();
			parameters.setEnrollRequest(enrollRequest);
			EnrollCustomerResponse enrollCustomerResponse=quoteServiceSoap.enrollCustomer(parameters);
			EnrollCustomerResult enrollCustomerResult=enrollCustomerResponse.getEnrollCustomerResult();
			String soapRequest=handlerResolver.getRequest();
			String soapResponse=handlerResolver.getResponse();
			logger.info("request");
			logger.info(soapRequest);
			logger.info("response");
			logger.info(soapResponse);
			RequestResponseVo requestResponseVo=new RequestResponseVo();
			requestResponseVo.setAccnt(account);
			requestResponseVo.setApiCall("EnrollCustomer");
			requestResponseVo.setLdc(LDC);
			requestResponseVo.setOrderNumber(Integer.toString(generatedKey));
			requestResponseVo.setPage(referrer);
			requestResponseVo.setPostXML(soapRequest);
			requestResponseVo.setRespMessage(enrollCustomerResult.getResponseMessage());
			requestResponseVo.setRespNumb(enrollCustomerResult.getResponseStatus());
			requestResponseVo.setReturnXML(soapResponse);
			requestResponseVo.setSite(domain);
			requestResponseDaoService.insertPrimeRequestResponse(requestResponseVo);
			String sameProductCode=getParameterInfo(jObj,"sameProductCode");

			String emailtype="";
			if(responseStatus.equals("0")){
				logger.info("existing customer");
				if(existingCustomerStatus.equals("Active")){
					logger.info("active customer");
					if(sameProductCode.equals("Y")){
						logger.info("customer with same plan");
						emailtype="PPCCONFIRM";
					}else{
						logger.info("customer with different plan");
						emailtype="RENEWCONFIRM";
					}
				}else{
					logger.info("Inactive customer");
					emailtype="ENCONFIRM";
				}
			}else if(responseStatus.equals("1")){
				logger.info("New customer");
				emailtype="ENCONFIRM";
			}
			logger.info("");
			String alternateEmailAddress =getParameterInfo(jObj,"alternateEmailAddress");

			SendRealTimeEmailRequest sendRealTimeEmailRequest=new SendRealTimeEmailRequest();
			logger.info("");
			if(responseStatus.equals("1")) {
				sendRealTimeEmailRequest.setCustID(enrollCustomerResult.getCustID());
			}
			else if(responseStatus.equals("0")) {
				sendRealTimeEmailRequest.setCustID(custID);
			}
			sendRealTimeEmailRequest.setEmailAddress(emailid);   //emailAddress
			sendRealTimeEmailRequest.setEmailType(emailtype);
			if(alternateEmailAddress.length()>0){
				sendRealTimeEmailRequest.setUpdateCustEmailAddressInd("Y");
			}
			SendRealTimeEmail sendRealTimeEmail=new SendRealTimeEmail();
			sendRealTimeEmail.setSendRealTimeEmailRequest(sendRealTimeEmailRequest);
			logger.info("start sendRealTimeEmail");
			String sendrealtimerequest=handlerResolver.getRequest();
			String sendrealtimeresponse= handlerResolver.getResponse();
			String sendRealTimeResponseMessage = "";
			try{
				SendRealTimeEmailResponse sendRealTimeEmailResponse= quoteServiceSoap.sendRealTimeEmail(sendRealTimeEmail);
				logger.info("end sendRealTimeEmail");

				SendRealTimeEmailResult sendRealTimeEmailResult=sendRealTimeEmailResponse.getSendRealTimeEmailResult();
				sendRealTimeResponseMessage=sendRealTimeEmailResult.getResponseMessage();
				logger.info("getResponseStatus: "+sendRealTimeEmailResult.getResponseStatus());
				logger.info("getResponseMessage "+sendRealTimeEmailResult.getResponseMessage());
				RequestResponseVo sendRealTimeRequestResponseVo=new RequestResponseVo();
				logger.info(account);
				sendRealTimeRequestResponseVo.setAccnt(account);
				sendRealTimeRequestResponseVo.setApiCall("sendRealTimeEmail");
				sendRealTimeRequestResponseVo.setLdc(LDC);
				sendRealTimeRequestResponseVo.setOrderNumber("0");
				sendRealTimeRequestResponseVo.setPage(referrer);
				sendRealTimeRequestResponseVo.setPostXML(sendrealtimerequest);
				sendRealTimeRequestResponseVo.setRespMessage(sendRealTimeEmailResult.getResponseMessage());
				sendRealTimeRequestResponseVo.setRespNumb(sendRealTimeEmailResult.getResponseStatus());
				sendRealTimeRequestResponseVo.setReturnXML(sendrealtimeresponse);
				sendRealTimeRequestResponseVo.setSite(domain);

				logger.info("before insert to database");
				requestResponseDaoService.insertPrimeRequestResponse(sendRealTimeRequestResponseVo);


				logger.info("requestresponse inserted sendrealtime");

			}catch(Exception e){
				mailContent.put("request", sendrealtimerequest);
				mailContent.put("response", sendrealtimeresponse);
				mailContent.put("responseMessage", sendRealTimeResponseMessage);
				mailContent.put("currentPagePath", referrer);
				mailContent.put("siteDomain", domain);
				handelCatchBlock(e,mailContent);
			}


			enrollment.setCustID(enrollCustomerResult.getCustID());

			enrollmentDaoService.updateEnrollement(enrollment,generatedKey);
			String jsonString = mapper.writeValueAsString(enrollCustomerResult);
			obj.put("EnrollCustomerResult", jsonString);
			obj.put("enrollId", generatedKey);
			obj.put("status", enrollCustomerResult.getResponseStatus());
			obj.put("ResponseMessage", enrollCustomerResult.getResponseMessage());
			if(enrollCustomerResult.getResponseStatus().equalsIgnoreCase("-1") || enrollCustomerResult.getResponseStatus().equalsIgnoreCase("1")) {
				logger.info("Send mail with prime error");
				mailContent.put("request", soapRequest);
				mailContent.put("response", soapResponse);
				mailContent.put("responseMessage", responsemessage);
				mailContent.put("currentPagePath", referrer);
				mailContent.put("siteDomain", domain);
				sendEmailService.sendEmail(mailContent);

			}

			long endTime = System.currentTimeMillis();
			long differenceTime=endTime-startTime;
			logger.info("time taken to get the response from prime: "+String.valueOf(differenceTime));

		}  catch (MalformedURLException e) {
			handelCatchBlock(e,mailContent);
			try{
				obj.put("resultCode", "1");
				obj.put("resultMessage", "systemError");
				obj.put("errorDescription", e.getMessage());
			}catch(Exception e3){
				handelCatchBlock(e3,mailContent);
			}
		}	catch (JSONException e) {
			handelCatchBlock(e,mailContent);
			try {
				obj.put("resultCode", "1");
				obj.put("resultMessage", "systemError");
				obj.put("errorDescription", e.getMessage());
			} catch (Exception e1) {
				handelCatchBlock(e1,mailContent);
			}
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);

	}

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj=new JSONObject();
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);
		logger.info("<-- EnrollCustomerServlets doPost <--");
	}

	String getParameterInfo(JSONObject JObject, String parameter){
		String result="";
		try{
			result=JObject.getString(parameter);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return result;
	}
	private void handelCatchBlock(Exception e, HashMap<String,String> mailContent){
		String stackTrace=CommonUtil.stackTraceToString(e);
		logger.info("MalformedURLException :"+e.getMessage());
		logger.error(e.getMessage());
		logger.error(e.getMessage(),e);
		mailContent.put("stackTrace", stackTrace);
		sendEmailService.sendExceptionEmail(mailContent);
	}
}
