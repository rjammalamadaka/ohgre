package com.macquarium.ong.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.macquarium.ong.EnrollCustomerServlets;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.macquarium.ong.CommonConfigService;
import com.macquarium.ong.RequestResponseDaoService;
import com.macquarium.ong.vo.RequestResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Component(metatype = false)
public class RequestResponseDaoServiceImpl implements RequestResponseDaoService{

	private Logger logger = LoggerFactory.getLogger(RequestResponseDaoServiceImpl.class);
	@Reference
	private CommonConfigService commonConfigService;

	public boolean insertPrimeRequestResponse(RequestResponseVo requestResponseVo) {
		boolean result=false;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(commonConfigService.getMySqlConnectionUrl(),commonConfigService.getDataBaseUsername(), commonConfigService.getDataBasePassword());
			if (connection != null) {
				logger.info("got connection object");
				String query="insert into prime_request_response (returnXML,respMessage, respNumb, accnt, datestamp, postXML, apicall, page, site, ldc, orderNumber) values(?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, requestResponseVo.getReturnXML());
				ps.setString(2, requestResponseVo.getRespMessage());
				ps.setString(3, requestResponseVo.getRespNumb());
				ps.setString(4, requestResponseVo.getAccnt());
				Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
				ps.setTimestamp(5, currentTimestamp);				
				ps.setString(6,requestResponseVo.getPostXML());
				ps.setString(7, requestResponseVo.getApiCall());
				ps.setString(8, requestResponseVo.getPage());
				ps.setString(9, requestResponseVo.getSite());
				ps.setString(10, requestResponseVo.getLdc());
				ps.setString(11, requestResponseVo.getOrderNumber());
				result=ps.execute();
				logger.info("after execute");
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
