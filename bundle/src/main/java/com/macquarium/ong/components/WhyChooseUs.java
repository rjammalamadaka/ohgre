package com.macquarium.ong.components;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.commons.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WhyChooseUs extends WCMUsePojo{


    public List<WhyChooseUsData> whyChooseUsDataList;
    @Override
    public void activate() throws Exception {
        System.out.println("start the active ");
        String[] navItems = getProperties().get("energysavelist", String[].class);
        whyChooseUsDataList = new ArrayList<WhyChooseUsData>();
        if(null !=navItems)
            for(String item:navItems){
                WhyChooseUsData whyChooseUsData = new WhyChooseUsData();
                JSONObject json=new JSONObject(item);

                whyChooseUsData.setImagePath((String)json.get("imagepath"));
                whyChooseUsData.setDescritpion((String)json.get("termsdescription"));
                whyChooseUsDataList.add(whyChooseUsData);
            }
    }

    public List<WhyChooseUsData> getWhyChooseUsDataList() {
        return whyChooseUsDataList;
    }

    public void setWhyChooseUsDataList(List<WhyChooseUsData> whyChooseUsDataList) {
        this.whyChooseUsDataList = whyChooseUsDataList;
    }
}
