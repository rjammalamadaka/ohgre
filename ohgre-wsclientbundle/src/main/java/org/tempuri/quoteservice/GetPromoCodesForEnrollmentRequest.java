
package org.tempuri.quoteservice;

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
 *         &lt;element name="LDCCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnrolledByUserId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthorizationLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "enrolledByUserId",
    "authorizationCode",
    "authorizationLevel"
})
@XmlRootElement(name = "GetPromoCodesForEnrollmentRequest")
public class GetPromoCodesForEnrollmentRequest {

    @XmlElement(name = "LDCCode")
    protected String ldcCode;
    @XmlElement(name = "EnrolledByUserId")
    protected String enrolledByUserId;
    @XmlElement(name = "AuthorizationCode")
    protected String authorizationCode;
    @XmlElement(name = "AuthorizationLevel")
    protected String authorizationLevel;

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
     * Gets the value of the enrolledByUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnrolledByUserId() {
        return enrolledByUserId;
    }

    /**
     * Sets the value of the enrolledByUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnrolledByUserId(String value) {
        this.enrolledByUserId = value;
    }

    /**
     * Gets the value of the authorizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    /**
     * Sets the value of the authorizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationCode(String value) {
        this.authorizationCode = value;
    }

    /**
     * Gets the value of the authorizationLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationLevel() {
        return authorizationLevel;
    }

    /**
     * Sets the value of the authorizationLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationLevel(String value) {
        this.authorizationLevel = value;
    }

}
