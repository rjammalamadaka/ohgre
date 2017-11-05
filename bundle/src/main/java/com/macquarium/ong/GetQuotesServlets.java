package com.macquarium.ong;

import com.primesw.webservices.GetQuotes;
import com.primesw.webservices.GetQuotesResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.GetQuotesResult;
import org.tempuri.quoteservice.GetQuotesResult.Customer;
import org.tempuri.quoteservice.GetQuotesResult.Customer.Product;
import org.tempuri.quoteservice.QuoteRequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.List;


@SlingServlet(paths="/bin/getQuotes", methods = "GET", metatype=true)
public class GetQuotesServlets extends org.apache.sling.api.servlets.SlingAllMethodsServlet {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Reference
	private CommonConfigService commonConfigService;

	@Reference
	private SendEmailService sendEmailService;

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
			String promotionCode=request.getParameter("promotionCode");
			String portalName=request.getParameter("portalName");
			String ldcCode=request.getParameter("ldcCode");
			String locationType=request.getParameter("locationType");
			String rateClassCode=request.getParameter("rateClassCode");

			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver();
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
			//quoteRequest.setEnrolledByUserId("Web Enroll-ONG");  // ong:  Web Enroll-ONG , gre:Web Enroll-GRE
			//quoteRequest.setRateClass("01");// 01 Res, 04 //Commer
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
			parameters.setQuoteRequest(quoteRequest);
			System.out.println(quoteRequest);

			GetQuotesResponse getQuotesResponse =quoteServiceSoap.getQuotes(parameters);
			System.out.println("Got Response");
			GetQuotesResult getQuotesResult=getQuotesResponse.getGetQuotesResult();

			String responseStatus=getQuotesResult.getResponseStatus();
			String responsemessage=getQuotesResult.getResponseMessage();
			obj.put("responseStatus", responseStatus);
			obj.put("responsemessage", responsemessage);

			System.out.println("responseStatus :"+responseStatus);
			System.out.println("responsemessage :"+responsemessage);
			List<Customer> customerList=getQuotesResult.getCustomer();


			System.out.println("retrive customerList");
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



					/*productObj.put("ComboFixedPricePct",product.getComboFixedPricePct());
					productObj.put("ContractPrice",product.getContractPrice());
					productObj.put("CtrctTermDate",product.getCtrctTermDate());
					productObj.put("FixedPricePerTherm",product.getFixedPricePerTherm());
					productObj.put("MonthlyCustChrg",product.getMonthlyCustChrg());
					productObj.put("ProductDescription",product.getProductDescription());
					productObj.put("QuoteDescription",product.getQuoteDescription());
					productObj.put("VarPriceTotal",product.getVarPriceTotal());
					productObj.put("ProductCode",product.getProductCode());
					productObj.put("ProductPlanDesc",product.getProductPlanDesc());	*/
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
					//product.getMessage();
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


					//productObj.put("FullDescription", product.getProductDescription().concat("– for new ONG residential customers only – has a guaranteed savings of at least 20% off of ONG's Variable Plan at the standard price for the first two months of service"));
					//productObj.put("AditionalDescription", product.getProductDescription().concat("– discounted for the first 2 months"));


					/***
					 Need to make it as Dynamic
					 **/
					productObj.put("ProductDesc", productDesc);
					System.out.println(productDesc);
					productArray.put(productObj);
				}
				customerObj.put("Product", productArray);
				customerArray.put(customerObj);
			}
			long endTime = System.currentTimeMillis();
			long differenceTime=endTime-startTime;
			System.out.println("time taken to get the response from prime: "+String.valueOf(differenceTime));

			obj.put("Customer", customerArray);
		}

		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("got error"+e.getMessage());
			sendEmailService.sendEmail("avinash.dhannuri@macquarium.com", e.getMessage());

			e.printStackTrace();
		}	catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("got error"+e.getMessage());
			sendEmailService.sendEmail("avinash.dhannuri@macquarium.com", e.getMessage());

			e.printStackTrace();
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);
	}




}
