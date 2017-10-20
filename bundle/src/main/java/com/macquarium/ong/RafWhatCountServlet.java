package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.rmi.ServerException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

@SlingServlet(paths="/bin/whatCount", methods = "POST", metatype=true)
public class RafWhatCountServlet extends SlingAllMethodsServlet {
	
	private static final long serialVersionUID = 2598426539166789515L;
	@Reference
	private CommonConfigService commonConfigService;

	 @Override
     protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		 JSONObject obj=new JSONObject();
		 System.out.println("doPost");
		 StringBuilder sb = new StringBuilder();
			BufferedReader br = request.getReader();
			String str = null;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			JSONObject jObj = null;			
		
		 System.out.println("mapper create");
		 ObjectMapper mapper = new ObjectMapper();
		 String result="{}";
			try {
				System.out.println(sb);
				jObj = new JSONObject(sb.toString());
				//String endPointUrl="https://www.wc-host.com/southstar/php/?c=subandsend&list_id=2&template_id=3&campaign_name=ONG+RAF+Triggered+Email&format=2";	//commonConfigService.getWorldCountUrl();
				 String endPointUrl = commonConfigService.getWhatCountsUrl(); //"http://dev-gngraf.macquarium.com/refer/api.php?f=ONGRAFSendEmail";
				 		/*"&from=jammrav@gmail.com&sender=jammrav@gmail.com&" +
		            		"emails=avinashdv07@gmail.com&body=Hello%20this%20is%20for%20testing%20RAF&first=ravi&last=j&referral=456789";*/
				 
		           				StringBuffer wcUrl = new StringBuffer (endPointUrl);
		           			//	String toMailId="jammrav@gmail.com";	
				String toMailId=getParameterInfo(jObj,"tomailId");
				String firstName=getParameterInfo(jObj,"firstName");
				String lastName=getParameterInfo(jObj,"lastName");
				String emailAddress=getParameterInfo(jObj,"emailAddress");	
				String rafBody=getParameterInfo(jObj,"rafBody");	
				String custID=getParameterInfo(jObj,"custID");
				wcUrl=wcUrl.append("&from=");
				wcUrl=wcUrl.append(toMailId);
				wcUrl=wcUrl.append("&sender=");
				wcUrl=wcUrl.append(toMailId);
				wcUrl=wcUrl.append("$emails=");
				wcUrl=wcUrl.append(emailAddress);
				wcUrl=wcUrl.append("&body=");
				//wcUrl=wcUrl.append("Hello%20this%20is%20for%20testing%20RAF");
				 String encodedString = URLEncoder.encode(rafBody, "UTF-8");
				wcUrl=wcUrl.append(encodedString);
				wcUrl=wcUrl.append("&first=");
				wcUrl=wcUrl.append(firstName);
				wcUrl=wcUrl.append("&last=");
				wcUrl=wcUrl.append(lastName);
				wcUrl=wcUrl.append("&referral=");
				wcUrl=wcUrl.append(custID);
				String url=wcUrl.toString();
				//url=URLEncoder.encode( url, "UTF-8" ); 
				// String url = "http://dev-gngraf.macquarium.com/refer/api.php?f=ONGRAFSendEmail&from=jammrav@gmail.com&sender=jammrav@gmail.com&emails=avinashdv07@gmail.com&body=Hello%20this%20is%20for%20testing%20RAF&first=ravi&last=j&referral=456789";
				System.out.println(url);   
				URL urlObj = new URL(url);
				System.out.println(url);
				HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
				      urlConnection.setDoOutput(true);
		            //urlConnection.setRequestMethod("POST");
		            urlConnection.setConnectTimeout(50000);
		            urlConnection.setReadTimeout(50000);
		            urlConnection.connect();
		            //You Can also Create JSONObject here
		            StringBuilder sb1 = new StringBuilder();

		            int HttpResult = urlConnection.getResponseCode();
		            System.out.println("code:"+HttpResult);
		            if (HttpResult == HttpURLConnection.HTTP_OK) {
		                BufferedReader br1 = new BufferedReader(new InputStreamReader(
		                        urlConnection.getInputStream(), "utf-8"));
		                String line = null;
		                while ((line = br1.readLine()) != null) {
		                    sb1.append(line + "\n");
		                }
		                br1.close();
		                System.out.println(sb1.toString());
		                result=sb1.toString();
		                
		            }
				

				long startTime = System.currentTimeMillis();				
			}	catch (JSONException e) {
				// TODO Auto-generated catch block
				System.out.println("got error"+e.getMessage());
				try {
					obj.put("resultCode", "1");
					obj.put("resultMessage", "systemError");
					obj.put("errorDescription", e.getMessage());
				} catch (Exception e1) {

				}
			}
			// String jsonData = obj.toString();
	         response.getWriter().write(result);
	 }
	 
	 

	    String getParameterInfo(JSONObject JObject, String parameter){
	    	String result="";
	    	try{
	    		result=JObject.getString(parameter);
	    	}catch(Exception e){
	    		
	    	}
	    	return result;
	    }


}
