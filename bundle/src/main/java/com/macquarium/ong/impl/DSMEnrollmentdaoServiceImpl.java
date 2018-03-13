package com.macquarium.ong.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.macquarium.ong.CommonConfigService;
import com.macquarium.ong.DSMEnrollmentdaoService;
import com.macquarium.ong.vo.DSMEnrollment;

@Service
@Component(metatype = false)
public class DSMEnrollmentdaoServiceImpl implements DSMEnrollmentdaoService {

	private Logger logger = LoggerFactory.getLogger(DSMEnrollmentdaoServiceImpl.class);
	@Reference
	private CommonConfigService commonConfigService;

	public boolean insertDSMEnrollmentInfo(DSMEnrollment dsmEnrollment) {
		boolean result=false;
		logger.info("insert dsm enrollment info");
		System.out.println("dsm enroll to db");
		Connection connection = null;
		try {
			logger.info("insertion started");
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(commonConfigService.getMySqlConnectionUrl(),commonConfigService.getDataBaseUsername(), commonConfigService.getDataBasePassword());
			if (connection != null) {
				logger.info("after connection object");
				logger.info(dsmEnrollment.getRequestString());
				String query="insert into delta_offer (ldc_name,ldc_account_number,website_id,delta_sm_account,delta_sm_fname,delta_sm_lname,email,phone,enroll_date,ong_fname,ong_lname,promocode)values(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement preparedStmt = connection.prepareStatement(query);
				preparedStmt.setString(1, dsmEnrollment.getLDCName());
				preparedStmt.setString(2, dsmEnrollment.getLDCAccountNumber());
				preparedStmt.setString(3, dsmEnrollment.getPortalName());
				preparedStmt.setString(4, dsmEnrollment.getDsmAccountNumber());
				preparedStmt.setString(5, dsmEnrollment.getDsmFirstName());
				preparedStmt.setString(6, dsmEnrollment.getDsmLastName());
				preparedStmt.setString(7, dsmEnrollment.getDsmEmail());
				preparedStmt.setString(8, dsmEnrollment.getDsmPhone());
				Timestamp currentTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
				preparedStmt.setTimestamp(9, currentTimestamp);
				preparedStmt.setString(10, dsmEnrollment.getFirstName());
				preparedStmt.setString(11, dsmEnrollment.getLastName());
				preparedStmt.setString(12, dsmEnrollment.getPromotionCode());
				logger.info("before execution");

				preparedStmt.execute();
				logger.info("after execution");
				result=true;
			}
		}catch(ClassNotFoundException e){

			result=false;
			logger.info("ClassNotFoundException e");
			logger.info(e.getMessage());
			e.printStackTrace();
		}catch (SQLException e) {

			result=false;
			logger.info("SQLException e");
			logger.info(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				logger.info("SQLException e");
				logger.info(e.getMessage());
				e.printStackTrace();
			}
		}
		return result;
	}

}
