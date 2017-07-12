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
			 String productDesc= (String)session.getAttribute("ProductDescription");
			 String quoteDes=(String)session.getAttribute("QuoteDescription");
			 String productCode=(String)session.getAttribute("ProductCode");
			 String LDC=(String)session.getAttribute("LDC");
			 obj.put("productDesc", productDesc);
			 obj.put("quoteDes", quoteDes);
			 obj.put("productCode",productCode);
			 obj.put("LDC",LDC);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String jsonData = obj.toString();
         response.getWriter().write(jsonData);
	 
	 }
	 
}
