
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
 *         &lt;element name="LDCNodeCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LDC" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LDCCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="LDCDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PromoNodeCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Promotion" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PromotionDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PromotionExpired" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PromotionExpiratonDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BackupPromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DSMEligible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DSMAwardType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DSMAwardMiles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="GiftCardEligible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="GiftCardValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RAFEligible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RAFAdvertising" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ldcNodeCnt",
    "ldc"
})
@XmlRootElement(name = "GetPromoCodeInfoResult")
public class GetPromoCodeInfoResult {

    @XmlElement(name = "ResponseStatus")
    protected String responseStatus;
    @XmlElement(name = "ResponseMessage")
    protected String responseMessage;
    @XmlElement(name = "LDCNodeCnt")
    protected String ldcNodeCnt;
    @XmlElement(name = "LDC")
    protected List<GetPromoCodeInfoResult.LDC> ldc;

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
     * {@link GetPromoCodeInfoResult.LDC }
     * 
     * 
     */
    public List<GetPromoCodeInfoResult.LDC> getLDC() {
        if (ldc == null) {
            ldc = new ArrayList<GetPromoCodeInfoResult.LDC>();
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
     *         &lt;element name="PromoNodeCnt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Promotion" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PromotionDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PromotionExpired" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PromotionExpiratonDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BackupPromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DSMEligible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DSMAwardType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DSMAwardMiles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="GiftCardEligible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="GiftCardValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RAFEligible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RAFAdvertising" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "ldcCode",
        "ldcDesc",
        "promoNodeCnt",
        "promotion"
    })
    public static class LDC {

        @XmlElement(name = "LDCCode")
        protected String ldcCode;
        @XmlElement(name = "LDCDesc")
        protected String ldcDesc;
        @XmlElement(name = "PromoNodeCnt")
        protected String promoNodeCnt;
        @XmlElement(name = "Promotion")
        protected List<GetPromoCodeInfoResult.LDC.Promotion> promotion;

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
         * Gets the value of the promoNodeCnt property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPromoNodeCnt() {
            return promoNodeCnt;
        }

        /**
         * Sets the value of the promoNodeCnt property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPromoNodeCnt(String value) {
            this.promoNodeCnt = value;
        }

        /**
         * Gets the value of the promotion property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the promotion property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPromotion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetPromoCodeInfoResult.LDC.Promotion }
         * 
         * 
         */
        public List<GetPromoCodeInfoResult.LDC.Promotion> getPromotion() {
            if (promotion == null) {
                promotion = new ArrayList<GetPromoCodeInfoResult.LDC.Promotion>();
            }
            return this.promotion;
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
         *         &lt;element name="PromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PromotionDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PromotionExpired" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PromotionExpiratonDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BackupPromotionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DSMEligible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DSMAwardType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DSMAwardMiles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="GiftCardEligible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="GiftCardValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RAFEligible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RAFAdvertising" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "promotionCode",
            "promotionDesc",
            "promotionExpired",
            "promotionExpiratonDate",
            "backupPromotionCode",
            "dsmEligible",
            "dsmAwardType",
            "dsmAwardMiles",
            "giftCardEligible",
            "giftCardValue",
            "rafEligible",
            "rafAdvertising"
        })
        public static class Promotion {

            @XmlElement(name = "PromotionCode")
            protected String promotionCode;
            @XmlElement(name = "PromotionDesc")
            protected String promotionDesc;
            @XmlElement(name = "PromotionExpired")
            protected String promotionExpired;
            @XmlElement(name = "PromotionExpiratonDate")
            protected String promotionExpiratonDate;
            @XmlElement(name = "BackupPromotionCode")
            protected String backupPromotionCode;
            @XmlElement(name = "DSMEligible")
            protected String dsmEligible;
            @XmlElement(name = "DSMAwardType")
            protected String dsmAwardType;
            @XmlElement(name = "DSMAwardMiles")
            protected String dsmAwardMiles;
            @XmlElement(name = "GiftCardEligible")
            protected String giftCardEligible;
            @XmlElement(name = "GiftCardValue")
            protected String giftCardValue;
            @XmlElement(name = "RAFEligible")
            protected String rafEligible;
            @XmlElement(name = "RAFAdvertising")
            protected String rafAdvertising;

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
             * Gets the value of the promotionDesc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPromotionDesc() {
                return promotionDesc;
            }

            /**
             * Sets the value of the promotionDesc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPromotionDesc(String value) {
                this.promotionDesc = value;
            }

            /**
             * Gets the value of the promotionExpired property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPromotionExpired() {
                return promotionExpired;
            }

            /**
             * Sets the value of the promotionExpired property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPromotionExpired(String value) {
                this.promotionExpired = value;
            }

            /**
             * Gets the value of the promotionExpiratonDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPromotionExpiratonDate() {
                return promotionExpiratonDate;
            }

            /**
             * Sets the value of the promotionExpiratonDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPromotionExpiratonDate(String value) {
                this.promotionExpiratonDate = value;
            }

            /**
             * Gets the value of the backupPromotionCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBackupPromotionCode() {
                return backupPromotionCode;
            }

            /**
             * Sets the value of the backupPromotionCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBackupPromotionCode(String value) {
                this.backupPromotionCode = value;
            }

            /**
             * Gets the value of the dsmEligible property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDSMEligible() {
                return dsmEligible;
            }

            /**
             * Sets the value of the dsmEligible property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDSMEligible(String value) {
                this.dsmEligible = value;
            }

            /**
             * Gets the value of the dsmAwardType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDSMAwardType() {
                return dsmAwardType;
            }

            /**
             * Sets the value of the dsmAwardType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDSMAwardType(String value) {
                this.dsmAwardType = value;
            }

            /**
             * Gets the value of the dsmAwardMiles property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDSMAwardMiles() {
                return dsmAwardMiles;
            }

            /**
             * Sets the value of the dsmAwardMiles property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDSMAwardMiles(String value) {
                this.dsmAwardMiles = value;
            }

            /**
             * Gets the value of the giftCardEligible property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGiftCardEligible() {
                return giftCardEligible;
            }

            /**
             * Sets the value of the giftCardEligible property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGiftCardEligible(String value) {
                this.giftCardEligible = value;
            }

            /**
             * Gets the value of the giftCardValue property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGiftCardValue() {
                return giftCardValue;
            }

            /**
             * Sets the value of the giftCardValue property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGiftCardValue(String value) {
                this.giftCardValue = value;
            }

            /**
             * Gets the value of the rafEligible property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRAFEligible() {
                return rafEligible;
            }

            /**
             * Sets the value of the rafEligible property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRAFEligible(String value) {
                this.rafEligible = value;
            }

            /**
             * Gets the value of the rafAdvertising property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRAFAdvertising() {
                return rafAdvertising;
            }

            /**
             * Sets the value of the rafAdvertising property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRAFAdvertising(String value) {
                this.rafAdvertising = value;
            }

        }

    }

}
