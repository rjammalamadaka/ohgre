package com.macquarium.ong;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

public class HeaderHandlerResolver implements HandlerResolver {
	
	private static final long serialVersionUID = 1L;
	
public List<Handler> getHandlerChain(PortInfo portInfo) {
	System.out.println("getHandlerChain");
      List<Handler> handlerChain = new ArrayList<Handler>(); 
      HeaderHandler hh = new HeaderHandler(); 
     // WsSecurityHandler wsSecurityHandler = new WsSecurityHandler("NESWebServiceConsumer401", "x"); 
      handlerChain.add(hh);
 
      return handlerChain;
   }
}