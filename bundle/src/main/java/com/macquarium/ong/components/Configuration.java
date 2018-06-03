package com.macquarium.ong.components;

import com.adobe.cq.sightly.WCMUsePojo;
import com.macquarium.ong.CommonConfigService;

public class Configuration extends WCMUsePojo{
    private  String name;
    private String ohStandardResPromo;
    private String ohStandardComPromo;
    private String greStandardResPromo;
    private String greStandardComPromo;

    public String getOhStandardResPromo() {
        return ohStandardResPromo;
    }

    public void setOhStandardResPromo(String ohStandardResPromo) {
        this.ohStandardResPromo = ohStandardResPromo;
    }

    public String getOhStandardComPromo() {
        return ohStandardComPromo;
    }

    public void setOhStandardComPromo(String ohStandardComPromo) {
        this.ohStandardComPromo = ohStandardComPromo;
    }

    public String getGreStandardResPromo() {
        return greStandardResPromo;
    }

    public void setGreStandardResPromo(String greStandardResPromo) {
        this.greStandardResPromo = greStandardResPromo;
    }

    public String getGreStandardComPromo() {
        return greStandardComPromo;
    }

    public void setGreStandardComPromo(String greStandardComPromo) {
        this.greStandardComPromo = greStandardComPromo;
    }

    @Override
    public void activate() throws Exception{
        CommonConfigService  commonConfigService=getSlingScriptHelper().getService(CommonConfigService.class);
        name=commonConfigService.getMySqlConnectionUrl();
        ohStandardResPromo=commonConfigService.getOhStandardResPromo();
        ohStandardComPromo=commonConfigService.getOhStandardComPromo();
        greStandardResPromo=commonConfigService.getGreStandardResPromo();
        greStandardComPromo=commonConfigService.getGreStandardComPromo();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
