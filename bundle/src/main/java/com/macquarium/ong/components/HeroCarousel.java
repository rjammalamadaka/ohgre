package com.macquarium.ong.components;


import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.commons.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HeroCarousel extends WCMUsePojo {

	public List<CarouselSlide> slidesList;
	@Override
	public void activate() throws Exception {
		System.out.println("start the active ");
		String[] navItems = getProperties().get("iItems", String[].class);
		slidesList=new ArrayList<CarouselSlide>();
		if(null !=navItems)
		for(String item:navItems){
			CarouselSlide carouselSlide=new CarouselSlide();
			JSONObject json=new JSONObject(item);
			  	
				carouselSlide.setTitle((String)json.get("title"));
			     carouselSlide.setDescription((String)json.get("description"));
			     carouselSlide.setImagePath((String)json.get("imagepath"));
			     carouselSlide.setButtonTitle((String)json.get("buttontitle"));
			     carouselSlide.setButtonPath((String)json.get("buttonpath"));
			     carouselSlide.setSmallDescription((String)json.get("smalldescription"));
			     slidesList.add(carouselSlide);  
		}		
	}
	public List<CarouselSlide> getSlidesList() {
		return slidesList;
	}
	public void setSlidesList(List<CarouselSlide> slidesList) {
		this.slidesList = slidesList;
	}
	
	
}
