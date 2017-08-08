package com.macquarium.ong.components;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.commons.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TermsOfUse extends WCMUsePojo{

    public List<TermsOfUseData> termsOfUseDataList;
    @Override
    public void activate() throws Exception {
        System.out.println("start the active ");
        String[] navItems = getProperties().get("termslist", String[].class);
        termsOfUseDataList = new ArrayList<TermsOfUseData>();
        if(null !=navItems)
            for(String item:navItems){
                TermsOfUseData termsAndConditionsData = new TermsOfUseData();
                JSONObject json=new JSONObject(item);

                termsAndConditionsData.setTermsTitle((String)json.get("termstitle"));
                termsAndConditionsData.setTermsDescription((String)json.get("termsdescription"));
                termsOfUseDataList.add(termsAndConditionsData);
            }
    }

    public List<TermsOfUseData> getTermsAndConditionsDataList() {
        return termsOfUseDataList;
    }

    public void setTermsAndConditionsDataList(List<TermsAndConditionsData> termsAndConditionsDataList) {
        this.termsOfUseDataList = termsOfUseDataList;
    }
}
