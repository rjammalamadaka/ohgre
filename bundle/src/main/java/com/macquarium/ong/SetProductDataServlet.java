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
			//session.setMaxInactiveInterval(30);
			String productDesc = jObj.getString("ProductDescription");
			String quoteDes = jObj.getString("QuoteDescription");
			String productCode=jObj.getString("ProductCode");
			String LDC=jObj.getString("LDC");
			System.out.println("productDesc:" +productDesc);
			session.setAttribute("ProductDescription", productDesc);
			session.setAttribute("QuoteDescription", quoteDes);
			session.setAttribute("ProductCode", productCode);
			session.setAttribute("LDC",LDC);
			JSONObject sessionData=new JSONObject();
			sessionData.put("prodcutDescription",productDesc);
			sessionData.put("productcode",productCode);
			sessionData.put("quoteDesc",quoteDes);
			sessionData.put("LDC",LDC);
			obj.put("sessionData",sessionData);
			obj.put("resultCode", "0");
			obj.put("resultMessage", "success");

		} catch (JSONException e) {
			try {
				obj.put("resultCode", "0");
				obj.put("resultMessage", "success");
			} catch (Exception e1) {

			}
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);

	}

}