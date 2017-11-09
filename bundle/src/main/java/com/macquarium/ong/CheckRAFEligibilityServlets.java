package com.macquarium.ong;

import com.primesw.webservices.CheckRAFEligibility;
import com.primesw.webservices.CheckRAFEligibilityResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.CheckRAFEligibilityRequest;
import org.tempuri.quoteservice.CheckRAFEligibilityResult;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;


@SlingServlet(paths="/bin/checkRafEligibility", methods = "GET", metatype=true)
public class CheckRAFEligibilityServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Reference
    private CommonConfigService commonConfigService;
	
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
		 JSONObject obj=new JSONObject();
		
		 URL url=null;
			try {
			String endPointUrl=	commonConfigService.getPrimeEndPoint();
			System.out.println("endPointUrl :"+endPointUrl);
			url = new URL(endPointUrl);
			long startTime = System.currentTimeMillis();
			String rafCode=request.getParameter("rafCode");
			String account=request.getParameter("account");
			String ldc=request.getParameter("ldc");
			
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver();
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
			CheckRAFEligibilityResponse checkRAFEligibilityResponse= quoteServiceSoap.checkRAFEligibility(checkRAFEligibility);
			CheckRAFEligibilityResult checkRAFEligibilityResult=checkRAFEligibilityResponse.getCheckRAFEligibilityResult();
			String responseStatus=checkRAFEligibilityResult.getResponseStatus();
			String responsemessage=checkRAFEligibilityResult.getResponseMessage();
			obj.put("responseStatus", responseStatus);
			obj.put("responsemessage", responsemessage);
			JSONObject rafInfo=new JSONObject();				
			rafInfo.put("AwardEligible", checkRAFEligibilityResult.getRAFAwardEligible());
			rafInfo.put("AwardIneligibleReason", checkRAFEligibilityResult.getRAFAwardIneligibleReason());	
			obj.put("rafInfo", rafInfo);
			long endTime = System.currentTimeMillis();
			long differenceTime=endTime-startTime;
			System.out.println("time taken to get the response from prime: "+String.valueOf(differenceTime));
			
		}  catch (MalformedURLException e) {
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
	 
	

	
}
