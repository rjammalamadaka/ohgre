package com.macquarium.ong;

import com.primesw.webservices.GetLDCInfo;
import com.primesw.webservices.GetLDCInfoResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.GetLDCInfoRequest;
import org.tempuri.quoteservice.GetLDCInfoResult;
import org.tempuri.quoteservice.GetLDCInfoResult.LDC;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.List;


@SlingServlet(paths="/bin/getLDCInfoServlet", methods = "GET", metatype=true)
public class GetLDCInfoServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
	
		
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
			String portalName=request.getParameter("portalName");
			
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver();
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
			
			
			String responseStatus=getLDCInfoResult.getResponseStatus();
			String responsemessage=getLDCInfoResult.getResponseMessage();
			obj.put("responseStatus", responseStatus);
			obj.put("responsemessage", responsemessage);
			
			System.out.println("responseStatus :"+responseStatus);
			System.out.println("responsemessage :"+responsemessage);
			
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
			System.out.println("time taken to get the response from prime: "+String.valueOf(differenceTime));
			obj.put("LDCList", ldcListAray);
		}  catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("got error"+e.getMessage());
			e.printStackTrace();
		}	catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("got error"+e.getMessage());
			e.printStackTrace();
		}
		 String jsonData = obj.toString();
         response.getWriter().write(jsonData);
	 }
	 
	

	
}
