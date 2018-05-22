package com.macquarium.ong;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tempuri.quoteservice.GetLDCInfoRequest;
import org.tempuri.quoteservice.GetLDCInfoResult;
import org.tempuri.quoteservice.GetLDCInfoResult.LDC;

import com.macquarium.ong.vo.RequestResponseVo;
import com.primesw.webservices.GetLDCInfo;
import com.primesw.webservices.GetLDCInfoResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;


@SlingServlet(paths="/bin/getLDCInfoServlet", methods = "GET", metatype=true)
public class GetLDCInfoServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private Logger logger = LoggerFactory.getLogger(GetLDCInfoServlet.class);
	private static final long serialVersionUID = 1L;

	@Reference
	private CommonConfigService commonConfigService;

	@Reference
	private SendEmailService sendEmailService;

	@Reference
	private RequestResponseDaoService requestResponseDaoService;

	private HashMap<String,String> mailContent=new HashMap<String,String>(8);

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		logger.info("--> GetLDCInfoServlet doGet -->");

		JSONObject obj=new JSONObject();
		try {
			obj.put("method", "Post");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);
	}

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj=new JSONObject();

		URL url=null;
		try {
			String endPointUrl=	commonConfigService.getPrimeEndPoint();
			logger.info("endPointUrl :"+endPointUrl);
			url = new URL(endPointUrl);
			long startTime = System.currentTimeMillis();
			String referrer = request.getHeader("referer");
			String domain=request.getServerName();
			String portalName=request.getParameter("portalName");
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeEndPoint());
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			GetLDCInfo getLDCInfo=new GetLDCInfo();
			GetLDCInfoRequest getLDCInfoRequest=new GetLDCInfoRequest();

			if(portalName.equals("oh")){
				getLDCInfoRequest.setStateCode("OH");
			}else if(portalName.equals("gre")){
				getLDCInfoRequest.setStateCode("MI");
			}
			getLDCInfo.setGetLDCInfoRequest(getLDCInfoRequest);
			GetLDCInfoResponse getLDCInfoResponse =quoteServiceSoap.getLDCInfo(getLDCInfo);
			GetLDCInfoResult getLDCInfoResult=getLDCInfoResponse.getGetLDCInfoResult();
			String soapRequest=handlerResolver.getRequest();
			String soapResponse=handlerResolver.getResponse();
			logger.info("request");
			logger.info(soapRequest);
			logger.info("response");
			logger.info(soapResponse);
			String responseStatus=getLDCInfoResult.getResponseStatus();
			String responsemessage=getLDCInfoResult.getResponseMessage();
			obj.put("responseStatus", responseStatus);
			obj.put("responsemessage", responsemessage);
			logger.info("responseStatus :"+responseStatus);
			logger.info("responsemessage :"+responsemessage);
			RequestResponseVo requestResponseVo=new RequestResponseVo();
			requestResponseVo.setAccnt("");
			requestResponseVo.setApiCall("GetLDCInfo");
			requestResponseVo.setLdc("");
			requestResponseVo.setOrderNumber("0");
			requestResponseVo.setPage(referrer);
			requestResponseVo.setPostXML(soapRequest);
			requestResponseVo.setRespMessage(responsemessage);
			requestResponseVo.setRespNumb(responseStatus);
			requestResponseVo.setReturnXML(soapResponse);
			requestResponseVo.setSite(domain);

			requestResponseDaoService.insertPrimeRequestResponse(requestResponseVo);

			List<LDC> ldcList=getLDCInfoResult.getLDC();

			JSONArray ldcListAray=new JSONArray();
			for(LDC ldc:ldcList){
				JSONObject ldcObj=new JSONObject();
				ldcObj.put("LDCDesc", ldc.getLDCDesc());
				ldcObj.put("LDCCode", ldc.getLDCCode());
				ldcObj.put("LDCCustomerServicePhone", ldc.getLDCCustomerServicePhone());
				ldcObj.put("LDCEmergencyPhone", ldc.getLDCEmergencyPhone());
				ldcListAray.put(ldcObj);
			}
			long endTime = System.currentTimeMillis();
			long differenceTime=endTime-startTime;
			if(responseStatus.equalsIgnoreCase("-1")) {
				logger.info("Send mail with prime error");
				mailContent.put("request", soapRequest);
				mailContent.put("response", soapResponse);
				mailContent.put("responseMessage", responsemessage);
				mailContent.put("currentPagePath", referrer);
				mailContent.put("siteDomain", domain);
				sendEmailService.sendEmail(mailContent);
				RequestDispatcher requestDispatcher;
				if(portalName.equals("oh")){
					requestDispatcher=request.getRequestDispatcher("/content/onlyong/errors/500.html");
				}else{
					requestDispatcher=request.getRequestDispatcher("/content/gre/errors/500.html");
				}
				requestDispatcher.forward(request, response);
			}
			logger.info("time taken to get the response from prime: "+String.valueOf(differenceTime));
			obj.put("LDCList", ldcListAray);
		}  catch (MalformedURLException e) {
			handelCatchBlock(e,mailContent);
		}	catch (JSONException e) {
			handelCatchBlock(e,mailContent);
		} catch (Exception e){
			handelCatchBlock(e,mailContent);
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);
		logger.info("<-- getLDCInfoServlet doGet <--");

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
