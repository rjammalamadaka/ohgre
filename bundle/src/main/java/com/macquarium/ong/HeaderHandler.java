package com.macquarium.ong;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;


public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

	private static final long serialVersionUID = 1L;
	
public boolean handleMessage(SOAPMessageContext smc) {

	
	System.out.println("handleMessage method >>>>>>");
    Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

    if (outboundProperty.booleanValue()) {
        SOAPMessage message = smc.getMessage();
        try {         
            SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();           
            envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
            envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
            envelope.addNamespaceDeclaration("wsa", "http://schemas.xmlsoap.org/ws/2004/08/addressing");
            envelope.addNamespaceDeclaration("wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
            envelope.addNamespaceDeclaration("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            if(envelope.getHeader()!=null) {
            	System.out.println("envelope header not null");
                envelope.getHeader().detachNode();
            }           
            SOAPHeader header = envelope.addHeader();            
            SOAPElement actionElement= header.addChildElement("Action", "wsa");
            actionElement.addTextNode("http://primesw.com/webservices/GetQuotes");
            SOAPElement messageElement= header.addChildElement("MessageID", "wsa");
            messageElement.addTextNode("urn:uuid:SSE-Kellen-OPPC");
            SOAPElement replyToElement= header.addChildElement("ReplyTo", "wsa");
            SOAPElement childReplyToElement=replyToElement.addChildElement("Address","wsa");
            childReplyToElement.addTextNode("http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous");            
            SOAPElement toElement= header.addChildElement("To","wsa");
            toElement.addTextNode("https://test.prime.southstarenergy.com/Prime2/webservices/quoteservice.asmx");
            SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            long HOUR = 3600*1000;
            dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
            SOAPElement security = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
            Date currentDate=new Date();
            Date afterHour = new Date(currentDate.getTime() + 1 * HOUR);
            Date beforeHour = new Date(currentDate.getTime() - 1 * HOUR);
            
            SOAPElement timeStampElement =security.addChildElement("Timestamp","wsu");
            timeStampElement.setAttribute("wsu:Id", "Timestamp-0b79048e-85dc-4d52-8280-057ae2960f24");
            SOAPElement createdElement=timeStampElement.addChildElement("Created","wsu");
            SOAPElement expiresElement=timeStampElement.addChildElement("Expires","wsu");
            createdElement.addTextNode(dateFormatGmt.format(currentDate)+"Z");
            expiresElement.addTextNode(dateFormatGmt.format(afterHour)+"Z");
            SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
            usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            usernameToken.addAttribute(new QName("wsu:Id"), "SecurityToken-f3c4b745-97ec-4afc-b93a-af0aed1eafc5");
            SOAPElement username = usernameToken.addChildElement("Username", "wsse");
            username.addTextNode("NESWebServiceConsumer401");
            SOAPElement password = usernameToken.addChildElement("Password", "wsse");
            password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
           password.addTextNode("x");
           SOAPElement created = usernameToken.addChildElement("Created", "wsu");
           created.addTextNode(dateFormatGmt.format(beforeHour)+"Z");
           message.writeTo(System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    } else {
        try {

            //This handler does nothing with the response from the Web Service so
            //we just print out the SOAP message.
            SOAPMessage message = smc.getMessage();
            message.writeTo(System.out);
            System.out.println("");

        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }


    return outboundProperty;

}

public Set getHeaders() {   
    return null;
}

public boolean handleFault(SOAPMessageContext context) {
    //throw new UnsupportedOperationException("Not supported yet.");
    return true;
}

public void close(MessageContext context) {
//throw new UnsupportedOperationException("Not supported yet.");
}
}