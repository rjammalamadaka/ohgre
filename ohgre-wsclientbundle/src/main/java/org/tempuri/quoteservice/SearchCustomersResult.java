
package org.tempuri.quoteservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResponseMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerNodeCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ComtiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Premise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="RateClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "responseStatus",
    "responseMessage",
    "customerNodeCnt",
    "comtiKey",
    "customer"
})
@XmlRootElement(name = "SearchCustomersResult")
public class SearchCustomersResult {

    @XmlElement(name = "ResponseStatus")
    protected String responseStatus;
    @XmlElement(name = "ResponseMessage")
    protected String responseMessage;
    @XmlElement(name = "CustomerNodeCnt")
    protected String customerNodeCnt;
    @XmlElement(name = "ComtiKey")
    protected String comtiKey;
    @XmlElement(name = "Customer")
    protected List<SearchCustomersResult.Customer> customer;

    /**
     * Gets the value of the responseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseStatus() {
        return responseStatus;
    }

    /**
     * Sets the value of the responseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseStatus(String value) {
        this.responseStatus = value;
    }

    /**
     * Gets the value of the responseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Sets the value of the responseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseMessage(String value) {
        this.responseMessage = value;
    }

    /**
     * Gets the value of the customerNodeCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerNodeCnt() {
        return customerNodeCnt;
    }

    /**
     * Sets the value of the customerNodeCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerNodeCnt(String value) {
        this.customerNodeCnt = value;
    }

    /**
     * Gets the value of the comtiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComtiKey() {
        return comtiKey;
    }

    /**
     * Sets the value of the comtiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComtiKey(String value) {
        this.comtiKey = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchCustomersResult.Customer }
     * 
     * 
     */
    public List<SearchCustomersResult.Customer> getCustomer() {
        if (customer == null) {
            customer = new ArrayList<SearchCustomersResult.Customer>();
        }
        return this.customer;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="LDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Premise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ServiceAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ServiceCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ServiceStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ServiceZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="RateClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ldc",
        "account",
        "premise",
        "customerName",
        "serviceAddress",
        "serviceCity",
        "serviceStateCode",
        "serviceZipCode",
        "phoneNumber",
        "rateClass"
    })
    public static class Customer {

        @XmlElement(name = "LDC")
        protected String ldc;
        @XmlElement(name = "Account")
        protected String account;
        @XmlElement(name = "Premise")
        protected String premise;
        @XmlElement(name = "CustomerName")
        protected String customerName;
        @XmlElement(name = "ServiceAddress")
        protected String serviceAddress;
        @XmlElement(name = "ServiceCity")
        protected String serviceCity;
        @XmlElement(name = "ServiceStateCode")
        protected String serviceStateCode;
        @XmlElement(name = "ServiceZipCode")
        protected String serviceZipCode;
        @XmlElement(name = "PhoneNumber")
        protected String phoneNumber;
        @XmlElement(name = "RateClass")
        protected String rateClass;

        /**
         * Gets the value of the ldc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLDC() {
            return ldc;
        }

        /**
         * Sets the value of the ldc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLDC(String value) {
            this.ldc = value;
        }

        /**
         * Gets the value of the account property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccount() {
            return account;
        }

        /**
         * Sets the value of the account property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccount(String value) {
            this.account = value;
        }

        /**
         * Gets the value of the premise property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPremise() {
            return premise;
        }

        /**
         * Sets the value of the premise property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPremise(String value) {
            this.premise = value;
        }

        /**
         * Gets the value of the customerName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCustomerName() {
            return customerName;
        }

        /**
         * Sets the value of the customerName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCustomerName(String value) {
            this.customerName = value;
        }

        /**
         * Gets the value of the serviceAddress property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceAddress() {
            return serviceAddress;
        }

        /**
         * Sets the value of the serviceAddress property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceAddress(String value) {
            this.serviceAddress = value;
        }

        /**
         * Gets the value of the serviceCity property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceCity() {
            return serviceCity;
        }

        /**
         * Sets the value of the serviceCity property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceCity(String value) {
            this.serviceCity = value;
        }

        /**
         * Gets the value of the serviceStateCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceStateCode() {
            return serviceStateCode;
        }

        /**
         * Sets the value of the serviceStateCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceStateCode(String value) {
            this.serviceStateCode = value;
        }

        /**
         * Gets the value of the serviceZipCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceZipCode() {
            return serviceZipCode;
        }

        /**
         * Sets the value of the serviceZipCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceZipCode(String value) {
            this.serviceZipCode = value;
        }

        /**
         * Gets the value of the phoneNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPhoneNumber() {
            return phoneNumber;
        }

        /**
         * Sets the value of the phoneNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPhoneNumber(String value) {
            this.phoneNumber = value;
        }

        /**
         * Gets the value of the rateClass property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRateClass() {
            return rateClass;
        }

        /**
         * Sets the value of the rateClass property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRateClass(String value) {
            this.rateClass = value;
        }

    }

}
