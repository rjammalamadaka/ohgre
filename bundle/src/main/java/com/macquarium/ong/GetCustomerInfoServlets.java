package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.HashMap;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tempuri.quoteservice.GetCustomerInfoRequest;
import org.tempuri.quoteservice.GetCustomerInfoResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.macquarium.ong.vo.RequestResponseVo;
import com.primesw.webservices.GetCustomerInfo;
import com.primesw.webservices.GetCustomerInfoResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;


@SlingServlet(paths="/bin/getCustomerInfo", methods = "POST", metatype=true)
public class GetCustomerInfoServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private Logger logger = LoggerFactory.getLogger(GetCustomerInfoServlets.class);

	private static final long serialVersionUID = 2598426539166789515L;
	@Reference
	private CommonConfigService commonConfigService;
	@Reference
	private SendEmailService sendEmailService;
	@Reference
	private RequestResponseDaoService requestResponseDaoService;
	private HashMap<String,String> mailContent=new HashMap<String,String>(8);

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {

		logger.info("--> GetCustomerInfoServlets doGet -->");
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
			String accountNumber = getParameterInfo(jObj,"AccountNumber");
			String ldc = getParameterInfo(jObj,"LDC");
			String custId = getParameterInfo(jObj,"custId");
			String endPointUrl=	commonConfigService.getPrimeEndPoint();
			logger.info("Prime End PointUrl :"+endPointUrl);
			String referrer = request.getHeader("referer");
			String domain=request.getServerName();
			url = new URL(endPointUrl);
			long startTime = System.currentTimeMillis();
			logger.info("Start Time :"+startTime);
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeEndPoint());
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			GetCustomerInfo getCustomerInfo=new GetCustomerInfo();
			GetCustomerInfoRequest getCustomerInfoRequest=new GetCustomerInfoRequest();
			logger.info("ldc :"+ldc);
			logger.info("accountNumber :"+accountNumber);
			getCustomerInfoRequest.setAccount(accountNumber);
			getCustomerInfoRequest.setLDC(ldc);
			getCustomerInfoRequest.setCustID(custId);
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
			RequestResponseVo requestResponseVo=new RequestResponseVo();
			requestResponseVo.setAccnt(accountNumber);
			requestResponseVo.setApiCall("GetCustomerInfo");
			requestResponseVo.setLdc(ldc);
			requestResponseVo.setOrderNumber("0");
			requestResponseVo.setPage(referrer);
			requestResponseVo.setPostXML(soapRequest);
			requestResponseVo.setRespMessage(getCustomerInfoResult.getResponseMessage());
			requestResponseVo.setRespNumb(getCustomerInfoResult.getResponseStatus());
			requestResponseVo.setReturnXML(soapResponse);
			requestResponseVo.setSite(domain);
			requestResponseDaoService.insertPrimeRequestResponse(requestResponseVo);

			if(getCustomerInfoResult.getResponseStatus().equalsIgnoreCase("-1")) {
				logger.info("Send mail with prime error");
				mailContent.put("request", soapRequest);
				mailContent.put("response", soapResponse);
				mailContent.put("responseMessage", getCustomerInfoResult.getResponseMessage());
				mailContent.put("currentPagePath", referrer);
				mailContent.put("siteDomain", domain);
				sendEmailService.sendEmail(mailContent);
			}

			String jsonString = mapper.writeValueAsString(getCustomerInfoResult);
			obj.put("CustomerInfoResult", jsonString);
			obj.put("status", getCustomerInfoResult.getResponseStatus());

		} catch (MalformedURLException e) {
			handelCatchBlock(e,mailContent);
		}	catch (JSONException e) {
			handelCatchBlock(e,mailContent);
		}	catch (Exception e){
			handelCatchBlock(e,mailContent);
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
			//logger.error(e.getMessage(), e);
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
