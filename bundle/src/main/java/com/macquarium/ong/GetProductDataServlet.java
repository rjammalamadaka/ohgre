package com.macquarium.ong;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.ServerException;


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
			String fixedPricePerTherm=(String)session.getAttribute("FixedPricePerTherm");
			String LDC=(String)session.getAttribute("LDC");
			String ldcDesc=(String)session.getAttribute("LdcDesc");
			obj.put("productDesc", productDesc);
			obj.put("quoteDes", quoteDes);
			obj.put("productCode",productCode);
			obj.put("LDC",LDC);
			obj.put("fixedPricePerTherm", fixedPricePerTherm);
			obj.put("ldcDesc", ldcDesc);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);

	}

}
