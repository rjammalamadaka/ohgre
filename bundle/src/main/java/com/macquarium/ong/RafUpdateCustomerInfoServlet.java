package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.rmi.ServerException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.UpdateCustomerInfoRequest;
import org.tempuri.quoteservice.UpdateCustomerInfoResult;

import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;
import com.primesw.webservices.UpdateCustomerInfo;
import com.primesw.webservices.UpdateCustomerInfoResponse;

@SlingServlet(paths="/bin/rafUpdateCustomerInfo", methods = "POST", metatype=true)
public class RafUpdateCustomerInfoServlet extends SlingAllMethodsServlet{
    @Reference
    private CommonConfigService commonConfigService;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
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
            System.out.println("endPointUrl :"+endPointUrl);
            url = new URL(endPointUrl);
            long startTime = System.currentTimeMillis();
            jObj = new JSONObject(sb.toString());

            QuoteService quoteService=new QuoteService(url);
            HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver(commonConfigService.getPrimeEndPoint());
            quoteService.setHandlerResolver(handlerResolver);
            QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();

            UpdateCustomerInfoRequest updateCustomerInfoRequest=new UpdateCustomerInfoRequest();
            updateCustomerInfoRequest.setAccount(getParameterInfo(jObj, "account"));
            updateCustomerInfoRequest.setLDC(getParameterInfo(jObj, "ldc"));
            updateCustomerInfoRequest.setCustID(getParameterInfo(jObj,"custID"));  //custID
            String emailAddress=getParameterInfo(jObj,"emailAddress");
            if(null !=emailAddress && emailAddress.length()>0){
                updateCustomerInfoRequest.setEmailAddress(emailAddress);   //emailAddress
            }
            String RAFTermsCondAcknowledgedInd=getParameterInfo(jObj,"RAFTermsCondAcknowledgedInd");
            System.out.println("RAFTermsCondAcknowledgedInd");
            System.out.println(RAFTermsCondAcknowledgedInd);
            if(null !=RAFTermsCondAcknowledgedInd && RAFTermsCondAcknowledgedInd.length()>0){
                System.out.println("If");
                updateCustomerInfoRequest.setRAFTermsCondAcknowledgedInd("Y");
            }
            // updateCustomerInfoRequest.setRAFTermsCondAcknowledgedInd("Y");

            UpdateCustomerInfo updateCustomerInfo=new UpdateCustomerInfo();
            updateCustomerInfo.setUpdateCustomerInfoRequest(updateCustomerInfoRequest);
            UpdateCustomerInfoResponse updateCustomerInfoResponse= quoteServiceSoap.updateCustomerInfo(updateCustomerInfo);
            UpdateCustomerInfoResult updateCustomerInfoResult=updateCustomerInfoResponse.getUpdateCustomerInfoResult();
            String soapRequest=handlerResolver.getRequest();
            String soapResponse=handlerResolver.getResponse();
            System.out.println("request");
            System.out.println(soapRequest);
            System.out.println("response");
            System.out.println(soapResponse);
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
