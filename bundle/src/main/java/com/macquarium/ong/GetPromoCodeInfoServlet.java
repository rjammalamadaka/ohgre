package com.macquarium.ong;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primesw.webservices.GetPromoCodeInfo;
import com.primesw.webservices.GetPromoCodeInfoResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.GetPromoCodeInfoRequest;
import org.tempuri.quoteservice.GetPromoCodeInfoResult;
import org.tempuri.quoteservice.GetPromoCodeInfoResult.LDC;
import org.tempuri.quoteservice.GetPromoCodeInfoResult.LDC.Promotion;

import java.io.IOException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SlingServlet(paths="/bin/getPromoCodeInfo", methods = "GET", metatype=true)
public class GetPromoCodeInfoServlet  extends org.apache.sling.api.servlets.SlingAllMethodsServlet{

	private Logger logger = LoggerFactory.getLogger(GetPromoCodeInfoServlet.class);

	private static final long serialVersionUID = 1L;

	@Reference
	private CommonConfigService commonConfigService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		doProcess(request,response);
	}

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		doProcess(request,response);
		logger.info("--> GetPromoCodeIndfoServlet doGet -->");
	}

	private void  doProcess(SlingHttpServletRequest request, SlingHttpServletResponse response){
		JSONObject obj=new JSONObject();

		URL url=null;
		long startTime = System.currentTimeMillis();
		ObjectMapper mapper = new ObjectMapper();
		try {

			String promotionCode=request.getParameter("promotionCode");
			String portalName=request.getParameter("portalName");

			String endPointUrl=commonConfigService.getPrimeEndPoint();
			logger.info("endPointUrl :"+endPointUrl);
			url = new URL(endPointUrl);
			logger.info("Start Time :"+startTime);
			QuoteService quoteService=new QuoteService(url);
			HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeHeaderHandlerUrl());
			quoteService.setHandlerResolver(handlerResolver);
			QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();


			GetPromoCodeInfo getPromoCodeInfo =new GetPromoCodeInfo();
			GetPromoCodeInfoRequest getPromoCodeInfoRequest=new GetPromoCodeInfoRequest();
			getPromoCodeInfoRequest.setPromotionCode(promotionCode);

			getPromoCodeInfoRequest.setIncludeExpiredWithActiveBackUpInd("Y");
			if(portalName.equals("oh")){
				getPromoCodeInfoRequest.setStateCode("OH");
			}else if(portalName.equals("gre")){
				getPromoCodeInfoRequest.setStateCode("MI");
			}
			getPromoCodeInfoRequest.setRateClass("");
			getPromoCodeInfoRequest.setSourceOfSale("");
			getPromoCodeInfoRequest.setCustomerTypeCode("");
			getPromoCodeInfo.setGetPromoCodeInfoRequest(getPromoCodeInfoRequest);

			GetPromoCodeInfoResponse getPromoCodeInfoResponse=quoteServiceSoap.getPromoCodeInfo(getPromoCodeInfo);

			GetPromoCodeInfoResult getPromoCodeInfoResult=  getPromoCodeInfoResponse.getGetPromoCodeInfoResult();

			String soapRequest=handlerResolver.getRequest();
			String soapResponse=handlerResolver.getResponse();
			System.out.println("request");
			System.out.println(soapRequest);
			System.out.println("response");
			System.out.println(soapResponse);
			String responsemessage=getPromoCodeInfoResult.getResponseMessage();
			String responseStatus=getPromoCodeInfoResult.getResponseStatus();
			obj.put("responseStatus", responseStatus);
			obj.put("responsemessage", responsemessage);

			List<LDC> ldcList=getPromoCodeInfoResult.getLDC();
			JSONArray ldcListAray=new JSONArray();
			for(LDC ldc:ldcList){
				JSONObject ldcObj=new JSONObject();
				ldcObj.put("LDCDesc", ldc.getLDCDesc());
				ldcObj.put("LDCCode", ldc.getLDCCode());
				ldcObj.put("PromoNodeCnt", ldc.getPromoNodeCnt());
				List<Promotion> listPromotion=ldc.getPromotion();
				JSONArray promotionListAray=new JSONArray();
				for(Promotion promotion:listPromotion){
					JSONObject promotionObj=new JSONObject();
					promotionObj.put("DSMAwardMiles", promotion.getDSMAwardMiles());
					promotionObj.put("DSMAwardType", promotion.getDSMAwardType());
					promotionObj.put("DSMEligible", promotion.getDSMEligible());
					promotionObj.put("GiftCardEligible", promotion.getGiftCardEligible());
					promotionObj.put("GiftCardValue", promotion.getGiftCardValue());
					promotionObj.put("PromotionCode", promotion.getPromotionCode());
					promotionObj.put("PromotionDesc", promotion.getPromotionDesc());
					promotionObj.put("PromotionExpiratonDate", promotion.getPromotionExpiratonDate());
					promotionObj.put("PromotionExpired", promotion.getPromotionExpired());
					promotionObj.put("RAFAdvertising", promotion.getRAFAdvertising());
					promotionObj.put("RAFEligible", promotion.getRAFEligible());
					promotionObj.put("BackupPromotionCode",promotion.getBackupPromotionCode());
					promotionObj.put("RateClassCode",promotion.getRateClassCode());
					promotionObj.put("CustomerTypeCode",promotion.getCustomerTypeCode());
					promotionObj.put("SourceOfSaleCode",promotion.getSourceOfSaleCode());
					promotionListAray.put(promotionObj);
				}
				ldcObj.put("promotion",promotionListAray);
				ldcListAray.put(ldcObj);
			}
			long endTime = System.currentTimeMillis();
			long differenceTime=endTime-startTime;
			logger.info("time taken to get the response from prime: "+String.valueOf(differenceTime));

			obj.put("LDCList", ldcListAray);

			String jsonData = obj.toString();
			response.getWriter().write(jsonData);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e){
			System.out.println("got error"+e.getMessage());
			e.printStackTrace();
		}

	}
}
