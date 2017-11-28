package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.rmi.ServerException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tempuri.quoteservice.UpdateCustomerInfoRequest;
import org.tempuri.quoteservice.UpdateCustomerInfoResult;

import com.macquarium.ong.vo.RequestResponseVo;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import com.primesw.webservices.UpdateCustomerInfo;
import com.primesw.webservices.UpdateCustomerInfoResponse;

@SlingServlet(paths="/bin/rafUpdateCustomerInfo", methods = "POST", metatype=true)
public class RafUpdateCustomerInfoServlet extends SlingAllMethodsServlet{

    private Logger logger = LoggerFactory.getLogger(RafUpdateCustomerInfoServlet.class);

    @Reference
    private CommonConfigService commonConfigService;
    @Reference
    private SendEmailService sendEmailService;

    @Reference
    private RequestResponseDaoService requestResponseDaoService;

    private HashMap<String,String> mailContent=new HashMap<String,String>(8);

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
        logger.info("--> RafUpdateCustomerInfoServlet doGet -->");
        JSONObject obj = new JSONObject();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        JSONObject jObj = null;
        URL url=null;
        try {
            String endPointUrl=    commonConfigService.getPrimeEndPoint();
            logger.info("endPointUrl :"+endPointUrl);
            url = new URL(endPointUrl);
            long startTime = System.currentTimeMillis();
            jObj = new JSONObject(sb.toString());
            String referrer = request.getHeader("referer");
            String domain=request.getServerName();
            QuoteService quoteService=new QuoteService(url);
            HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeEndPoint());
            quoteService.setHandlerResolver(handlerResolver);
            QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
            UpdateCustomerInfoRequest updateCustomerInfoRequest=new UpdateCustomerInfoRequest();
            updateCustomerInfoRequest.setAccount(getParameterInfo(jObj, "account"));
            updateCustomerInfoRequest.setLDC(getParameterInfo(jObj, "ldc"));
            updateCustomerInfoRequest.setCustID(getParameterInfo(jObj,"custID"));
            String emailAddress=getParameterInfo(jObj,"emailAddress");
            if(null !=emailAddress && emailAddress.length()>0){
                updateCustomerInfoRequest.setEmailAddress(emailAddress);
            }
            String RAFTermsCondAcknowledgedInd=getParameterInfo(jObj,"RAFTermsCondAcknowledgedInd");
            if(null !=RAFTermsCondAcknowledgedInd && RAFTermsCondAcknowledgedInd.length()>0){
                updateCustomerInfoRequest.setRAFTermsCondAcknowledgedInd("Y");
            }
            UpdateCustomerInfo updateCustomerInfo=new UpdateCustomerInfo();
            updateCustomerInfo.setUpdateCustomerInfoRequest(updateCustomerInfoRequest);
            UpdateCustomerInfoResponse updateCustomerInfoResponse= quoteServiceSoap.updateCustomerInfo(updateCustomerInfo);
            UpdateCustomerInfoResult updateCustomerInfoResult=updateCustomerInfoResponse.getUpdateCustomerInfoResult();
            String soapRequest=handlerResolver.getRequest();
            String soapResponse=handlerResolver.getResponse();
            logger.info(soapRequest);
            logger.info(soapResponse);
            RequestResponseVo requestResponseVo=new RequestResponseVo();
            requestResponseVo.setAccnt("");
            requestResponseVo.setApiCall("UpdateCustomerInfo");
            requestResponseVo.setLdc("");
            requestResponseVo.setOrderNumber("0");
            requestResponseVo.setPage(referrer);
            requestResponseVo.setPostXML(soapRequest);
            requestResponseVo.setRespMessage(updateCustomerInfoResult.getResponseMessage());
            requestResponseVo.setRespNumb(updateCustomerInfoResult.getResponseStatus());
            requestResponseVo.setReturnXML(soapResponse);
            requestResponseVo.setSite(domain);
            requestResponseDaoService.insertPrimeRequestResponse(requestResponseVo);

            if(updateCustomerInfoResult.getResponseStatus().equalsIgnoreCase("-1")) {
                logger.info("Send mail with prime error");
                mailContent.put("request", soapRequest);
                mailContent.put("response", soapResponse);
                mailContent.put("responseMessage", updateCustomerInfoResult.getResponseStatus());
                mailContent.put("currentPagePath", referrer);
                mailContent.put("siteDomain", domain);
                sendEmailService.sendEmail(mailContent);

            }

            obj.put("ResponseStatus", updateCustomerInfoResult.getResponseStatus());
            obj.put("ResponseMessage", updateCustomerInfoResult.getResponseMessage());

        } catch (JSONException e) {
            try {
                obj.put("ResponseStatus", "1");
                obj.put("ResponseMessage", "error");
            } catch (Exception e1) {
                e.printStackTrace();
            }

        }
        String jsonData = obj.toString();
        response.getWriter().write(jsonData);
        logger.info("--> RafUpdateCustomerInfoServlet doGet -->");
    }

    String getParameterInfo(JSONObject JObject, String parameter){
        String result="";
        try{
            result=JObject.getString(parameter);
        }catch (Exception e){
            System.out.println("got error"+e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
