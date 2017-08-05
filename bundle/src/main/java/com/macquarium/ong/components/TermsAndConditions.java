package com.macquarium.ong.components;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.commons.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TermsAndConditions extends WCMUsePojo{

    public List<TermsAndConditionsData> termsAndConditionsDataList;
    @Override
    public void activate() throws Exception {
        System.out.println("start the active ");
        String[] navItems = getProperties().get("termslist", String[].class);
        termsAndConditionsDataList = new ArrayList<TermsAndConditionsData>();
        if(null !=navItems)
            for(String item:navItems){
                TermsAndConditionsData termsAndConditionsData = new TermsAndConditionsData();
                JSONObject json=new JSONObject(item);

                termsAndConditionsData.setTermsTitle((String)json.get("termstitle"));
                termsAndConditionsData.setTermsDescription((String)json.get("termsdescription"));
                termsAndConditionsDataList.add(termsAndConditionsData);
            }
    }

    public List<TermsAndConditionsData> getTermsAndConditionsDataList() {
        return termsAndConditionsDataList;
    }

    public void setTermsAndConditionsDataList(List<TermsAndConditionsData> termsAndConditionsDataList) {
        this.termsAndConditionsDataList = termsAndConditionsDataList;
    }
}
