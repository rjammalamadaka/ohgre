package com.macquarium.ong;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tempuri.quoteservice.CheckRAFEligibilityRequest;
import org.tempuri.quoteservice.CheckRAFEligibilityResult;

import com.macquarium.ong.vo.RequestResponseVo;
import com.primesw.webservices.CheckRAFEligibility;
import com.primesw.webservices.CheckRAFEligibilityResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;


@SlingServlet(paths="/bin/checkRafEligibility", methods = "GET", metatype=true)
public class CheckRAFEligibilityServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(CheckRAFEligibilityServlets.class);

	@Reference
	private CommonConfigService commonConfigService;

	@Reference
	private SendEmailService sendEmailService;

	@Reference
	private RequestResponseDaoService requestResponseDaoService;

	private HashMap<String,String> mailContent=new HashMap<String,String>(8);

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj=new JSONObject();
		try {
			obj.put("method", "Post");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);

	}

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		logger.info("--> CheckRAFEligibilityServlets doGet -->");
		JSONObject obj=new JSONObject();
		URL url=null;
		try {
			String endPointUrl=	commonConfigService.getPrimeEndPoint();
			logger.info("Prime End PointUrl :"+endPointUrl);
			url = new URL(endPointUrl);
			long startTime = System.currentTimeMillis();
			logger.info("Start Time :"+startTime);
			String referrer = request.getHeader("referer");
			String domain=request.getServerName();
			String rafCode=request.getParameter("rafCode");
			String account=request.getParameter("account");
			String ldc=request.getParameter("ldc");
			String portalName=request.getParameter("portalName");
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeEndPoint());
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			CheckRAFEligibilityRequest checkRAFEligibilityRequest=new CheckRAFEligibilityRequest();
			if(null !=rafCode)
				checkRAFEligibilityRequest.setRAFCode(rafCode);
			if(null !=account)
				checkRAFEligibilityRequest.setAccount(account);
			if(null !=ldc)
				checkRAFEligibilityRequest.setLDC(ldc);
			CheckRAFEligibility checkRAFEligibility=new CheckRAFEligibility();
			checkRAFEligibility.setCheckRAFEligibilityRequest(checkRAFEligibilityRequest);
			logger.info("PRIME checkRAFEligibility");
			CheckRAFEligibilityResponse checkRAFEligibilityResponse= quoteServiceSoap.checkRAFEligibility(checkRAFEligibility);
			CheckRAFEligibilityResult checkRAFEligibilityResult=checkRAFEligibilityResponse.getCheckRAFEligibilityResult();
			String soapRequest=handlerResolver.getRequest();
			String soapResponse=handlerResolver.getResponse();
			String responseStatus=checkRAFEligibilityResult.getResponseStatus();
			String responsemessage=checkRAFEligibilityResult.getResponseMessage();
			logger.info("SOAP REQUEST");
			logger.info(soapRequest);
			logger.info("SOAP RESPONSE");
			logger.info(soapResponse);
			obj.put("responseStatus", responseStatus);
			obj.put("responsemessage", responsemessage);
			RequestResponseVo requestResponseVo=new RequestResponseVo();
			requestResponseVo.setAccnt("");
			requestResponseVo.setApiCall("CheckRAFEligibility");
			requestResponseVo.setLdc(ldc);
			requestResponseVo.setOrderNumber("0");
			requestResponseVo.setPage(referrer);
			requestResponseVo.setPostXML(soapRequest);
			requestResponseVo.setRespMessage(responsemessage);
			requestResponseVo.setRespNumb(responseStatus);
			requestResponseVo.setReturnXML(soapResponse);
			requestResponseVo.setSite(domain);
			requestResponseDaoService.insertPrimeRequestResponse(requestResponseVo);

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
			JSONObject rafInfo=new JSONObject();
			rafInfo.put("AwardEligible", checkRAFEligibilityResult.getRAFAwardEligible());
			rafInfo.put("AwardIneligibleReason", checkRAFEligibilityResult.getRAFAwardIneligibleReason());
			obj.put("rafInfo", rafInfo);
			long endTime = System.currentTimeMillis();
			long differenceTime=endTime-startTime;

		}  catch (MalformedURLException e) {
			handelCatchBlock(e,mailContent);
		}	catch (JSONException e) {
			handelCatchBlock(e,mailContent);
		}   catch (Exception e){
			handelCatchBlock(e,mailContent);
		}
		String jsonData = obj.toString();
		logger.info("Json Response");
		logger.info(jsonData);
		logger.info("<-- CheckRAFEligibilityServlets doGet <--");
		response.getWriter().write(jsonData);
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
