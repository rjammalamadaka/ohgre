package com.macquarium.ong;

import java.io.IOException;
import java.rmi.ServerException;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SlingServlet(paths="/bin/getPromoGroupInfo", methods = "GET", metatype=false)
public class GetPromoGroupInfo extends org.apache.sling.api.servlets.SlingAllMethodsServlet {
	private Logger logger = LoggerFactory.getLogger(GetPromoCodeInfoServlet.class);
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException, IOException {
		JSONObject obj=new JSONObject();
		logger.info("--> GetPromoCodeIndfoServlet doGet -->");
		String promocode=request.getParameter("promoCode");
		String portalName=request.getParameter("portalName");		
		ResourceResolver resourceResolver=request.getResourceResolver();
		String resourcePath="/content/onlyong/promotions/oh";
		if(portalName.equals("oh")){
			resourcePath="/content/onlyong/promotions/oh";
		}else if(portalName.equals("gre")){
			resourcePath="/content/gre/promotions/gre";
		}
		Resource res=resourceResolver.getResource(resourcePath);
		if(null !=res && null!=promocode && null!=portalName){			
			Node node= res.adaptTo(Node.class);
			JSONObject promoobj=new JSONObject();;
			try {				
				NodeIterator nodeIterator =node.getNodes();				
				while (nodeIterator.hasNext()) {
					
					Node nodeObject = (Node) nodeIterator.next();
					Property property=null;
					try{
						property=nodeObject.getProperty(promocode);
					}catch(RepositoryException e){
						logger.error("Repository Exception");
					}					
					
					if(null !=property){						
						Value value=property.getValue();						
						promoobj.put("promoCode",property.getName());
						if(null !=value){
							String name=nodeObject.getName();							
							promoobj.put("name",name);
							promoobj.put("value", value.getString());
							
							break;
						}
					}
				}
				
				if(promoobj.isNull("promoCode")){
					obj.put("success", false);
					obj.put("errorMessage", promocode+" Is not configured");
				}else{
					obj.put("promoCodeInfo", promoobj);
					obj.put("success", true);
					obj.put("errorMessage", "");
				}
				
			} catch (RepositoryException e1) {
				try{
				obj.put("success", false);
				obj.put("errorMessage", "PrmoCode not configured or Some other error");
				}catch(JSONException e){
					
				}
			}catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.error("JSONException");
			}
		}else{
			try {
				obj.put("success", false);
				obj.put("errorMessage", "Required parameters are empty");
			} catch (JSONException e) {				
				e.printStackTrace();
			}
		}
		String jsonData = obj.toString();
		response.getWriter().write(jsonData);
	}

}
