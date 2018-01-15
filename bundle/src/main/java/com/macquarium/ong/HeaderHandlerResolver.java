package com.macquarium.ong;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;

@Component
public class HeaderHandlerResolver implements HandlerResolver {

    private static final long serialVersionUID = 1L;
    String endPointUrl=null;
    HeaderHandler hh=null;
    public HeaderHandlerResolver(){
        super();
    }
    public HeaderHandlerResolver(String endPointUrl){
        super();
        this.endPointUrl=endPointUrl;
    }
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        List<Handler> handlerChain = new ArrayList<Handler>();
        hh = new HeaderHandler(endPointUrl);
        handlerChain.add(hh);
        return handlerChain;
    }
    public String getResponse(){
        return hh.getSoapResponse();
    }
    public String getRequest(){
        return hh.getSoapRequest();
    }
}