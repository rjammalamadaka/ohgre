package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpSession;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;


@SlingServlet(paths="/bin/setProductData", methods = "POST", metatype=true)
public class SetProductDataServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private static final long serialVersionUID = 2598426539166789515L;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj = new JSONObject();

		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		JSONObject jObj = null;
		try {
			jObj = new JSONObject(sb.toString());
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(20*60);
			//session.setMaxInactiveInterval(30);
			System.out.println("in set product data");
			String productDesc =getParameterInfo(jObj,"ProductDescription");
			String productDescFriendly =getParameterInfo(jObj,"ProductDescriptionFriendly");
			String quoteDes = getParameterInfo(jObj,"QuoteDescription");//jObj.getString("QuoteDescription");
			String productCode=getParameterInfo(jObj,"ProductCode");//jObj.getString("ProductCode");
			String fixedPricePerTherm=getParameterInfo(jObj,"FixedPricePerTherm");//jObj.getString("FixedPricePerTherm");
			String priceChangeFrequency=getParameterInfo(jObj,"PriceChangeFrequency");//jObj.getString("FixedPricePerTherm");
			String customerTypeCode=getParameterInfo(jObj,"CustomerTypeCode");//jObj.getString("CustomerTypeCode");
			String rateClassCode=getParameterInfo(jObj,"RateClassCode");//jObj.getString("RateClassCode");
			String LDC=getParameterInfo(jObj,"LDC");//jObj.getString("LDC");
			String ldcDesc=getParameterInfo(jObj,"LdcDesc");//jObj.getString("LdcDesc");
			String accountNumber=getParameterInfo(jObj,"AccountNumber");//jObj.getString("AccountNumber");
			String referralcode=getParameterInfo(jObj,"referralcode");
			String dukNumber=getParameterInfo(jObj,"dukNumber");
			String isDefaultPromoCode=getParameterInfo(jObj,"isDefaultPromoCode");

			System.out.println("productDesc:" +productDesc);
			session.setAttribute("ProductDescription", productDesc);
			session.setAttribute("ProductDescriptionFriendly", productDescFriendly);
			session.setAttribute("QuoteDescription", quoteDes);
			session.setAttribute("ProductCode", productCode);
			session.setAttribute("LDC",LDC);
			session.setAttribute("FixedPricePerTherm",fixedPricePerTherm);
			session.setAttribute("PriceChangeFrequency", priceChangeFrequency);
			session.setAttribute("LdcDesc",ldcDesc);
			session.setAttribute("CustomerTypeCode",customerTypeCode);
			session.setAttribute("RateClassCode",rateClassCode);
			session.setAttribute("AccountNumber",accountNumber);
			session.setAttribute("referralcode",referralcode);
			session.setAttribute("dukNumber",dukNumber);
			session.setAttribute("isDefaultPromoCode",isDefaultPromoCode);


			JSONObject sessionData=new JSONObject();
			sessionData.put("prodcutDescription",productDesc);
			sessionData.put("productDescriptionFriendly",productDescFriendly);
			sessionData.put("productcode",productCode);
			sessionData.put("quoteDesc",quoteDes);
			sessionData.put("LDC",LDC);
			sessionData.put("fixedPricePerTherm",fixedPricePerTherm);
			sessionData.put("priceChangeFrequency",priceChangeFrequency);
			sessionData.put("ldcDesc",ldcDesc);
			sessionData.put("customerTypeCode",customerTypeCode);
			sessionData.put("rateClassCode",rateClassCode);
			sessionData.put("AccountNumber",accountNumber);
			sessionData.put("referralcode",referralcode);
			sessionData.put("dukNumber",dukNumber);
			sessionData.put("isDefaultPromoCode",isDefaultPromoCode);
			obj.put("sessionData",sessionData);
			obj.put("resultCode", "0");
			obj.put("resultMessage", "success");
			System.out.println("end");

		} catch (JSONException e) {
			System.out.println("error in set product data");
			try {
				obj.put("resultCode", "0");
				obj.put("resultMessage", "success");
			} catch (Exception e1) {
				e.printStackTrace();

			}
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);

	}
	String getParameterInfo(JSONObject JObject, String parameter){
		String result="";
		try{
			result=JObject.getString(parameter);
		}catch(Exception e){
			e.printStackTrace();

		}
		return result;
	}

}