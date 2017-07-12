
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
 *         &lt;element name="RAFCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "rafCode",
    "ldc",
    "account"
})
@XmlRootElement(name = "CheckRAFEligibilityRequest")
public class CheckRAFEligibilityRequest {

    @XmlElement(name = "RAFCode")
    protected String rafCode;
    @XmlElement(name = "LDC")
    protected String ldc;
    @XmlElement(name = "Account")
    protected String account;

    /**
     * Gets the value of the rafCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRAFCode() {
        return rafCode;
    }

    /**
     * Sets the value of the rafCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRAFCode(String value) {
        this.rafCode = value;
    }

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

}
