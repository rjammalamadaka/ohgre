
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
 *         &lt;element name="Customer" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ServiceAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ServiceZipCode4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ProductCategory" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ProductCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Total" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PaymentTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ChargeTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AdjustmentTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Balance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LandlordCustId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Transaction" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="TransactionTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TransactionAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TransactionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SentToUtilityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ConfirmedByUtilityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TransactionStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TransactionStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RejectReasonDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FACSTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FACSPONumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FACSTransactionDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BillDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BillDueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
    "customer",
    "productCategory"
})
@XmlRootElement(name = "GetNESBillDetailDataResult")
public class GetNESBillDetailDataResult {

    @XmlElement(name = "ResponseStatus")
    protected String responseStatus;
    @XmlElement(name = "ResponseMessage")
    protected String responseMessage;
    @XmlElement(name = "Customer")
    protected GetNESBillDetailDataResult.Customer customer;
    @XmlElement(name = "ProductCategory")
    protected List<GetNESBillDetailDataResult.ProductCategory> productCategory;

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
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link GetNESBillDetailDataResult.Customer }
     *     
     */
    public GetNESBillDetailDataResult.Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetNESBillDetailDataResult.Customer }
     *     
     */
    public void setCustomer(GetNESBillDetailDataResult.Customer value) {
        this.customer = value;
    }

    /**
     * Gets the value of the productCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetNESBillDetailDataResult.ProductCategory }
     * 
     * 
     */
    public List<GetNESBillDetailDataResult.ProductCategory> getProductCategory() {
        if (productCategory == null) {
            productCategory = new ArrayList<GetNESBillDetailDataResult.ProductCategory>();
        }
        return this.productCategory;
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
     *         &lt;element name="ServiceAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ServiceAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ServiceCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ServiceStateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ServiceZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ServiceZipCode4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "serviceAddress1",
        "serviceAddress2",
        "serviceCity",
        "serviceStateCode",
        "serviceZipCode",
        "serviceZipCode4"
    })
    public static class Customer {

        @XmlElement(name = "ServiceAddress1")
        protected String serviceAddress1;
        @XmlElement(name = "ServiceAddress2")
        protected String serviceAddress2;
        @XmlElement(name = "ServiceCity")
        protected String serviceCity;
        @XmlElement(name = "ServiceStateCode")
        protected String serviceStateCode;
        @XmlElement(name = "ServiceZipCode")
        protected String serviceZipCode;
        @XmlElement(name = "ServiceZipCode4")
        protected String serviceZipCode4;

        /**
         * Gets the value of the serviceAddress1 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceAddress1() {
            return serviceAddress1;
        }

        /**
         * Sets the value of the serviceAddress1 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceAddress1(String value) {
            this.serviceAddress1 = value;
        }

        /**
         * Gets the value of the serviceAddress2 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceAddress2() {
            return serviceAddress2;
        }

        /**
         * Sets the value of the serviceAddress2 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceAddress2(String value) {
            this.serviceAddress2 = value;
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
         * Gets the value of the serviceZipCode4 property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getServiceZipCode4() {
            return serviceZipCode4;
        }

        /**
         * Sets the value of the serviceZipCode4 property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setServiceZipCode4(String value) {
            this.serviceZipCode4 = value;
        }

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
     *         &lt;element name="ProductCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Total" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PaymentTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ChargeTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AdjustmentTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Balance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LandlordCustId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Transaction" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="TransactionTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TransactionAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TransactionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SentToUtilityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ConfirmedByUtilityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TransactionStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TransactionStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RejectReasonDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FACSTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FACSPONumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FACSTransactionDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BillDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BillDueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "productCategoryCode",
        "total",
        "transaction"
    })
    public static class ProductCategory {

        @XmlElement(name = "ProductCategoryCode")
        protected String productCategoryCode;
        @XmlElement(name = "Total")
        protected GetNESBillDetailDataResult.ProductCategory.Total total;
        @XmlElement(name = "Transaction")
        protected List<GetNESBillDetailDataResult.ProductCategory.Transaction> transaction;

        /**
         * Gets the value of the productCategoryCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProductCategoryCode() {
            return productCategoryCode;
        }

        /**
         * Sets the value of the productCategoryCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProductCategoryCode(String value) {
            this.productCategoryCode = value;
        }

        /**
         * Gets the value of the total property.
         * 
         * @return
         *     possible object is
         *     {@link GetNESBillDetailDataResult.ProductCategory.Total }
         *     
         */
        public GetNESBillDetailDataResult.ProductCategory.Total getTotal() {
            return total;
        }

        /**
         * Sets the value of the total property.
         * 
         * @param value
         *     allowed object is
         *     {@link GetNESBillDetailDataResult.ProductCategory.Total }
         *     
         */
        public void setTotal(GetNESBillDetailDataResult.ProductCategory.Total value) {
            this.total = value;
        }

        /**
         * Gets the value of the transaction property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the transaction property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTransaction().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetNESBillDetailDataResult.ProductCategory.Transaction }
         * 
         * 
         */
        public List<GetNESBillDetailDataResult.ProductCategory.Transaction> getTransaction() {
            if (transaction == null) {
                transaction = new ArrayList<GetNESBillDetailDataResult.ProductCategory.Transaction>();
            }
            return this.transaction;
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
         *         &lt;element name="PaymentTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ChargeTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AdjustmentTotal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Balance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LandlordCustId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "paymentTotal",
            "chargeTotal",
            "adjustmentTotal",
            "balance",
            "landlordCustId"
        })
        public static class Total {

            @XmlElement(name = "PaymentTotal")
            protected String paymentTotal;
            @XmlElement(name = "ChargeTotal")
            protected String chargeTotal;
            @XmlElement(name = "AdjustmentTotal")
            protected String adjustmentTotal;
            @XmlElement(name = "Balance")
            protected String balance;
            @XmlElement(name = "LandlordCustId")
            protected String landlordCustId;

            /**
             * Gets the value of the paymentTotal property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPaymentTotal() {
                return paymentTotal;
            }

            /**
             * Sets the value of the paymentTotal property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPaymentTotal(String value) {
                this.paymentTotal = value;
            }

            /**
             * Gets the value of the chargeTotal property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getChargeTotal() {
                return chargeTotal;
            }

            /**
             * Sets the value of the chargeTotal property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setChargeTotal(String value) {
                this.chargeTotal = value;
            }

            /**
             * Gets the value of the adjustmentTotal property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAdjustmentTotal() {
                return adjustmentTotal;
            }

            /**
             * Sets the value of the adjustmentTotal property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAdjustmentTotal(String value) {
                this.adjustmentTotal = value;
            }

            /**
             * Gets the value of the balance property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBalance() {
                return balance;
            }

            /**
             * Sets the value of the balance property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBalance(String value) {
                this.balance = value;
            }

            /**
             * Gets the value of the landlordCustId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLandlordCustId() {
                return landlordCustId;
            }

            /**
             * Sets the value of the landlordCustId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLandlordCustId(String value) {
                this.landlordCustId = value;
            }

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
         *         &lt;element name="TransactionTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TransactionAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TransactionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SentToUtilityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ConfirmedByUtilityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TransactionStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TransactionStatusDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RejectReasonDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FACSTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FACSPONumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FACSTransactionDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BillDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BillDueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "transactionTypeCode",
            "transactionAmount",
            "transactionDate",
            "sentToUtilityDate",
            "confirmedByUtilityDate",
            "transactionStatusCode",
            "transactionStatusDescription",
            "rejectReasonDescription",
            "facsTransactionId",
            "facspoNumber",
            "facsTransactionDescription",
            "billDate",
            "billDueDate"
        })
        public static class Transaction {

            @XmlElement(name = "TransactionTypeCode")
            protected String transactionTypeCode;
            @XmlElement(name = "TransactionAmount")
            protected String transactionAmount;
            @XmlElement(name = "TransactionDate")
            protected String transactionDate;
            @XmlElement(name = "SentToUtilityDate")
            protected String sentToUtilityDate;
            @XmlElement(name = "ConfirmedByUtilityDate")
            protected String confirmedByUtilityDate;
            @XmlElement(name = "TransactionStatusCode")
            protected String transactionStatusCode;
            @XmlElement(name = "TransactionStatusDescription")
            protected String transactionStatusDescription;
            @XmlElement(name = "RejectReasonDescription")
            protected String rejectReasonDescription;
            @XmlElement(name = "FACSTransactionId")
            protected String facsTransactionId;
            @XmlElement(name = "FACSPONumber")
            protected String facspoNumber;
            @XmlElement(name = "FACSTransactionDescription")
            protected String facsTransactionDescription;
            @XmlElement(name = "BillDate")
            protected String billDate;
            @XmlElement(name = "BillDueDate")
            protected String billDueDate;

            /**
             * Gets the value of the transactionTypeCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransactionTypeCode() {
                return transactionTypeCode;
            }

            /**
             * Sets the value of the transactionTypeCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransactionTypeCode(String value) {
                this.transactionTypeCode = value;
            }

            /**
             * Gets the value of the transactionAmount property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransactionAmount() {
                return transactionAmount;
            }

            /**
             * Sets the value of the transactionAmount property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransactionAmount(String value) {
                this.transactionAmount = value;
            }

            /**
             * Gets the value of the transactionDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransactionDate() {
                return transactionDate;
            }

            /**
             * Sets the value of the transactionDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransactionDate(String value) {
                this.transactionDate = value;
            }

            /**
             * Gets the value of the sentToUtilityDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSentToUtilityDate() {
                return sentToUtilityDate;
            }

            /**
             * Sets the value of the sentToUtilityDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSentToUtilityDate(String value) {
                this.sentToUtilityDate = value;
            }

            /**
             * Gets the value of the confirmedByUtilityDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getConfirmedByUtilityDate() {
                return confirmedByUtilityDate;
            }

            /**
             * Sets the value of the confirmedByUtilityDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setConfirmedByUtilityDate(String value) {
                this.confirmedByUtilityDate = value;
            }

            /**
             * Gets the value of the transactionStatusCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransactionStatusCode() {
                return transactionStatusCode;
            }

            /**
             * Sets the value of the transactionStatusCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransactionStatusCode(String value) {
                this.transactionStatusCode = value;
            }

            /**
             * Gets the value of the transactionStatusDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransactionStatusDescription() {
                return transactionStatusDescription;
            }

            /**
             * Sets the value of the transactionStatusDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransactionStatusDescription(String value) {
                this.transactionStatusDescription = value;
            }

            /**
             * Gets the value of the rejectReasonDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRejectReasonDescription() {
                return rejectReasonDescription;
            }

            /**
             * Sets the value of the rejectReasonDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRejectReasonDescription(String value) {
                this.rejectReasonDescription = value;
            }

            /**
             * Gets the value of the facsTransactionId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFACSTransactionId() {
                return facsTransactionId;
            }

            /**
             * Sets the value of the facsTransactionId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFACSTransactionId(String value) {
                this.facsTransactionId = value;
            }

            /**
             * Gets the value of the facspoNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFACSPONumber() {
                return facspoNumber;
            }

            /**
             * Sets the value of the facspoNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFACSPONumber(String value) {
                this.facspoNumber = value;
            }

            /**
             * Gets the value of the facsTransactionDescription property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFACSTransactionDescription() {
                return facsTransactionDescription;
            }

            /**
             * Sets the value of the facsTransactionDescription property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFACSTransactionDescription(String value) {
                this.facsTransactionDescription = value;
            }

            /**
             * Gets the value of the billDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBillDate() {
                return billDate;
            }

            /**
             * Sets the value of the billDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBillDate(String value) {
                this.billDate = value;
            }

            /**
             * Gets the value of the billDueDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBillDueDate() {
                return billDueDate;
            }

            /**
             * Sets the value of the billDueDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBillDueDate(String value) {
                this.billDueDate = value;
            }

        }

    }

}
