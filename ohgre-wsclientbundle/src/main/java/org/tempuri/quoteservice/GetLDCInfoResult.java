
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
 *         &lt;element name="SupplierName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SupplierCustomerServicePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LDCNodeCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LDC" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LDCCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LDCDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LDCEmergencyPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LDCCustomerServicePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="UOMDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "supplierName",
    "stateCode",
    "supplierCustomerServicePhone",
    "ldcNodeCnt",
    "ldc"
})
@XmlRootElement(name = "GetLDCInfoResult")
public class GetLDCInfoResult {

    @XmlElement(name = "ResponseStatus")
    protected String responseStatus;
    @XmlElement(name = "ResponseMessage")
    protected String responseMessage;
    @XmlElement(name = "SupplierName")
    protected String supplierName;
    @XmlElement(name = "StateCode")
    protected String stateCode;
    @XmlElement(name = "SupplierCustomerServicePhone")
    protected String supplierCustomerServicePhone;
    @XmlElement(name = "LDCNodeCnt")
    protected String ldcNodeCnt;
    @XmlElement(name = "LDC")
    protected List<GetLDCInfoResult.LDC> ldc;

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
     * Gets the value of the supplierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * Sets the value of the supplierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierName(String value) {
        this.supplierName = value;
    }

    /**
     * Gets the value of the stateCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * Sets the value of the stateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateCode(String value) {
        this.stateCode = value;
    }

    /**
     * Gets the value of the supplierCustomerServicePhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierCustomerServicePhone() {
        return supplierCustomerServicePhone;
    }

    /**
     * Sets the value of the supplierCustomerServicePhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierCustomerServicePhone(String value) {
        this.supplierCustomerServicePhone = value;
    }

    /**
     * Gets the value of the ldcNodeCnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLDCNodeCnt() {
        return ldcNodeCnt;
    }

    /**
     * Sets the value of the ldcNodeCnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLDCNodeCnt(String value) {
        this.ldcNodeCnt = value;
    }

    /**
     * Gets the value of the ldc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ldc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLDC().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetLDCInfoResult.LDC }
     * 
     * 
     */
    public List<GetLDCInfoResult.LDC> getLDC() {
        if (ldc == null) {
            ldc = new ArrayList<GetLDCInfoResult.LDC>();
        }
        return this.ldc;
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
     *         &lt;element name="LDCCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="LDCDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="LDCEmergencyPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="LDCCustomerServicePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="UOMDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "ldcCode",
        "ldcDesc",
        "ldcEmergencyPhone",
        "ldcCustomerServicePhone",
        "uomDesc"
    })
    public static class LDC {

        @XmlElement(name = "LDCCode")
        protected String ldcCode;
        @XmlElement(name = "LDCDesc")
        protected String ldcDesc;
        @XmlElement(name = "LDCEmergencyPhone")
        protected String ldcEmergencyPhone;
        @XmlElement(name = "LDCCustomerServicePhone")
        protected String ldcCustomerServicePhone;
        @XmlElement(name = "UOMDesc")
        protected String uomDesc;

        /**
         * Gets the value of the ldcCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLDCCode() {
            return ldcCode;
        }

        /**
         * Sets the value of the ldcCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLDCCode(String value) {
            this.ldcCode = value;
        }

        /**
         * Gets the value of the ldcDesc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLDCDesc() {
            return ldcDesc;
        }

        /**
         * Sets the value of the ldcDesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLDCDesc(String value) {
            this.ldcDesc = value;
        }

        /**
         * Gets the value of the ldcEmergencyPhone property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLDCEmergencyPhone() {
            return ldcEmergencyPhone;
        }

        /**
         * Sets the value of the ldcEmergencyPhone property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLDCEmergencyPhone(String value) {
            this.ldcEmergencyPhone = value;
        }

        /**
         * Gets the value of the ldcCustomerServicePhone property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLDCCustomerServicePhone() {
            return ldcCustomerServicePhone;
        }

        /**
         * Sets the value of the ldcCustomerServicePhone property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLDCCustomerServicePhone(String value) {
            this.ldcCustomerServicePhone = value;
        }

        /**
         * Gets the value of the uomDesc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUOMDesc() {
            return uomDesc;
        }

        /**
         * Sets the value of the uomDesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUOMDesc(String value) {
            this.uomDesc = value;
        }

    }

}
