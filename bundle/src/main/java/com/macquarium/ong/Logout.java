package com.macquarium.ong;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpSession;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;


@SlingServlet(paths="/bin/logout", methods = "GET", metatype=true)
public class Logout extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
	
	private static final long serialVersionUID = 2598426539166789515L;
    
	 @Override
     protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		 JSONObject obj=new JSONObject();
		 HttpSession session=request.getSession();
		 //session.setMaxInactiveInterval(30);
		 session.invalidate();	
		 try {
			obj.put("status", "true");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (Exception e){
			 System.out.println("got error"+e.getMessage());
			 e.printStackTrace();
		 }
		 String jsonData = obj.toString();
         response.getWriter().write(jsonData);
	 
	 }
	 
}
