package com.macquarium.ong.impl;

import java.sql.*;
import java.util.Calendar;

import com.macquarium.ong.DSMEnrollmentServlet;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.macquarium.ong.CommonConfigService;
import com.macquarium.ong.SignUpDaoService;
import com.macquarium.ong.vo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Component(metatype = false)
public class SignUpDaoServiceImpl  implements SignUpDaoService{

    @Reference
    private CommonConfigService commonConfigService;

    private Logger logger = LoggerFactory.getLogger(SignUpDaoServiceImpl.class);


    public boolean insertCustomer(Customer customer) {
        boolean result=false;
        Connection connection = null;
        try {

            System.setProperty("javax.net.ssl.keyStore","/home/aem/keystore");
            System.setProperty("javax.net.ssl.keyStorePassword","bhaO6PlkkjHc2cfT");
            System.setProperty("javax.net.ssl.trustStore","/home/aem/truststore");
            System.setProperty("javax.net.ssl.trustStorePassword","bhaO6PlkkjHc2cfT");
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(commonConfigService.getMySqlConnectionUrl(),commonConfigService.getDataBaseUsername(), commonConfigService.getDataBasePassword());
            if (connection != null) {
                logger.info("111111111");
                Calendar currentCalendar = Calendar.getInstance();
                Calendar onemonthcalendar = Calendar.getInstance();
                onemonthcalendar.add(Calendar.MONTH, -1);
                Calendar threemonthcalendar = Calendar.getInstance();
                threemonthcalendar.add(Calendar.MONTH, -3);
                java.sql.Date todayDate = new java.sql.Date(currentCalendar.getTime().getTime());
                java.sql.Date movingOneMonthDate = new java.sql.Date(onemonthcalendar.getTime().getTime());
                java.sql.Date movingThreeMonthDate = new java.sql.Date(threemonthcalendar.getTime().getTime());

                String query="insert into signup(website,created,first_name,last_name,email,phone_number,contact_via_phone,source,moving_date,address1,address2,city,state,zip,special_offers_optin,lead_source)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, customer.getType());
                preparedStmt.setDate(2, todayDate);
                preparedStmt.setString(3, customer.getFirstName());
                preparedStmt.setString(4, customer.getLastName());
                preparedStmt.setString(5, customer.getEmail());
                preparedStmt.setString(6, customer.getPhoneNumber());

                String contactpermission= customer.getContactViaPhone();// getParameterInfo(jObj,"contactpermission");
                if(contactpermission.equalsIgnoreCase("yes")){
                    preparedStmt.setBoolean(7, true);
                }else{
                    preparedStmt.setBoolean(7, false);
                }
                preparedStmt.setString(8, customer.getSource());
                preparedStmt.setDate(9,customer.getMovingDate());
                preparedStmt.setString(10,customer.getAddress1());
                preparedStmt.setString(11,customer.getAddress2());
                preparedStmt.setString(12, customer.getCity());
                preparedStmt.setString(13, customer.getState());
                preparedStmt.setString(14, customer.getZip());

                String sendemails=customer.getSpecialOffersOption();
                if(sendemails.equals("true")){
                    preparedStmt.setBoolean(15,true) ;
                    logger.info("2222222");
                }else{
                    preparedStmt.setBoolean(15,false );
                }
                preparedStmt.setString(16,customer.getSignupType());
                preparedStmt.execute();
                result=true;

                logger.info("checking session status");
                String query2="SHOW SESSION STATUS LIKE 'Ssl_version'";
                Statement statement=connection.createStatement();
                ResultSet rs=statement.executeQuery(query2);
                logger.info("after execution");
                rs.next();
                logger.info(rs.getString(1));
                logger.info(rs.getString(2));

                String query3="SHOW SESSION STATUS LIKE 'Ssl_cipher'";
                Statement statement1=connection.createStatement();
                ResultSet rs2=statement1.executeQuery(query3);
                logger.info("after execution");
                rs2.next();
                logger.info(rs2.getString(1));
                logger.info(rs2.getString(2));


            }



        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }


    public boolean isExistingCustomer(Customer customer) {
        boolean result=false;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(commonConfigService.getMySqlConnectionUrl(),commonConfigService.getDataBaseUsername(), commonConfigService.getDataBasePassword());
            if (connection != null) {
                if(customer.getEmail().length()>0){
                    String query="SELECT * FROM signup where email=? and type=? and lead_source=?";
                    PreparedStatement preparedStatement =connection.prepareStatement(query);
                    preparedStatement.setString(1, customer.getEmail());
                    preparedStatement.setString(2, customer.getType());
                    preparedStatement.setString(3, customer.getSignupType());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        result=true;
                    }
                }else{

                }

            }
        }catch(Exception e){
        }
        return result;
    }


    public boolean updateCustomer(Customer customer) {
        boolean result=false;
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(commonConfigService.getMySqlConnectionUrl(),commonConfigService.getDataBaseUsername(), commonConfigService.getDataBasePassword());
            if (connection != null) {
                Calendar currentCalendar = Calendar.getInstance();
                Calendar onemonthcalendar = Calendar.getInstance();
                onemonthcalendar.add(Calendar.MONTH, -1);
                Calendar threemonthcalendar = Calendar.getInstance();
                threemonthcalendar.add(Calendar.MONTH, -3);
                java.sql.Date todayDate = new java.sql.Date(currentCalendar.getTime().getTime());
                java.sql.Date movingOneMonthDate = new java.sql.Date(onemonthcalendar.getTime().getTime());
                java.sql.Date movingThreeMonthDate = new java.sql.Date(threemonthcalendar.getTime().getTime());
                String query="UPDATE signup SET type=?, created=?, first_name=?, last_name=?, phone_number=?, contact_via_phone=?, source=?,moving_date=?, address1=?, address2=?, city=?, state=?, zip=?, special_offers_optin=? where email=? and type=? and lead_source=?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, customer.getType());
                preparedStmt.setDate(2, todayDate);
                preparedStmt.setString(3, customer.getFirstName());
                preparedStmt.setString(4, customer.getLastName());
                preparedStmt.setString(5, customer.getPhoneNumber());
                String contactpermission= customer.getContactViaPhone();
                if(contactpermission.equalsIgnoreCase("yes")){
                    preparedStmt.setBoolean(6, true);
                }else{
                    preparedStmt.setBoolean(6, false);
                }
                preparedStmt.setString(7, customer.getSource());
                preparedStmt.setDate(8,customer.getMovingDate());
                preparedStmt.setString(9,customer.getAddress1());
                preparedStmt.setString(10,customer.getAddress2());
                preparedStmt.setString(11, customer.getCity());
                preparedStmt.setString(12, customer.getState());
                preparedStmt.setString(13, customer.getZip());
                String sendemails=customer.getSpecialOffersOption();
                if(sendemails.equals("true")){
                    preparedStmt.setBoolean(14,true) ;
                }else{
                    preparedStmt.setBoolean(14,false );
                }
                preparedStmt.setString(15, customer.getEmail());
                preparedStmt.setString(16, customer.getType());
                preparedStmt.setString(17, customer.getSignupType());
                int n= preparedStmt.executeUpdate();
                System.out.println(n);
                result=true;
            }

        }catch(Exception e){
            System.out.println("exception while update the record");
            e.printStackTrace();
        }
        return result;
    }

}
