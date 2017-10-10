package com.macquarium.ong.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.macquarium.ong.CommonConfigService;
import com.macquarium.ong.EnrollmentDaoService;
import com.macquarium.ong.vo.Enrollment;

@Service
@Component(metatype = false)
public class EnrollmentDaoServiceImpl implements EnrollmentDaoService {

	@Reference
	private CommonConfigService commonConfigService;

	public int insertEnrollment(Enrollment enrollment) {
		int resultGeneratedkey=0;
		Connection connection = null;
		try {
			//Calendar currentCalendar = Calendar.getInstance();
			// java.sql.Date todayDate = new java.sql.Date(currentCalendar.getTime().getTime());
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(commonConfigService.getMySqlConnectionUrl(),commonConfigService.getDataBaseUsername(), commonConfigService.getDataBasePassword());
			if (connection != null) {
				String query="insert into enrollment(custID,createdDate,apiStatus,ldc,account,premise,firstName,lasNname,businessName,mailAddress1,mailAddress2,mailCity,mailCounty,mailStateCode," +
						"mailZipCode,mailZipPlusFour,serviceAddress1,serviceAddress2,serviceCity,serviceCounty,serviceStateCode,serviceZipCode,serviceZipPlusFour,phoneNumber,emailAddress,doNotCallInd," +
						"doNotMailInd,emailPrefTransactionalCd,emailPrefSSEPromotionalCd,emailPrefAffiliatePromotionalCd,emailPref3rdPartyCd,emailPrefNonTransactionalCd,languageCd,mailAddressVerified," +
						"serviceAddressVerified,productCode,overrideFixPricePerThermCd,overrideFixPricePerTherm,overrideVarPriceAddOnPerTherm,overrideCtrctDurationMonths,overrideCtrctTermDate," +
						"rafCode,enrolledByUserId,authorizationCode,authorizationLevel,channelID,promotionCode,campaignID,webSiteURL,custLeadSourceCode,actionIfContractExists,preventCancelFeeifContractExists," +
						"bypassCreditCheckInd,soldDate,bypassCIRInd,expectedQuoteAmt,tpvRequiredInd,emailTypeCode,alternateEmailAddress,editOnlyInd,b2BCustomerInd,expressConsentInd,brokerID," +
						"delaySendToUtilDate,renewalProductCode,renewalFixPricePerThermCd,renewalFixPricePerTherm,renewalVarPriceAddOnPerTherm,renewalCtrctDurationMonths,renewalCtrctTermDate," +
						"sourceSystemReferenceID) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


				PreparedStatement ps = connection.prepareStatement(query,new String[]{"id"});

				ps.setString(1,enrollment.getCustID());
				if(null !=enrollment.getCreatedDate()){
					ps.setString(2,enrollment.getCreatedDate().toLocaleString());
				}else{
					ps.setString(2,"");
				}
				ps.setInt(3, enrollment.getApiStatus());
				ps.setString(4, enrollment.getLdc());
				ps.setString(5, enrollment.getAccount());
				ps.setString(6, enrollment.getPremise());
				ps.setString(7, enrollment.getFirstName());
				ps.setString(8, enrollment.getLastName());
				ps.setString(9,enrollment.getBusinessName());
				ps.setString(10,enrollment.getMailAddress1());
				ps.setString(11,enrollment.getMailAddress2());
				ps.setString(12,enrollment.getMailCity());
				ps.setString(13,enrollment.getMailCounty());
				ps.setString(14,enrollment.getMailStateCode());
				ps.setString(15,enrollment.getMailZipCode());
				ps.setString(16,enrollment.getMailZipPlusFour());
				ps.setString(17,enrollment.getServiceAddress1());
				ps.setString(18,enrollment.getServiceAddress2());
				ps.setString(19,enrollment.getServiceCity());
				ps.setString(20,enrollment.getServiceCounty());
				ps.setString(21,enrollment.getServiceStateCode());
				ps.setString(22,enrollment.getServiceZipCode());
				ps.setString(23,enrollment.getServiceZipPlusFour());
				ps.setString(24,enrollment.getPhoneNumber());
				ps.setString(25,enrollment.getEmailAddress());
				ps.setString(26,enrollment.getDoNotCallInd());
				ps.setString(27,enrollment.getDoNotMailINd());
				ps.setString(28,enrollment.getEmailPrefTranctionalCd());
				ps.setString(29,enrollment.getEmailPrefSSEPromotionalCd());
				ps.setString(30,enrollment.getEmailPrefAffiliatePromotionalCd());
				ps.setString(31,enrollment.getEmailPref3rdPartyCd());
				ps.setString(32,enrollment.getEmailPrefNonTransactionalCd());
				ps.setString(33,enrollment.getLanguageCd());
				ps.setString(34,enrollment.getMailAddressVerified());
				ps.setString(35,enrollment.getServiceAddressVerified());
				ps.setString(36,enrollment.getProductCode());
				ps.setString(37,enrollment.getOverrideFixPricePerThermCd());
				ps.setString(38,enrollment.getOverrideFixPricePerTherm());
				ps.setString(39,enrollment.getOverrideVarPriceAddOnPerTherm());
				ps.setString(40,enrollment.getOverrideCtrctDurationMonths());
				if(null !=enrollment.getOverrideCtrctTermDate()){
					ps.setString(41,enrollment.getOverrideCtrctTermDate().toLocaleString());
				}else{
					ps.setString(41,"");
				}
				ps.setString(42,enrollment.getRafCode());
				ps.setString(43,enrollment.getEnrolledByUserId());
				ps.setString(44,enrollment.getAuthorizationCode());
				ps.setString(45, enrollment.getAuthorizationLevel());
				ps.setString(46,enrollment.getChannelID());
				ps.setString(47,enrollment.getPromotionCode());
				ps.setString(48,enrollment.getCampaignID());
				ps.setString(49,enrollment.getWebSiteURL());
				ps.setString(50,enrollment.getCustLeadSourceCode());
				ps.setString(51,enrollment.getActionIfContractExists());
				ps.setString(52,enrollment.getPreventCancelFeeifContractExists());
				ps.setString(53,enrollment.getBypassCreditCheckInd());
				if(null !=enrollment.getSoldDate()){
					ps.setString(54,enrollment.getSoldDate().toLocaleString());
				}else{
					ps.setString(54,"");
				}
				ps.setString(55,enrollment.getBypassCIRInd());
				ps.setString(56,enrollment.getExpectedQuoteAmt());
				ps.setString(57,enrollment.getTpvRequiredInd());
				ps.setString(58,enrollment.getEmailTypeCode());
				ps.setString(59, enrollment.getAlternateEmailAddress());
				ps.setString(60,enrollment.getEditOnlyInd());
				ps.setString(61,enrollment.getB2BCustomerInd());
				ps.setString(62,enrollment.getExpressConsentInd());
				ps.setString(63,enrollment.getBrokerID());
				if(null !=enrollment.getDelaySendToUtilDate()){
					ps.setString(64,enrollment.getDelaySendToUtilDate().toLocaleString());
				}else{
					ps.setString(64,"");
				}
				ps.setString(65,enrollment.getRenewalProductCode());
				ps.setString(66,enrollment.getRenewalFixPricePerThermCd());
				ps.setString(67,enrollment.getRenewalFixPricePerTherm());
				ps.setString(68,enrollment.getRenewalVarPriceAddOnPerTherm());
				ps.setString(69,enrollment.getRenewalCtrctDurationMonths());
				if(null !=enrollment.getRenewalCtrctTermDate()){
					ps.setString(70,enrollment.getRenewalCtrctTermDate().toLocaleString());
				}else{
					ps.setString(70,"");
				}
				ps.setString(71,enrollment.getSourceSystemReferenceID());
				ps.execute();
				ResultSet rs=ps.getGeneratedKeys();
				if(rs.next()){
					resultGeneratedkey=rs.getInt(1);
				}
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultGeneratedkey;
	}

	public int updateEnrollement(Enrollment enrollment,int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		int result=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(commonConfigService.getMySqlConnectionUrl(),commonConfigService.getDataBaseUsername(), commonConfigService.getDataBasePassword());
			if (connection != null) {

				String query = "update enrollment set custID = ? where id = ?";
				PreparedStatement preparedStmt = connection.prepareStatement(query);
				preparedStmt.setString   (1, enrollment.getCustID());
				preparedStmt.setInt(2, id);
				result = preparedStmt.executeUpdate();
			}
		}catch(Exception e){

		}
		return result;
	}

}
