package com.macquarium.ong.vo;

import java.sql.Date;

public class Customer {
    private String type;
    private Date created;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String contactViaPhone;
    private String source;
    private Date movingDate;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String specialOffersOption;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getContactViaPhone() {
        return contactViaPhone;
    }
    public void setContactViaPhone(String contactViaPhone) {
        this.contactViaPhone = contactViaPhone;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public Date getMovingDate() {
        return movingDate;
    }
    public void setMovingDate(Date movingDate) {
        this.movingDate = movingDate;
    }
    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        this.address1 = address1;
    }
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getSpecialOffersOption() {
        return specialOffersOption;
    }
    public void setSpecialOffersOption(String specialOffersOption) {
        this.specialOffersOption = specialOffersOption;
    }


}
