
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
 *         &lt;element name="StateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LDCCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IncludeExpiredWithActiveBackUpInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RateClass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SourceOfSale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "stateCode",
    "ldcCode",
    "promotionCode",
    "includeExpiredWithActiveBackUpInd",
    "rateClass",
    "customerTypeCode",
    "sourceOfSale"
})
@XmlRootElement(name = "GetPromoCodeInfoRequest")
public class GetPromoCodeInfoRequest {

    @XmlElement(name = "StateCode")
    protected String stateCode;
    @XmlElement(name = "LDCCode")
    protected String ldcCode;
    @XmlElement(name = "PromotionCode")
    protected String promotionCode;
    @XmlElement(name = "IncludeExpiredWithActiveBackUpInd")
    protected String includeExpiredWithActiveBackUpInd;
    @XmlElement(name = "RateClass")
    protected String rateClass;
    @XmlElement(name = "CustomerTypeCode")
    protected String customerTypeCode;
    @XmlElement(name = "SourceOfSale")
    protected String sourceOfSale;

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
     * Gets the value of the promotionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionCode() {
        return promotionCode;
    }

    /**
     * Sets the value of the promotionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionCode(String value) {
        this.promotionCode = value;
    }

    /**
     * Gets the value of the includeExpiredWithActiveBackUpInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludeExpiredWithActiveBackUpInd() {
        return includeExpiredWithActiveBackUpInd;
    }

    /**
     * Sets the value of the includeExpiredWithActiveBackUpInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeExpiredWithActiveBackUpInd(String value) {
        this.includeExpiredWithActiveBackUpInd = value;
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

    /**
     * Gets the value of the customerTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerTypeCode() {
        return customerTypeCode;
    }

    /**
     * Sets the value of the customerTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerTypeCode(String value) {
        this.customerTypeCode = value;
    }

    /**
     * Gets the value of the sourceOfSale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceOfSale() {
        return sourceOfSale;
    }

    /**
     * Sets the value of the sourceOfSale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceOfSale(String value) {
        this.sourceOfSale = value;
    }

}
