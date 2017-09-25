package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

@SlingServlet(paths="/bin/moving", methods = "get", metatype=true)
public class MovingServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet{
	private static final long serialVersionUID = 1L;
	@Reference
	private CommonConfigService commonConfigService;

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		process(request, response);
	}
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		process(request,response);
	}

	private void process(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
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

		try {
			jObj = new JSONObject(sb.toString());
			Class.forName("com.mysql.jdbc.Driver");
			Calendar currentCalendar = Calendar.getInstance();
			Calendar onemonthcalendar = Calendar.getInstance();
			onemonthcalendar.add(Calendar.MONTH, -1);
			Calendar threemonthcalendar = Calendar.getInstance();
			threemonthcalendar.add(Calendar.MONTH, -3);

			java.sql.Date todayDate = new java.sql.Date(currentCalendar.getTime().getTime());
			java.sql.Date movingOneMonthDate = new java.sql.Date(onemonthcalendar.getTime().getTime());
			java.sql.Date movingThreeMonthDate = new java.sql.Date(threemonthcalendar.getTime().getTime());


			connection = DriverManager.getConnection(commonConfigService.getMySqlConnectionUrl(),commonConfigService.getDataBaseUsername(), commonConfigService.getDataBasePassword());
			if (connection != null) {
				obj.put("got connection","You made it, take control your database now!");
				String query="insert into signup(type,created,first_name,last_name,email,phone_number,contact_via_phone,source,moving_date,address1,address2,city,state,zip,special_offers_optin)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStmt = connection.prepareStatement(query);
				preparedStmt.setString(1, "");
				preparedStmt.setDate(2, todayDate);
				preparedStmt.setString(3, getParameterInfo(jObj,"firstname"));
				preparedStmt.setString(4, getParameterInfo(jObj,"lastname"));
				preparedStmt.setString(5, getParameterInfo(jObj,"email"));
				preparedStmt.setString(6, getParameterInfo(jObj,"phone"));

				String contactpermission=getParameterInfo(jObj,"contactpermission");
				if(contactpermission.equalsIgnoreCase("yes")){
					preparedStmt.setBoolean(7, true);
				}else{
					preparedStmt.setBoolean(7, false);
				}

				preparedStmt.setString(8, getParameterInfo(jObj,"hearaboutus"));

				String expectedmovedate=getParameterInfo(jObj,"expectedmovedate");
				if(expectedmovedate.equals("Less than a month") || expectedmovedate.equals("1-3 months")){
					preparedStmt.setDate(9, movingOneMonthDate);
				}else{
					preparedStmt.setDate(9, movingThreeMonthDate);
				}

				preparedStmt.setString(10, getParameterInfo(jObj,"addressone"));
				preparedStmt.setString(11, getParameterInfo(jObj,"addresstwo"));
				preparedStmt.setString(12,  getParameterInfo(jObj,"addresscity"));
				preparedStmt.setString(13, getParameterInfo(jObj,"addressstate"));
				preparedStmt.setString(14, getParameterInfo(jObj,"addresszip"));
				String sendemails=getParameterInfo(jObj,"sendemails");
				if(sendemails.equals("true")){
					preparedStmt.setBoolean(15,true) ;
				}else{
					preparedStmt.setBoolean(15,false );
				}

				boolean b=preparedStmt.execute();
				resultCode="0";
				resultMessage="success";
			} else {
				resultCode="1";
				resultMessage="error";
			}
		}catch(ClassNotFoundException e){
			resultCode="1";
			resultMessage=e.getMessage();
		}catch (JSONException e) {
			resultCode="1";
			resultMessage=e.getMessage();
		}catch (SQLException e) {
			resultCode="1";
			resultMessage=e.getMessage();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				resultMessage=e.getMessage();
			}
		}

		try {
			obj.put("resultCode", resultCode);
			obj.put("resultMessage", resultMessage);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String jsonData = obj.toString();
		response.getWriter().write(jsonData);
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
