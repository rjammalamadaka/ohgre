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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SlingServlet(paths="/bin/getCustomerInfo", methods = "POST", metatype=true)
public class GetCustomerInfoServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private Logger logger = LoggerFactory.getLogger(GetCustomerInfoServlets.class);

	private static final long serialVersionUID = 2598426539166789515L;
	@Reference
	private CommonConfigService commonConfigService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {

		logger.info("--> GetCustomerInfoServlets doGet -->");JSONObject obj=new JSONObject();
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
			logger.info("Prime End PointUrl :"+endPointUrl);
			url = new URL(endPointUrl);

			long startTime = System.currentTimeMillis();
			logger.info("Start Time :"+startTime);
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeHeaderHandlerUrl());
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			GetCustomerInfo getCustomerInfo=new GetCustomerInfo();
			GetCustomerInfoRequest getCustomerInfoRequest=new GetCustomerInfoRequest();
			logger.info("ldc :"+ldc);
			logger.info("accountNumber :"+accountNumber);
			//if(accountNumber.length()>0 && ldc.length()>0){
	           getCustomerInfoRequest.setAccount(accountNumber);
	           getCustomerInfoRequest.setLDC(ldc);
	           //}
	           //if(custId.length()>0){
	           getCustomerInfoRequest.setCustID(custId);
	           //}
			//getCustomerInfoRequest.setPremise("");
			logger.info("PRIME getCustomerInfo");
			getCustomerInfo.setGetCustomerInfoRequest(getCustomerInfoRequest);

			GetCustomerInfoResponse getCustomerInfoResponse = quoteServiceSoap.getCustomerInfo(getCustomerInfo);
			getCustomerInfoResult=getCustomerInfoResponse.getGetCustomerInfoResult();
			long endTime = System.currentTimeMillis();
			logger.info("End Time :"+endTime);
			long differenceTime=endTime-startTime;
			logger.info("Time taken to get the response from prime:"+String.valueOf(differenceTime));
			String soapRequest=handlerResolver.getRequest();
			String soapResponse=handlerResolver.getResponse();
			logger.info("request");
			logger.info(soapRequest);
			logger.info("response");
			logger.info(soapResponse);

			// getCustomerInfoResult.get
			String jsonString = mapper.writeValueAsString(getCustomerInfoResult);
			obj.put("CustomerInfoResult", jsonString);
			obj.put("status", getCustomerInfoResult.getResponseStatus());

		} catch (MalformedURLException e) {

			logger.info("MalformedURLException "+e.getMessage());
			logger.error(e.getMessage());
			logger.error(e.getMessage(),e);
		}	catch (JSONException e) {

			logger.info("JSONException"+e.getMessage());
			logger.error(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		catch (Exception e){
			logger.info("Exception"+e.getMessage());
			logger.error(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		String jsonData = obj.toString();
		logger.info("Json Response");
		logger.info(jsonData);
		logger.info("<-- GetCustomerInfoServlets doGet <--");
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
			logger.info("Exception"+e.getMessage());
			logger.error(e.getMessage());
			logger.error(e.getMessage(), e);
		}
		return result;
	}

}
