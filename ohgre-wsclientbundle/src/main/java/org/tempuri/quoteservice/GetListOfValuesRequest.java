
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
 *         &lt;element name="CodeType" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="TableID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LDCCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "codeType",
    "tableID",
    "ldcCode"
})
@XmlRootElement(name = "GetListOfValuesRequest")
public class GetListOfValuesRequest {

    @XmlElement(name = "CodeType")
    protected Object codeType;
    @XmlElement(name = "TableID")
    protected String tableID;
    @XmlElement(name = "LDCCode")
    protected String ldcCode;

    /**
     * Gets the value of the codeType property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCodeType() {
        return codeType;
    }

    /**
     * Sets the value of the codeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCodeType(Object value) {
        this.codeType = value;
    }

    /**
     * Gets the value of the tableID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableID() {
        return tableID;
    }

    /**
     * Sets the value of the tableID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableID(String value) {
        this.tableID = value;
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

}
