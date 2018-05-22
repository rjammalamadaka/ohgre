package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.Iterator;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.macquarium.ong.vo.DSMEnrollment;
import com.macquarium.ong.vo.DSMEnrollmentRes;
import com.macquarium.ong.vo.RequestResponseVo;

@SlingServlet(paths="/bin/DSMEnrollment", methods = "GET", metatype=true)
public class DSMEnrollmentServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {


    private Logger logger = LoggerFactory.getLogger(DSMEnrollmentServlet.class);
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Reference
    private CommonConfigService commonConfigService;

    @Reference
    private DSMEnrollmentdaoService dsmEnrollmentdaoService;

    @Reference
    private RequestResponseDaoService requestResponseDaoService;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
        doProcess(request,response);
    }
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
        doProcess(request,response);
    }

    protected void doProcess(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
        JSONObject obj=new JSONObject();
        logger.info("DSMEnrollment servlet doprocess");
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        JSONObject jObj = null;
        try {
            String referrer = request.getHeader("referer");
            String domain=request.getServerName();
            jObj = new JSONObject(sb.toString());
            DSMEnrollment dSMEnrollment=new DSMEnrollment();
            dSMEnrollment.setFirstName(getParameterInfo(jObj,"firstName"));
            dSMEnrollment.setLastName(getParameterInfo(jObj,"lastName"));
            dSMEnrollment.setDsmEmail(getParameterInfo(jObj,"dsmEmail"));
            dSMEnrollment.setDsmFirstName(getParameterInfo(jObj,"dsmfirstName"));
            dSMEnrollment.setDsmLastName(getParameterInfo(jObj,"dsmlastName"));
            dSMEnrollment.setDsmPhone(getParameterInfo(jObj,"dsmPhone"));
            dSMEnrollment.setDsmAccountNumber(getParameterInfo(jObj,"dsmAccountNumber"));
            dSMEnrollment.setLDCAccountNumber(getParameterInfo(jObj,"LDCAccountNumber"));
            dSMEnrollment.setLDCName(getParameterInfo(jObj,"LDCName"));
            dSMEnrollment.setPromotionCode(getParameterInfo(jObj,"PromotionCode"));
            dSMEnrollment.setPortalName(getParameterInfo(jObj,"portalName"));
            String soapEndpointUrl = commonConfigService.getDeltaSkyMilesEndPoint(); //"https://test.prime.southstarenergy.com/SouthStar.Services.Web/Service.svc";
            String soapAction = "http://tempuri.org/IService/DSMEnrollment";
            DSMEnrollmentRes dSMEnrollmentRes= callSoapWebService(soapEndpointUrl, soapAction,dSMEnrollment);
            String dsmStatus=dSMEnrollmentRes.getStatus();
            String message=   dSMEnrollmentRes.getMessage();
            logger.info("got the status");
            logger.info(dsmStatus);
            RequestResponseVo requestResponseVo=new RequestResponseVo();
            requestResponseVo.setAccnt(dSMEnrollment.getLDCAccountNumber());
            requestResponseVo.setApiCall("DSMEnrollment");
            requestResponseVo.setLdc(dSMEnrollment.getLDCName());
            requestResponseVo.setOrderNumber("0");
            requestResponseVo.setPage(referrer);
            requestResponseVo.setPostXML(dSMEnrollmentRes.getRequest());
            requestResponseVo.setRespMessage(dSMEnrollmentRes.getMessage());
            requestResponseVo.setRespNumb(dSMEnrollmentRes.getStatus());
            requestResponseVo.setReturnXML(dSMEnrollmentRes.getResponse());
            requestResponseVo.setSite(domain);
            logger.info("before inserting request and response info");
            requestResponseDaoService.insertPrimeRequestResponse(requestResponseVo);
            logger.info("after inserting request and response info");

            if(message.equals("Success")){
                logger.info("status true");
                logger.info("inserting DSMEnrollmentInfo in to database");
                dSMEnrollment.setRequestString(dSMEnrollmentRes.getRequest());
                dSMEnrollment.setResponseString(dSMEnrollmentRes.getResponse());
                dsmEnrollmentdaoService.insertDSMEnrollmentInfo(dSMEnrollment);
            }
            obj.put("message", message);
            obj.put("status", dsmStatus);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String jsonData = obj.toString();
        response.getWriter().write(jsonData);
    }
    private DSMEnrollmentRes callSoapWebService(String soapEndpointUrl, String soapAction,DSMEnrollment dSMEnrollment) {
        DSMEnrollmentRes dSMEnrollmentRes=new DSMEnrollmentRes();
        try {

            logger.info("DSMEnrollmentServlet->callSoapWebService ");
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            SOAPMessage soapRequest=createSOAPRequest(soapAction,dSMEnrollment);
            SOAPMessage soapResponse = soapConnection.call(soapRequest, soapEndpointUrl);

            ByteArrayOutputStream requestOut = new ByteArrayOutputStream();
            soapRequest.writeTo(requestOut);
            String requestString = new String(requestOut.toByteArray());
            logger.info("Request info");
            logger.info(requestString);
            dSMEnrollmentRes.setRequest(requestString);

            ByteArrayOutputStream responseOut = new ByteArrayOutputStream();
            soapResponse.writeTo(responseOut);
            String responseString = new String(responseOut.toByteArray());
            logger.info("Response info");
            logger.info(responseString);
            dSMEnrollmentRes.setResponse(responseString);


            SOAPPart soapPart = soapResponse.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            SOAPBody soapBody = envelope.getBody();

            Iterator iterator=  soapBody.getChildElements();
            SOAPElement DSMEnrollmentResponse=null;
            while(iterator.hasNext()){
                DSMEnrollmentResponse=(SOAPElement)iterator.next();
            }
            Iterator iterator1=DSMEnrollmentResponse.getChildElements();
            SOAPElement DSMEnrollmentResult=null;
            while(iterator1.hasNext()){
                DSMEnrollmentResult=(SOAPElement)iterator1.next();
            }
            System.out.println(DSMEnrollmentResult.getTagName());
            Iterator iterator3=DSMEnrollmentResult.getChildElements();
            while(iterator3.hasNext()){
                SOAPElement sOAPElement=(SOAPElement)iterator3.next();
                if(sOAPElement.getNodeName().equals("a:Message")){
                    dSMEnrollmentRes.setMessage(sOAPElement.getValue());
                }else  if(sOAPElement.getNodeName().equals("a:Status")){
                    dSMEnrollmentRes.setStatus(sOAPElement.getValue());
                }
            }
            soapConnection.close();

        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
        return dSMEnrollmentRes;
    }

    private SOAPMessage createSOAPRequest(String soapAction,DSMEnrollment dSMEnrollment) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        createSoapEnvelope(soapMessage,dSMEnrollment);
        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);
        soapMessage.saveChanges();
         /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");
        return soapMessage;
    }

    private void createSoapEnvelope(SOAPMessage soapMessage,DSMEnrollment dSMEnrollment) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();
        String sout = "sout";
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("tem", "http://tempuri.org/");
        envelope.addNamespaceDeclaration(sout, "http://schemas.datacontract.org/2004/07/SouthStar.Services.Web");
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("DSMEnrollment", "tem");
        SOAPElement soapBodyElem01 =soapBodyElem.addChildElement("request", "tem");
        SOAPElement soapBodyElem1 = soapBodyElem01.addChildElement("AccountFirstName", sout);
        SOAPElement soapBodyElem2 = soapBodyElem01.addChildElement("AccountLastName", sout);
        SOAPElement soapBodyElem3 = soapBodyElem01.addChildElement("DSMEmail", sout);
        SOAPElement soapBodyElem4 = soapBodyElem01.addChildElement("DSMFirstName", sout);
        SOAPElement soapBodyElem5 = soapBodyElem01.addChildElement("DSMLastName", sout);
        SOAPElement soapBodyElem6 = soapBodyElem01.addChildElement("DSMNumber", sout);
        SOAPElement soapBodyElem7 = soapBodyElem01.addChildElement("DSMPhone", sout);
        SOAPElement soapBodyElem8 = soapBodyElem01.addChildElement("LDCAccountNumber", sout);
        SOAPElement soapBodyElem9 = soapBodyElem01.addChildElement("LDCName", sout);
        soapBodyElem1.addTextNode(dSMEnrollment.getFirstName());
        soapBodyElem2.addTextNode(dSMEnrollment.getLastName());
        soapBodyElem3.addTextNode(dSMEnrollment.getDsmEmail());
        soapBodyElem4.addTextNode(dSMEnrollment.getDsmFirstName());
        soapBodyElem5.addTextNode(dSMEnrollment.getDsmLastName());
        soapBodyElem6.addTextNode(dSMEnrollment.getDsmAccountNumber());
        soapBodyElem7.addTextNode(dSMEnrollment.getDsmPhone());
        soapBodyElem8.addTextNode(dSMEnrollment.getLDCAccountNumber());
        soapBodyElem9.addTextNode(dSMEnrollment.getLDCName());
    }
    String getParameterInfo(JSONObject JObject, String parameter){
        String result="";
        try{
            result=JObject.getString(parameter);
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
