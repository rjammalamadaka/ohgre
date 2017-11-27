package com.macquarium.ong;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
import org.tempuri.quoteservice.GetQuotesResult;
import org.tempuri.quoteservice.GetQuotesResult.Customer;
import org.tempuri.quoteservice.GetQuotesResult.Customer.Product;
import org.tempuri.quoteservice.QuoteRequest;

import com.macquarium.ong.vo.RequestResponseVo;
import com.primesw.webservices.GetQuotes;
import com.primesw.webservices.GetQuotesResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;


@SlingServlet(paths="/bin/getQuotes", methods = "GET", metatype=true)
public class GetQuotesServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private Logger logger = LoggerFactory.getLogger(GetQuotesServlets.class);
	private static final long serialVersionUID = 1L;

	@Reference
	private CommonConfigService commonConfigService;

	@Reference
	private SendEmailService sendEmailService;

	@Reference
	private RequestResponseDaoService requestResponseDaoService;

	private HashMap<String,String> mailContent=new HashMap<String,String>();

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
		logger.info("--> GetQuotesServlets doGet -->");
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

			String promotionCode=request.getParameter("promotionCode");
			String portalName=request.getParameter("portalName");
			String ldcCode=request.getParameter("ldcCode");
			String locationType=request.getParameter("locationType");
			String rateClassCode=request.getParameter("rateClassCode");
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeHeaderHandlerUrl());
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
			GetQuotes parameters=new GetQuotes();
			QuoteRequest quoteRequest=new QuoteRequest();
			if(ldcCode !=null)
				quoteRequest.setLDC(ldcCode);
			quoteRequest.setPrimaryProduct("ALL");
			if(null !=rateClassCode){
				quoteRequest.setRateClass(rateClassCode);
			}
			if(portalName.equals("oh")){
				quoteRequest.setEnrolledByUserId("Web Enroll-ONG");
			}else if(portalName.equals("gre")){
				quoteRequest.setEnrolledByUserId("Web Enroll-GRE");
			}
			if(locationType !=null){
				if(locationType.equals("commercial")){
					quoteRequest.setRateClass("04");
				}else{
					quoteRequest.setRateClass("01");
				}
			}
			quoteRequest.setAllowedToSellWebInd("Y");
			quoteRequest.setAuthorizationCode("internal");
			quoteRequest.setAuthorizationLevel("3");
			if(null !=promotionCode){
				quoteRequest.setPromotionCode(promotionCode);
			}
			logger.info("PRIME getQuotes");
			parameters.setQuoteRequest(quoteRequest);
			GetQuotesResponse getQuotesResponse =quoteServiceSoap.getQuotes(parameters);
			GetQuotesResult getQuotesResult=getQuotesResponse.getGetQuotesResult();
			String soapRequest=handlerResolver.getRequest();
			String soapResponse=handlerResolver.getResponse();
			logger.info("SOAP REQUEST");
			logger.info(soapRequest);
			logger.info("SOAP RESPONSE");
			logger.info(soapResponse);
			String responseStatus=getQuotesResult.getResponseStatus();
			String responsemessage=getQuotesResult.getResponseMessage();
			obj.put("responseStatus", responseStatus);
			obj.put("responsemessage", responsemessage);

			RequestResponseVo requestResponseVo=new RequestResponseVo();
			requestResponseVo.setAccnt("");
			requestResponseVo.setApiCall("GetQuotes");
			requestResponseVo.setLdc(ldcCode);
			requestResponseVo.setOrderNumber("0");
			requestResponseVo.setPage(referrer);
			requestResponseVo.setPostXML(soapRequest);
			requestResponseVo.setRespMessage(responsemessage);
			requestResponseVo.setRespNumb(responseStatus);
			requestResponseVo.setReturnXML(soapResponse);
			requestResponseVo.setSite(domain);

			requestResponseDaoService.insertPrimeRequestResponse(requestResponseVo);

			List<Customer> customerList=getQuotesResult.getCustomer();
			JSONArray customerArray=new JSONArray();
			for(Customer customer:customerList){
				JSONObject customerObj=new JSONObject();
				customerObj.put("LDCDesc", customer.getLDCDesc());
				customerObj.put("LDC", customer.getLDC());
				List<Product> productList =customer.getProduct();
				JSONArray productArray=new JSONArray();
				for(Product product:productList){
					JSONObject productObj=new JSONObject();
					String productDesc=product.getProductCode();
					productObj.put("CanQuoteInd",product.getCanQuoteInd());
					productObj.put("ComboFixedPricePct",product.getComboFixedPricePct());
					productObj.put("ComboProductAllocTypeCd",product.getComboProductAllocTypeCd());
					productObj.put("ContractPrice",product.getContractPrice());
					productObj.put("CtrctDurationMonths",product.getCtrctDurationMonths());
					productObj.put("CtrctTermDate",product.getCtrctTermDate());
					productObj.put("DiscChrgPerBill",product.getDiscChrgPerBill());
					productObj.put("EarlyTermChargeAmt",product.getEarlyTermChargeAmt());
					productObj.put("EstimatedFirstFlowDate",product.getEstimatedFirstFlowDate());
					productObj.put("FixedPricePerTherm",product.getFixedPricePerTherm());
					productObj.put("FixedPricePerThermCd",product.getFixedPricePerThermCd());
					productObj.put("MonthlyCapCostChrg",product.getMonthlyCapCostChrg());
					productObj.put("MonthlyCustChrg",product.getMonthlyCustChrg());
					productObj.put("PPCEarlyTermChargeAmt",product.getPPCEarlyTermChargeAmt());
					productObj.put("PriceChangeFrequency",product.getPriceChangeFrequency());
					productObj.put("ProductCode",product.getProductCode());
					productObj.put("ProductDescFriendly",product.getProductDescFriendly());
					productObj.put("ProductDescription",product.getProductDescription());
					productObj.put("ProductFinePrintText",product.getProductFinePrintText());
					productObj.put("ProductPlanDesc",product.getProductPlanDesc());
					productObj.put("QuoteDescription",product.getQuoteDescription());
					productObj.put("SFBSummerAmt",product.getSFBSummerAmt());
					productObj.put("SFBSummerCnt",product.getSFBSummerCnt());
					productObj.put("SFBWinterAmt",product.getSFBWinterAmt());
					productObj.put("SFBWinterCnt",product.getSFBWinterCnt());
					productObj.put("VarCapCostPerTherm",product.getVarCapCostPerTherm());
					productObj.put("VarCapLimit",product.getVarCapLimit());
					productObj.put("VarPriceAddOnPerTherm",product.getVarPriceAddOnPerTherm());
					productObj.put("VarPriceBasisAmt",product.getVarPriceBasisAmt());
					productObj.put("VarPriceBasisCd",product.getVarPriceBasisCd());
					productObj.put("VarPriceTotal",product.getVarPriceTotal());
					productObj.put("ProductDesc", productDesc);
					productArray.put(productObj);
				}
				customerObj.put("Product", productArray);
				customerArray.put(customerObj);
			}
			long endTime = System.currentTimeMillis();
			logger.info("End Time :"+endTime);
			long differenceTime=endTime-startTime;
			logger.info("Time taken to get the response from prime:"+String.valueOf(differenceTime));
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
				requestDispatcher.forward(request, response);			}
			obj.put("Customer", customerArray);
		}

		catch (MalformedURLException e) {
			String stackTrace=CommonUtil.stackTraceToString(e);
			logger.info("MalformedURLException :"+e.getMessage());
			logger.error(e.getMessage());
			logger.error(e.getMessage(),e);
			mailContent.put("stackTrace", stackTrace);
			sendEmailService.sendExceptionEmail(mailContent);
		}catch (JSONException e) {
			String stackTrace=CommonUtil.stackTraceToString(e);
			logger.info("JSONException :"+e.getMessage());
			logger.error(e.getMessage());
			logger.error(e.getMessage(),e);
			mailContent.put("stackTrace", stackTrace);
			sendEmailService.sendExceptionEmail(mailContent);
		}catch (Exception e) {
			String stackTrace=CommonUtil.stackTraceToString(e);
			logger.info("JSONException :"+e.getMessage());
			logger.error(e.getMessage());
			logger.error(e.getMessage(),e);
			StringWriter writer = new StringWriter();
			e.printStackTrace(new PrintWriter(writer));
			mailContent.put("stackTrace", stackTrace);
			sendEmailService.sendExceptionEmail(mailContent);
		}
		String jsonData = obj.toString();
		logger.info("Json Response");
		logger.info(jsonData);
		logger.info("<-- GetQuotesServlets doGet <--");
		response.getWriter().write(jsonData);
	}

}
