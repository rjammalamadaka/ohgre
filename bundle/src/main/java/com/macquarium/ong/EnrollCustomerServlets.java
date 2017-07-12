package com.macquarium.ong;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.Map;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestParameter;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.EnrollCustomerResult;
import org.tempuri.quoteservice.EnrollRequest;

import com.primesw.webservices.EnrollCustomer;
import com.primesw.webservices.EnrollCustomerResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;

import javax.servlet.http.HttpSession;


@SlingServlet(paths="/bin/enrollCustomer", methods = "POST", metatype=true)
public class EnrollCustomerServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
	
	private static final long serialVersionUID = 2598426539166789515L;
	@Reference
	private CommonConfigService commonConfigService;

	 @Override
     protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		 JSONObject obj=new JSONObject();
		 URL url=null;
		 EnrollCustomerResult enrollCustomerResult=null;
			try {
				String endPointUrl=	commonConfigService.getPrimeEndPoint();
				System.out.println("endPointUrl :"+endPointUrl);
				url = new URL(endPointUrl);
				
			long startTime = System.currentTimeMillis();
			//	Request{{"accountNumber":"12345"}=[Lorg.apache.sling.api.request.RequestParameter;@2ca384bf}

			System.out.println("accountFirstName" + request.getParameter("accountNumber"));
				HttpSession session=request.getSession();
				Map requestMap = request.getRequestParameterMap();
				System.out.println("Request FirstName:" + request.getRequestParameterMap().keySet());
				System.out.println("Request FirstName:" + requestMap);
				System.out.println("Request FirstName String:" + requestMap.get("accountNumber"));
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver();
			quoteService.setHandlerResolver(handlerResolver);		
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			
			EnrollCustomer enrollCustomer=new EnrollCustomer();
		       EnrollRequest enrollRequest= new EnrollRequest();
	            //enrollRequest.setLDC(request.getParameter(""));
				System.out.println("Getting session data");
				String productCode=(String)	session.getAttribute("ProductCode");
				String ldc=(String)session.getAttribute("LDC");
				System.out.println("productCode:"+productCode);
				System.out.println("LDC"+ldc);
				enrollRequest.setLDC(ldc);
				enrollRequest.setAccount(request.getParameter("accountNumber"));
				enrollRequest.setFirstName(request.getParameter("accountNameFirst"));
				enrollRequest.setLastName(request.getParameter("accountNameLast"));
				//enrollRequest.setProductCode(request.getParameter("productCode"));
	            enrollRequest.setRAFCode(request.getParameter("raf"));
	            enrollRequest.setMailAddress1(request.getParameter("billingAddress1"));
	            enrollRequest.setMailAddress2(request.getParameter("billingAddress2"));
	            enrollRequest.setMailCity(request.getParameter("billingCity"));
	            enrollRequest.setEnrolledByUserId("Web Enroll-ONG");
	            enrollRequest.setAuthorizationCode("internal");
	            enrollRequest.setAuthorizationLevel("3");
	            enrollRequest.setMailStateCode(request.getParameter("billingState"));
	            enrollRequest.setMailZipCode(request.getParameter("billingZip"));
	            enrollRequest.setServiceAddress1(request.getParameter("serviceAddress1"));
	             enrollRequest.setServiceAddress2(request.getParameter("serviceAddress2"));
	            enrollRequest.setServiceCity("serviceCity");
	            enrollRequest.setServiceZipCode(request.getParameter("serviceZip"));
	            enrollRequest.setServiceStateCode(request.getParameter("serviceState"));
	            enrollRequest.setPhoneNumber(request.getParameter("accountPhone"));
	            enrollRequest.setEmailAddress(request.getParameter("accountEmail"));
	            enrollRequest.setDoNotCallInd("Y");
	            enrollRequest.setDoNotMailInd("Y");
	            enrollRequest.setProductCode(productCode);
	            //enrollRequest.setPromoCode("");
				//enrollRequest.setProductCode(request.getParameter("productCode"));
	            enrollRequest.setChannelID("Online");
	            enrollRequest.setPromotionCode("N/A");
	            enrollRequest.setActionIfContractExists("1");


	            
	            enrollCustomer.setEnrollRequest(enrollRequest);
	            EnrollCustomerResponse enrollCustomerResponse = quoteServiceSoap.enrollCustomer(enrollCustomer);
	            enrollCustomerResult=enrollCustomerResponse.getEnrollCustomerResult();
	            obj.put("responseMessage", enrollCustomerResult.getResponseMessage());
	            obj.put("responseStatus", enrollCustomerResult.getResponseStatus());
	            obj.put("account", enrollCustomerResult.getAccount());
	            obj.put("custID", enrollCustomerResult.getCustID());
	         } catch (MalformedURLException e) {
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
	 
	 @Override
     protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		 JSONObject obj=new JSONObject();
		 String jsonData = obj.toString();
         response.getWriter().write(jsonData);
	 }

	
}
