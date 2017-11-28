package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.macquarium.ong.vo.Customer;

@SlingServlet(paths="/bin/moving", methods = "get", metatype=true)
public class MovingServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet{

	private Logger logger = LoggerFactory.getLogger(MovingServlet.class);

	private static final long serialVersionUID = 1L;

	@Reference
	private CommonConfigService commonConfigService;

	@Reference
	private SignUpDaoService signUpDaoService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		process(request, response);
	}
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		process(request,response);
	}
	private void process(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		logger.info("--> MovingServlet doProcess -->");
		JSONObject obj=new JSONObject();
		Connection connection = null;
		String exceptionMessage=null;
		String resultCode=null;
		String resultMessage=null;

		StringBuilder sb = new StringBuilder();
		BufferedReader br = request.getReader();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		JSONObject jObj = null;
		boolean result=false;

		try {
			jObj = new JSONObject(sb.toString());
			Calendar onemonthcalendar = Calendar.getInstance();
			onemonthcalendar.add(Calendar.MONTH, -1);
			Calendar threemonthcalendar = Calendar.getInstance();
			threemonthcalendar.add(Calendar.MONTH, -3);
			java.sql.Date movingOneMonthDate = new java.sql.Date(onemonthcalendar.getTime().getTime());
			java.sql.Date movingThreeMonthDate = new java.sql.Date(threemonthcalendar.getTime().getTime());
			String moving=getParameterInfo(jObj,"fromsignup");
			Customer customer=new Customer();
			customer.setType( getParameterInfo(jObj,"partner"));
			customer.setFirstName(getParameterInfo(jObj,"firstname"));
			customer.setLastName( getParameterInfo(jObj,"lastname"));
			customer.setEmail(getParameterInfo(jObj,"email"));
			if(!moving.equals("true")){
				customer.setSignupType("MOVING");
			}else{
				customer.setSignupType("SIGNUP");
			}
			customer.setPhoneNumber(getParameterInfo(jObj,"phone"));
			customer.setContactViaPhone(getParameterInfo(jObj,"contactpermission"));
			customer.setSource(getParameterInfo(jObj,"hearaboutus"));

			String expectedmovedate=getParameterInfo(jObj,"expectedmovedate");
			if(expectedmovedate.equals("Less than a month") || expectedmovedate.equals("1-3 months")){
				customer.setMovingDate(movingOneMonthDate);
			}else{
				customer.setMovingDate(movingThreeMonthDate);
			}
			customer.setAddress1(getParameterInfo(jObj,"addressone"));
			customer.setAddress2(getParameterInfo(jObj,"addresstwo"));
			customer.setCity(getParameterInfo(jObj,"addresscity"));
			customer.setState(getParameterInfo(jObj,"addressstate"));
			customer.setZip(getParameterInfo(jObj,"addresszip"));
			customer.setSpecialOffersOption(getParameterInfo(jObj,"sendemails"));

			boolean customerExisted=signUpDaoService.isExistingCustomer(customer);
			if(customerExisted){
				logger.info("already registered");
				result=signUpDaoService.updateCustomer(customer);
			}else{
				logger.info("already not registered");
				result = signUpDaoService.insertCustomer(customer);
			}
			obj.put("result", result);
			resultCode="0";
			resultMessage="success";

		}catch (JSONException e) {
			resultCode="1";
			resultMessage=e.getMessage();
		}finally{
			try {
				if(null !=connection)
					connection.close();
			} catch (SQLException e) {
				resultMessage=e.getMessage();
			}
		}
		try {
			obj.put("resultCode", resultCode);
			obj.put("resultMessage", resultMessage);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);
		logger.info("<-- MovingServlet doProcess <--");
	}
	String getParameterInfo(JSONObject JObject, String parameter){
		String result="";
		try{
			result=JObject.getString(parameter);
		}catch (Exception e){
			System.out.println("got error"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

}
