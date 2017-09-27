package com.macquarium.ong;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primesw.webservices.EnrollCustomer;
import com.primesw.webservices.EnrollCustomerResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.EnrollCustomerResult;
import org.tempuri.quoteservice.EnrollRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;


@SlingServlet(paths="/bin/enrollCustomer", methods = "POST", metatype=true)
public class EnrollCustomerServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private static final long serialVersionUID = 2598426539166789515L;
	@Reference
	private CommonConfigService commonConfigService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj=new JSONObject();
		System.out.println("doPost");
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		JSONObject jObj = null;
		URL url=null;
		System.out.println("mapper create");
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(sb);
			jObj = new JSONObject(sb.toString());
			String endPointUrl=	commonConfigService.getPrimeEndPoint();
			url = new URL(endPointUrl);
			long startTime = System.currentTimeMillis();

			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver();
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();

			EnrollRequest enrollRequest =new EnrollRequest();
			String LDC=getParameterInfo(jObj,"LDC");
			enrollRequest.setLDC(LDC);
			String CustLeadSourceCode=getParameterInfo(jObj,"CustLeadSourceCode");
			enrollRequest.setCustLeadSourceCode(CustLeadSourceCode);
			String PromotionCode=getParameterInfo(jObj,"PromotionCode");
			enrollRequest.setPromotionCode(PromotionCode);
			String account=getParameterInfo(jObj,"account");
			enrollRequest.setAccount(account);

			String businessName=getParameterInfo(jObj,"businessName");
			enrollRequest.setBusinessName(businessName);
			String firstName	=getParameterInfo(jObj,"firstName");
			enrollRequest.setFirstName(firstName);

			String lastName=getParameterInfo(jObj,"lastName");
			enrollRequest.setLastName(lastName);
			String mailAddress1=getParameterInfo(jObj,"mailAddress1");
			enrollRequest.setMailAddress1(mailAddress1);
			String mailAddress2=getParameterInfo(jObj,"mailAddress2");
			enrollRequest.setMailAddress2(mailAddress2);
			String mailCity=getParameterInfo(jObj,"mailCity");
			enrollRequest.setMailCity(mailCity);
			String mailStateCode=getParameterInfo(jObj,"mailStateCode");
			enrollRequest.setMailStateCode(mailStateCode);
			String mailZipCode=getParameterInfo(jObj,"mailZipCode");
			enrollRequest.setMailZipCode(mailZipCode);
			String phoneNumber=getParameterInfo(jObj,"phoneNumber");
			enrollRequest.setPhoneNumber(phoneNumber);
			String premise=getParameterInfo(jObj,"premise");
			enrollRequest.setPremise(premise);
			String productCode=getParameterInfo(jObj,"productCode");
			enrollRequest.setProductCode(productCode);
			String responseStatus=getParameterInfo(jObj,"responseStatus");
			String renewalContractExistsInd=getParameterInfo(jObj,"renewalContractExistsInd");
			if(responseStatus.equals("0")){
				if(renewalContractExistsInd.equals("Y")){
					enrollRequest.setActionIfContractExists("3");
				}else if(renewalContractExistsInd.equals("N")){
					enrollRequest.setActionIfContractExists("1");
				}
			}else if(responseStatus.equals("1")){
				enrollRequest.setActionIfContractExists("1");
			}
			String serviceAddress1=getParameterInfo(jObj,"serviceAddress1");
			enrollRequest.setServiceAddress1(serviceAddress1);
			String serviceAddress2=getParameterInfo(jObj,"serviceAddress2");
			enrollRequest.setServiceAddress2(serviceAddress2);
			String serviceCity=getParameterInfo(jObj,"serviceCity");
			enrollRequest.setServiceCity(serviceCity);
			String serviceStateCode=getParameterInfo(jObj,"serviceStateCode");
			enrollRequest.setServiceStateCode(serviceStateCode);
			String serviceZipCode=getParameterInfo(jObj,"serviceZipCode");
			String emailid=getParameterInfo(jObj, "emailAddress");
			String specialoffer=getParameterInfo(jObj, "specialoffer");
			if(specialoffer =="true"){
				enrollRequest.setEmailPrefSSEPromotionalCd("Y");
			}else{
				enrollRequest.setEmailPrefSSEPromotionalCd("N");
			}
			enrollRequest.setEmailAddress(emailid);
			String portalname=getParameterInfo(jObj,"portalname");
			if(portalname.equals("oh")){
				enrollRequest.setEnrolledByUserId("Web Enroll-ONG");
			}else if(portalname.equals("gre")){
				enrollRequest.setEnrolledByUserId("Web Enroll-GRE");
			}

			enrollRequest.setServiceZipCode(serviceZipCode);
			enrollRequest.setEmailPrefTransactionalCd("Y");
			//Need to make it as dynamic
			enrollRequest.setAuthorizationCode("internal");
			enrollRequest.setAuthorizationLevel("3");
			EnrollCustomer parameters=new EnrollCustomer();
			parameters.setEnrollRequest(enrollRequest);
			EnrollCustomerResponse enrollCustomerResponse=quoteServiceSoap.enrollCustomer(parameters);
			EnrollCustomerResult enrollCustomerResult=enrollCustomerResponse.getEnrollCustomerResult();

			String jsonString = mapper.writeValueAsString(enrollCustomerResult);
			obj.put("EnrollCustomerResult", jsonString);
			obj.put("status", enrollCustomerResult.getResponseStatus());

			long endTime = System.currentTimeMillis();
			long differenceTime=endTime-startTime;
			System.out.println("time taken to get the response from prime: "+String.valueOf(differenceTime));
			//obj.put("Customer", customerArray);
		}  catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("got error"+e.getMessage());
			try{
				obj.put("resultCode", "1");
				obj.put("resultMessage", "systemError");
				obj.put("errorDescription", e.getMessage());
			}catch(Exception e3){

			}
		}	catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("got error"+e.getMessage());
			try {
				obj.put("resultCode", "1");
				obj.put("resultMessage", "systemError");
				obj.put("errorDescription", e.getMessage());
			} catch (Exception e1) {

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
	}

	String getParameterInfo(JSONObject JObject, String parameter){
		String result="";
		try{
			result=JObject.getString(parameter);
		}catch(Exception e){

		}
		return result;
	}
}
