package com.macquarium.ong;

import java.io.IOException;
import java.rmi.ServerException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

@SlingServlet(paths="/bin/sendEmail", methods = "GET", metatype=true)
public class SendEmailServlet extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
    private static final long serialVersionUID = 1L;
    @Reference
    private SendEmailService sendEmailService;
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
        JSONObject obj=new JSONObject();
        try {
            // sendEmailService.sendEmail("avinashdv07@gmail.com", "Mail Content");
            obj.put("test", "true");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jsonData = obj.toString();
        response.getWriter().write(jsonData);
    }
}
