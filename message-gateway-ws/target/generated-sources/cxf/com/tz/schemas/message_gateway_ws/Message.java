
package com.tz.schemas.message_gateway_ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Сообщение сочетающее транспортный конверт и тело сообщения
 *             
 * 
 * <p>Java class for Message complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Message">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Endpoints">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Endpoint" type="{http://schemas.tz.com/message-gateway-ws}Endpoint" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Header" type="{http://schemas.tz.com/message-gateway-ws}Header"/>
 *         &lt;element name="Body" type="{http://schemas.tz.com/message-gateway-ws}Body"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message", propOrder = {
    "endpoints",
    "header",
    "body"
})
public class Message {

    @XmlElement(name = "Endpoints", required = true)
    protected Message.Endpoints endpoints;
    @XmlElement(name = "Header", required = true)
    protected Header header;
    @XmlElement(name = "Body", required = true)
    protected Body body;

    /**
     * Gets the value of the endpoints property.
     * 
     * @return
     *     possible object is
     *     {@link Message.Endpoints }
     *     
     */
    public Message.Endpoints getEndpoints() {
        return endpoints;
    }

    /**
     * Sets the value of the endpoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Message.Endpoints }
     *     
     */
    public void setEndpoints(Message.Endpoints value) {
        this.endpoints = value;
    }

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link Body }
     *     
     */
    public Body getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link Body }
     *     
     */
    public void setBody(Body value) {
        this.body = value;
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
     *         &lt;element name="Endpoint" type="{http://schemas.tz.com/message-gateway-ws}Endpoint" maxOccurs="unbounded"/>
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
        "endpoint"
    })
    public static class Endpoints {

        @XmlElement(name = "Endpoint", required = true)
        protected List<Endpoint> endpoint;

        /**
         * Gets the value of the endpoint property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the endpoint property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEndpoint().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Endpoint }
         * 
         * 
         */
        public List<Endpoint> getEndpoint() {
            if (endpoint == null) {
                endpoint = new ArrayList<Endpoint>();
            }
            return this.endpoint;
        }

    }

}
