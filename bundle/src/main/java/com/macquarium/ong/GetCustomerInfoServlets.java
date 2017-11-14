package com.macquarium.ong;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primesw.webservices.GetCustomerInfo;
import com.primesw.webservices.GetCustomerInfoResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.GetCustomerInfoRequest;
import org.tempuri.quoteservice.GetCustomerInfoResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;


@SlingServlet(paths="/bin/getCustomerInfo", methods = "POST", metatype=true)
public class GetCustomerInfoServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private static final long serialVersionUID = 2598426539166789515L;
	@Reference
	private CommonConfigService commonConfigService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj=new JSONObject();
		URL url=null;
		GetCustomerInfoResult getCustomerInfoResult=null;
		ObjectMapper mapper = new ObjectMapper();
		try {

			StringBuilder sb = new StringBuilder();
			BufferedReader br = request.getReader();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			JSONObject jObj = null;
			jObj = new JSONObject(sb.toString());
			String accountNumber = getParameterInfo(jObj,"AccountNumber");// jObj.getString("AccountNumber");
				String ldc = getParameterInfo(jObj,"LDC");//jObj.getString("LDC");
				String custId = getParameterInfo(jObj,"custId"); //jObj.getString("custId");
			String endPointUrl=	commonConfigService.getPrimeEndPoint();
			url = new URL(endPointUrl);

			long startTime = System.currentTimeMillis();
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeHeaderHandlerUrl());
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			GetCustomerInfo getCustomerInfo=new GetCustomerInfo();
			GetCustomerInfoRequest getCustomerInfoRequest=new GetCustomerInfoRequest();
			System.out.println("ldc :"+ldc);
			System.out.println("accountNumber :"+accountNumber);
			//if(accountNumber.length()>0 && ldc.length()>0){
	           getCustomerInfoRequest.setAccount(accountNumber);
	           getCustomerInfoRequest.setLDC(ldc);
	           //}
	           //if(custId.length()>0){
	           getCustomerInfoRequest.setCustID(custId);
	           //}
			//getCustomerInfoRequest.setPremise("");
			getCustomerInfo.setGetCustomerInfoRequest(getCustomerInfoRequest);

			GetCustomerInfoResponse getCustomerInfoResponse = quoteServiceSoap.getCustomerInfo(getCustomerInfo);
			getCustomerInfoResult=getCustomerInfoResponse.getGetCustomerInfoResult();

			String soapRequest=handlerResolver.getRequest();
			String soapResponse=handlerResolver.getResponse();
			System.out.println("request");
			System.out.println(soapRequest);
			System.out.println("response");
			System.out.println(soapResponse);

			// getCustomerInfoResult.get
			String jsonString = mapper.writeValueAsString(getCustomerInfoResult);
			obj.put("CustomerInfoResult", jsonString);
			obj.put("status", getCustomerInfoResult.getResponseStatus());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("got error"+e.getMessage());
			e.printStackTrace();
		}	catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("got error"+e.getMessage());
			e.printStackTrace();
		}
		catch (Exception e){
			System.out.println("got error"+e.getMessage());
			e.printStackTrace();
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);

	}

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		doPost(request,response);
	}
    String getParameterInfo(JSONObject JObject, String parameter){
	    	String result="";
		try{
			result=JObject.getString(parameter);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return result;
	}

}
