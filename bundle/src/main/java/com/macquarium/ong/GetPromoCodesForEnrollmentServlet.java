package com.macquarium.ong;

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
import org.tempuri.quoteservice.GetPromoCodesForEnrollmentRequest;
import org.tempuri.quoteservice.GetPromoCodesForEnrollmentResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primesw.webservices.GetPromoCodesForEnrollment;
import com.primesw.webservices.GetPromoCodesForEnrollmentResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;

@SlingServlet(paths="/bin/getPromocodesForEnrollment", methods = "GET", metatype=false)
public class GetPromoCodesForEnrollmentServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet{


	private Logger logger = LoggerFactory.getLogger(GetPromoCodesForEnrollmentServlet.class);
	private static final long serialVersionUID = 1L;

	@Reference
	private CommonConfigService commonConfigService;

	@Reference
	private SendEmailService sendEmailService;

	@Reference
	private RequestResponseDaoService requestResponseDaoService;

	private HashMap<String,String> mailContent=new HashMap<String,String>(8);


	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		logger.info("--> GetPromoCodesForEnrollment doGet -->");
		JSONObject obj=new JSONObject();
		URL url=null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			String endPointUrl=	commonConfigService.getPrimeEndPoint();
			logger.info("Prime End PointUrl :"+endPointUrl);
			url = new URL(endPointUrl);
			
			String referrer = request.getHeader("referer");
			String domain=request.getServerName();
			String LDC=request.getParameter("LDC");
			String portalName=request.getParameter("portalName");
			
			long startTime = System.currentTimeMillis();
			logger.info("Start Time :"+startTime);
			
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeEndPoint());
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			
			GetPromoCodesForEnrollment parameters=new GetPromoCodesForEnrollment();
			
			GetPromoCodesForEnrollmentRequest getPromoCodesForEnrollmentRequest=new GetPromoCodesForEnrollmentRequest();
			getPromoCodesForEnrollmentRequest.setLDCCode(LDC);
			getPromoCodesForEnrollmentRequest.setAuthorizationCode("internal");
			getPromoCodesForEnrollmentRequest.setAuthorizationLevel("3");
			if(portalName.equals("oh")){
				getPromoCodesForEnrollmentRequest.setEnrolledByUserId("Web Enroll-ONG");
			}else if(portalName.equals("gre")){
				getPromoCodesForEnrollmentRequest.setEnrolledByUserId("Web Enroll-GRE");
			}
			
			parameters.setGetPromoCodesForEnrollmentRequest(getPromoCodesForEnrollmentRequest);
			GetPromoCodesForEnrollmentResponse getPromoCodesForEnrollmentResponse=quoteServiceSoap.getPromoCodesForEnrollment(parameters);
			GetPromoCodesForEnrollmentResult getPromoCodesForEnrollmentResult= getPromoCodesForEnrollmentResponse.getGetPromoCodesForEnrollmentResult();			
			String jsonString = mapper.writeValueAsString(getPromoCodesForEnrollmentResult);
			
			long endTime = System.currentTimeMillis();
			logger.info("End Time :"+endTime);
			long differenceTime=endTime-startTime;
			logger.info("Time taken to get the response from prime:"+String.valueOf(differenceTime));
			
			obj.put("GetPromoCodesForEnrollmentResult", jsonString);
			obj.put("status", getPromoCodesForEnrollmentResult.getResponseStatus());
			
		}catch (MalformedURLException e) {
			handelCatchBlock(e,mailContent);
		}catch (JSONException e) {
			handelCatchBlock(e,mailContent);
		}catch (Exception e) {
			handelCatchBlock(e,mailContent);
		}
		String jsonData = obj.toString();
		logger.info("Json Response");
		logger.info(jsonData);
		logger.info("<-- GetPromoCodesForEnrollment doGet <--");
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
