package com.macquarium.ong;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.rmi.ServerException;

import com.primesw.webservices.*;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.tempuri.quoteservice.UpdateCustomerInfoRequest;
import org.tempuri.quoteservice.UpdateCustomerInfoResult;


@SlingServlet(paths="/bin/rafUpdateCustomerInfo", methods = "POST", metatype=true)
public class RafUpdateCustomerInfoServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {

    private static final long serialVersionUID = 2598426539166789515L;

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
            String endPointUrl=	commonConfigService.getPrimeEndPoint();
            System.out.println("endPointUrl :"+endPointUrl);
            url = new URL(endPointUrl);
            long startTime = System.currentTimeMillis();
            jObj = new JSONObject(sb.toString());

            QuoteService quoteService=new QuoteService(url);
            HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver();
            quoteService.setHandlerResolver(handlerResolver);
            QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();

            UpdateCustomerInfoRequest updateCustomerInfoRequest=new UpdateCustomerInfoRequest();
            updateCustomerInfoRequest.setAccount(getParameterInfo(jObj, "account"));
            updateCustomerInfoRequest.setLDC(getParameterInfo(jObj, "ldc"));
            updateCustomerInfoRequest.setCustID(getParameterInfo(jObj,"custID"));  //custID
           // updateCustomerInfoRequest.setEmailAddress(getParameterInfo(jObj,"emailAddress"));   //emailAddress
            updateCustomerInfoRequest.setRAFTermsCondAcknowledgedInd("Y");

            UpdateCustomerInfo updateCustomerInfo=new UpdateCustomerInfo();
            updateCustomerInfo.setUpdateCustomerInfoRequest(updateCustomerInfoRequest);
            UpdateCustomerInfoResponse updateCustomerInfoResponse= quoteServiceSoap.updateCustomerInfo(updateCustomerInfo);
            UpdateCustomerInfoResult updateCustomerInfoResult=updateCustomerInfoResponse.getUpdateCustomerInfoResult();



            obj.put("ResponseStatus", updateCustomerInfoResult.getResponseStatus());
            obj.put("ResponseMessage", updateCustomerInfoResult.getResponseMessage());

        } catch (JSONException e) {
            try {
                obj.put("ResponseStatus", "1");
                obj.put("ResponseMessage", "error");
            } catch (Exception e1) {

            }

        }
        String jsonData = obj.toString();
        response.getWriter().write(jsonData);

    }

    String getParameterInfo(JSONObject JObject, String parameter){
        String result="";
        try{
            result=JObject.getString(parameter);
        }catch(Exception e){

        }
        return result;
    }

}