package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.rmi.ServerException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.SendRealTimeEmailRequest;
import org.tempuri.quoteservice.SendRealTimeEmailResult;

import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import com.primesw.webservices.SendRealTimeEmail;
import com.primesw.webservices.SendRealTimeEmailResponse;


@SlingServlet(paths="/bin/sendRafEmail", methods = "POST", metatype=true)
public class SendRafEmailServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private static final long serialVersionUID = 2598426539166789515L;

	@Reference
    private CommonConfigService commonConfigService;
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj = new JSONObject();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		JSONObject jObj = null;
		URL url=null;
		try {
			String endPointUrl=	commonConfigService.getPrimeEndPoint();
			System.out.println("endPointUrl :"+endPointUrl);
			url = new URL(endPointUrl);
			long startTime = System.currentTimeMillis();
			jObj = new JSONObject(sb.toString());
			
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeHeaderHandlerUrl());
			quoteService.setHandlerResolver(handlerResolver);		
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			
			SendRealTimeEmailRequest sendRealTimeEmailRequest=new SendRealTimeEmailRequest();			
			
			//sendRealTimeEmailRequest.setCampaignName("");
			sendRealTimeEmailRequest.setCustID(getParameterInfo(jObj,"custID"));  //custID
			sendRealTimeEmailRequest.setEmailAddress(getParameterInfo(jObj,"emailAddress"));   //emailAddress
			sendRealTimeEmailRequest.setEmailType("RAFGEN");
			//sendRealTimeEmailRequest.setListID("");
			//sendRealTimeEmailRequest.setOverrideCustID("");
			//sendRealTimeEmailRequest.setOverrideEmailAddress(getParameterInfo(jObj,"emailAddress"));	//emailAddress		
			//sendRealTimeEmailRequest.setRealmID("");
			//sendRealTimeEmailRequest.setTemplateID("");
			sendRealTimeEmailRequest.setUpdateCustEmailAddressInd("Y");
						
			SendRealTimeEmail sendRealTimeEmail=new SendRealTimeEmail();
			sendRealTimeEmail.setSendRealTimeEmailRequest(sendRealTimeEmailRequest);
			SendRealTimeEmailResponse sendRealTimeEmailResponse= quoteServiceSoap.sendRealTimeEmail(sendRealTimeEmail);
			SendRealTimeEmailResult sendRealTimeEmailResult=sendRealTimeEmailResponse.getSendRealTimeEmailResult();

			String soapRequest=handlerResolver.getRequest();
			String soapResponse=handlerResolver.getResponse();
			System.out.println("request");
			System.out.println(soapRequest);
			System.out.println("response");
			System.out.println(soapResponse);
	
			obj.put("ResponseStatus", sendRealTimeEmailResult.getResponseStatus());
			obj.put("ResponseMessage", sendRealTimeEmailResult.getResponseMessage());
			
		} catch (JSONException e) {
			try {
				obj.put("ResponseStatus", "1");
				obj.put("ResponseMessage", "error");
			} catch (Exception e1) {
				e.printStackTrace();
			}
			
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);

	}
	
	  String getParameterInfo(JSONObject JObject, String parameter){
	    	String result="";
	    	try{
	    		result=JObject.getString(parameter);
	    	}catch(Exception e){
				e.printStackTrace();

			}
	    	return result;
	    }

}