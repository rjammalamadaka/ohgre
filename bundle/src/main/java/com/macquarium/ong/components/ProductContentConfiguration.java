package com.macquarium.ong.components;


import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.commons.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ProductContentConfiguration extends WCMUsePojo {

	public List<ProductContent> productContentList;
	@Override
	public void activate() throws Exception {
		System.out.println("start the active ");
		String[] navItems = getProperties().get("iItems", String[].class);
		productContentList=new ArrayList<ProductContent>();
		if(null !=navItems)
		for(String item:navItems){
			ProductContent productContent=new ProductContent();
			JSONObject json=new JSONObject(item);
			  	
			productContent.setProductCode((String)json.get("productcode"));
			productContent.setProductDescription((String)json.get("description"));
			    
			     productContentList.add(productContent);  
		}		
	}
	public List<ProductContent> getSlidesList() {
		return productContentList;
	}
	public void setSlidesList(List<ProductContent> productContentList) {
		this.productContentList = productContentList;
	}
	
	
}
