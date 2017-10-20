package com.macquarium.ong;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpSession;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;


@SlingServlet(paths="/bin/getProductData", methods = "GET", metatype=true)
public class GetProductDataServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

	private static final long serialVersionUID = 2598426539166789515L;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj=new JSONObject();
		HttpSession session=request.getSession();
		//session.setMaxInactiveInterval(30);
		try {
			Object productDesc=session.getAttribute("ProductDescription");
			if(null !=productDesc){
				obj.put("productDesc", (String)productDesc);
			}
			Object quoteDes=session.getAttribute("QuoteDescription");
			if(null !=quoteDes){
				obj.put("quoteDes", (String)quoteDes);
			}

			Object productCode=session.getAttribute("ProductCode");
			if(null !=productCode){
				obj.put("productCode", (String)productCode);
			}

			Object fixedPricePerTherm=session.getAttribute("FixedPricePerTherm");
			if(null !=fixedPricePerTherm){
				obj.put("fixedPricePerTherm", (String)fixedPricePerTherm);
			}

			Object LDC=session.getAttribute("LDC");
			if(null !=LDC){
				obj.put("LDC", (String)LDC);
			}

			Object ldcDesc=session.getAttribute("LdcDesc");
			if(null !=ldcDesc){
				obj.put("ldcDesc", (String)ldcDesc);
			}

			Object customerTypeCode=session.getAttribute("CustomerTypeCode");
			if(null !=customerTypeCode){
				obj.put("customerTypeCode", (String)customerTypeCode);
			}

			Object rateClassCode=session.getAttribute("RateClassCode");
			if(null !=rateClassCode){
				obj.put("rateClassCode", (String)rateClassCode);
			}

			Object AccountNumber=session.getAttribute("AccountNumber");
			if(null !=AccountNumber){
				obj.put("AccountNumber", (String)AccountNumber);
			}

			// String productDesc= (String)session.getAttribute("ProductDescription");
			//String quoteDes=(String)session.getAttribute("QuoteDescription");
			// String productCode=(String)session.getAttribute("ProductCode");
			// String fixedPricePerTherm=(String)session.getAttribute("FixedPricePerTherm");
			//String LDC=(String)session.getAttribute("LDC");
			// String ldcDesc=(String)session.getAttribute("LdcDesc");
			//	String customerTypeCode=(String) session.getAttribute("CustomerTypeCode");
			//String rateClassCode=(String)session.getAttribute("RateClassCode");
			//String AccountNumber=(String) session.getAttribute("AccountNumber");
			// obj.put("productDesc", productDesc);
			// obj.put("quoteDes", quoteDes);
			// obj.put("productCode",productCode);
			//obj.put("LDC",LDC);
			// obj.put("fixedPricePerTherm", fixedPricePerTherm);
			// obj.put("ldcDesc", ldcDesc);
			//obj.put("customerTypeCode", customerTypeCode);
			//obj.put("rateClassCode", rateClassCode);
			// obj.put("AccountNumber", AccountNumber);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);

	}

}
