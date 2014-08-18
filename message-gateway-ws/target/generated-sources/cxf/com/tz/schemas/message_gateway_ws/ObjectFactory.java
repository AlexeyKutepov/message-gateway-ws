
package com.tz.schemas.message_gateway_ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tz.schemas.message_gateway_ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendMessageResponse_QNAME = new QName("http://schemas.tz.com/message-gateway-ws", "SendMessageResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tz.schemas.message_gateway_ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link SendEmailMessageAsync }
     * 
     */
    public SendEmailMessageAsync createSendEmailMessageAsync() {
        return new SendEmailMessageAsync();
    }

    /**
     * Create an instance of {@link SendEmailMessage }
     * 
     */
    public SendEmailMessage createSendEmailMessage() {
        return new SendEmailMessage();
    }

    /**
     * Create an instance of {@link SendMessageResponseType }
     * 
     */
    public SendMessageResponseType createSendMessageResponseType() {
        return new SendMessageResponseType();
    }

    /**
     * Create an instance of {@link Body }
     * 
     */
    public Body createBody() {
        return new Body();
    }

    /**
     * Create an instance of {@link Header }
     * 
     */
    public Header createHeader() {
        return new Header();
    }

    /**
     * Create an instance of {@link Endpoint }
     * 
     */
    public Endpoint createEndpoint() {
        return new Endpoint();
    }

    /**
     * Create an instance of {@link Message.Endpoints }
     * 
     */
    public Message.Endpoints createMessageEndpoints() {
        return new Message.Endpoints();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendMessageResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.tz.com/message-gateway-ws", name = "SendMessageResponse")
    public JAXBElement<SendMessageResponseType> createSendMessageResponse(SendMessageResponseType value) {
        return new JAXBElement<SendMessageResponseType>(_SendMessageResponse_QNAME, SendMessageResponseType.class, null, value);
    }

}
