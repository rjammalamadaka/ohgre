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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@SlingServlet(paths="/bin/whatCount", methods = "POST", metatype=true)
public class RafWhatCountServlet extends SlingAllMethodsServlet {

	private Logger logger = LoggerFactory.getLogger(RafWhatCountServlet.class);
	private static final long serialVersionUID = 2598426539166789515L;
	@Reference
	private CommonConfigService commonConfigService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		logger.info("--> RafWhatCountServlet doPost -->");
		JSONObject obj=new JSONObject();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		JSONObject jObj = null;
		ObjectMapper mapper = new ObjectMapper();
		String result="{}";
		try {
			jObj = new JSONObject(sb.toString());
			String endPointUrl = commonConfigService.getWhatCountsUrl();
			StringBuffer wcUrl = new StringBuffer (endPointUrl);
			String toMailId=getParameterInfo(jObj,"tomailId");
			String firstName=getParameterInfo(jObj,"firstName");
			String lastName=getParameterInfo(jObj,"lastName");
			String emailAddress=getParameterInfo(jObj,"emailAddress");
			String rafBody=getParameterInfo(jObj,"rafBody");
			String custID=getParameterInfo(jObj,"custID");
			String portalName=getParameterInfo(jObj, "portalName");
			wcUrl=wcUrl.append("&from=");
			wcUrl=wcUrl.append(toMailId);
			wcUrl=wcUrl.append("&sender=");
			wcUrl=wcUrl.append(toMailId);
			wcUrl=wcUrl.append("&emails=");
			String encodedEmailAddress = URLEncoder.encode(emailAddress, "UTF-8");
			wcUrl=wcUrl.append(encodedEmailAddress);
			wcUrl=wcUrl.append("&body=");
			String encodedString = URLEncoder.encode(rafBody, "UTF-8");
			wcUrl=wcUrl.append(encodedString);
			wcUrl=wcUrl.append("&first=");
			String encodedFirstName = URLEncoder.encode(firstName, "UTF-8");
			wcUrl=wcUrl.append(encodedFirstName);
			wcUrl=wcUrl.append("&last=");
			String encodedLastName = URLEncoder.encode(lastName, "UTF-8");
			wcUrl=wcUrl.append(encodedLastName);
			String portal=null;
			if(portalName.endsWith("oh")){
				portal="oh";
			}else{
				portal="gre";
			}
			wcUrl=wcUrl.append("&portal=");
			String encodedPortalName = URLEncoder.encode(portal, "UTF-8");
			wcUrl=wcUrl.append(encodedPortalName);
			wcUrl=wcUrl.append("&referral=");
			wcUrl=wcUrl.append(custID);
			String url=wcUrl.toString();
			logger.info("What Count url"+url);
			long startTime = System.currentTimeMillis();
			logger.info("Start Time :"+startTime);
			URL urlObj = new URL(url);
			HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setConnectTimeout(50000);
			urlConnection.setReadTimeout(50000);
			urlConnection.connect();
			StringBuilder sb1 = new StringBuilder();
			int HttpResult = urlConnection.getResponseCode();
			if (HttpResult == HttpURLConnection.HTTP_OK) {
				BufferedReader br1 = new BufferedReader(new InputStreamReader(
						urlConnection.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br1.readLine()) != null) {
					sb1.append(line + "\n");
				}
				br1.close();
				result=sb1.toString();
			}
			long endTime = System.currentTimeMillis();
			logger.info("End Time :"+endTime);
			long differenceTime=endTime-startTime;
			logger.info("Time taken to get the response from prime:"+String.valueOf(differenceTime));

		}	catch (JSONException e) {
			e.printStackTrace();
			try {
				obj.put("resultCode", "1");
				obj.put("resultMessage", "systemError");
				obj.put("errorDescription", e.getMessage());
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
		response.getWriter().write(result);
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
