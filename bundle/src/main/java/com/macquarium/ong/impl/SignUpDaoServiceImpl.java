package com.macquarium.ong.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.macquarium.ong.CommonConfigService;
import com.macquarium.ong.SignUpDaoService;
import com.macquarium.ong.vo.Customer;

@Service
@Component(metatype = false)
public class SignUpDaoServiceImpl  implements SignUpDaoService{

    @Reference
    private CommonConfigService commonConfigService;


    public boolean insertCustomer(Customer customer) {
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

                String query="insert into signup(type,created,first_name,last_name,email,phone_number,contact_via_phone,source,moving_date,address1,address2,city,state,zip,special_offers_optin)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                }else{
                    preparedStmt.setBoolean(15,false );
                }

                result=preparedStmt.execute();
            }
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(commonConfigService.getDataBaseUsername());

        return result;
    }

}
