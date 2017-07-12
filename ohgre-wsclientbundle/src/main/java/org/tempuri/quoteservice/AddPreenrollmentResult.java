
package org.tempuri.quoteservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="pre_enroll_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pre_enroll_stat_cd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pre_enroll_edit_errors" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="pre_enroll_edit_error_msg" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
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
    "preEnrollId",
    "preEnrollStatCd",
    "preEnrollEditErrors"
})
@XmlRootElement(name = "AddPreenrollmentResult")
public class AddPreenrollmentResult {

    @XmlElement(name = "ResponseStatus")
    protected String responseStatus;
    @XmlElement(name = "ResponseMessage")
    protected String responseMessage;
    @XmlElement(name = "pre_enroll_id")
    protected String preEnrollId;
    @XmlElement(name = "pre_enroll_stat_cd")
    protected String preEnrollStatCd;
    @XmlElement(name = "pre_enroll_edit_errors")
    protected List<AddPreenrollmentResult.PreEnrollEditErrors> preEnrollEditErrors;

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
     * Gets the value of the preEnrollId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreEnrollId() {
        return preEnrollId;
    }

    /**
     * Sets the value of the preEnrollId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreEnrollId(String value) {
        this.preEnrollId = value;
    }

    /**
     * Gets the value of the preEnrollStatCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreEnrollStatCd() {
        return preEnrollStatCd;
    }

    /**
     * Sets the value of the preEnrollStatCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreEnrollStatCd(String value) {
        this.preEnrollStatCd = value;
    }

    /**
     * Gets the value of the preEnrollEditErrors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the preEnrollEditErrors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPreEnrollEditErrors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddPreenrollmentResult.PreEnrollEditErrors }
     * 
     * 
     */
    public List<AddPreenrollmentResult.PreEnrollEditErrors> getPreEnrollEditErrors() {
        if (preEnrollEditErrors == null) {
            preEnrollEditErrors = new ArrayList<AddPreenrollmentResult.PreEnrollEditErrors>();
        }
        return this.preEnrollEditErrors;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="pre_enroll_edit_error_msg" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class PreEnrollEditErrors {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "pre_enroll_edit_error_msg")
        protected String preEnrollEditErrorMsg;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the preEnrollEditErrorMsg property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPreEnrollEditErrorMsg() {
            return preEnrollEditErrorMsg;
        }

        /**
         * Sets the value of the preEnrollEditErrorMsg property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPreEnrollEditErrorMsg(String value) {
            this.preEnrollEditErrorMsg = value;
        }

    }

}
