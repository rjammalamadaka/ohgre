package com.macquarium.ong.impl;

import java.util.Dictionary;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;

import com.macquarium.ong.CommonConfigService;

@Component(immediate=true, metatype=true, name="OHGRE Common Configuration", label="OHGRE Common Configuration Service")
@Service(value=com.macquarium.ong.CommonConfigService.class)
@Properties({
        @Property(name="service.description", value="Common Settings for OHGRE site Components and Services"),
        @Property(name="service.vendor", value="Reply")
})

public class CommonConfigServiceImpl implements CommonConfigService {

    private static final long serialVersionUID = 1L;

    @Property(value="", label="Prime End Point Url", description="Prime End point url to communicate with prime", cardinality=0)
    private static final String PRIME_ENDPOINT_URL = "prime.endpoint.url";

    @Property(value="", label="Delta Sky Miles End Point Url", description="Delta Sky Miles End point url to communicate with SouthStar", cardinality=0)
    private static final String DELTA_SKY_MILES_ENDPOINT_URL = "deltaskymiles.endpoint.url";


    @Property(value="", label="My SQL Connection URL", description="My SQL Connection URL with schema name", cardinality=0)
    private static final String MY_SQL_CONNECTION_URL = "mysql.connection.url";

    @Property(value="", label="Data Base Username", description="Data Base Username", cardinality=0)
    private static final String DATA_BASE_USERNAME = "data.base.username";

    @Property(value="", label="Data Base Password", description="Data Base Password", cardinality=0)
    private static final String DATA_BASE_PASSWORD = "data.base.password";

    @Property(value="", label="What Count URL", description="What Count URL", cardinality=0)
    private static final String WHAT_COUNT_URL="what.count.url";

    @Property(value="", label="To Mail Address", description="To Mail Address", cardinality=0)
    private static final String TO_MAIL_ADDRESS="to.mail.address";

    @Property(value="STDRESONG", label="Oh standard residential promocode", description="Oh standard residential promocode", cardinality=0)
    private static final String OH_STANDARD_RESIDENTIAL_PROMOCODE="oh.standard.residential.promocode";

    @Property(value="STDCOMONG", label="Oh standard commercial promocode", description="Oh standard commercial promocode", cardinality=0)
    private static final String OH_STANDARD_COMMERCIAL_PROMOCODE="oh.standard.commercial.promocode";

    @Property(value="STDRESGRE", label="Gre standard residential promocode", description="Gre standard residential promocode", cardinality=0)
    private static final String GRE_STANDARD_RESIDENTIAL_PROMOCODE="gre.standard.residential.promocode";

    @Property(value="STDCOMGRE", label="Gre standard commercial promocode", description="Gre standard commercial promocode", cardinality=0)
    private static final String GRE_STANDARD_COMMERCIAL_PROMOCODE="gre.standard.commercial.promocode";

    private String primeEndPoint=PRIME_ENDPOINT_URL;
    private String mySqlConnectionUrl=MY_SQL_CONNECTION_URL;
    private String dataBaseUsername=DATA_BASE_USERNAME;
    private String dataBasePassword=DATA_BASE_PASSWORD;
    private String deltaSkyMilesEndPoint=DELTA_SKY_MILES_ENDPOINT_URL;
    private String whatCountsUrl=WHAT_COUNT_URL;
    private String toMailAddress = TO_MAIL_ADDRESS;
    private String ohStandardResPromo=OH_STANDARD_RESIDENTIAL_PROMOCODE;
    private String ohStandardComPromo=OH_STANDARD_COMMERCIAL_PROMOCODE;
    private String greStandardResPromo=GRE_STANDARD_RESIDENTIAL_PROMOCODE;
    private String greStandardComPromo=GRE_STANDARD_COMMERCIAL_PROMOCODE;


    public String getPrimeEndPoint() { return primeEndPoint; }
    public String getMySqlConnectionUrl() {
        return mySqlConnectionUrl;
    }
    public String getDataBaseUsername() {
        return dataBaseUsername;
    }
    public String getDataBasePassword() {
        return dataBasePassword;
    }
    public String getDeltaSkyMilesEndPoint(){
        return deltaSkyMilesEndPoint;
    }
    public String getWhatCountsUrl() {
        return whatCountsUrl;
    }
    public String getToMailAddress() {
        return toMailAddress;
    }
    public String getOhStandardResPromo(){
        return ohStandardResPromo;
    }
    public String getOhStandardComPromo(){
        return ohStandardComPromo;
    }
    public String getGreStandardResPromo(){
        return greStandardResPromo;
    }
    public String getGreStandardComPromo(){
        return greStandardComPromo;
    }

    protected void activate(ComponentContext context) {
        setup(context);
    }


    @SuppressWarnings("rawtypes")
    private void setup(ComponentContext context) {
        Dictionary properties = context.getProperties();
        primeEndPoint=PropertiesUtil.toString(properties.get(PRIME_ENDPOINT_URL),"");
        mySqlConnectionUrl=PropertiesUtil.toString(properties.get(MY_SQL_CONNECTION_URL),"");
        dataBaseUsername=PropertiesUtil.toString(properties.get(DATA_BASE_USERNAME),"");
        dataBasePassword=PropertiesUtil.toString(properties.get(DATA_BASE_PASSWORD),"");
        deltaSkyMilesEndPoint=PropertiesUtil.toString(properties.get(DELTA_SKY_MILES_ENDPOINT_URL),"");
        whatCountsUrl=PropertiesUtil.toString(properties.get(WHAT_COUNT_URL),"");
        toMailAddress = PropertiesUtil.toString(properties.get(TO_MAIL_ADDRESS),"");
        ohStandardResPromo=PropertiesUtil.toString(properties.get(OH_STANDARD_RESIDENTIAL_PROMOCODE),"");
        ohStandardComPromo=PropertiesUtil.toString(properties.get(OH_STANDARD_COMMERCIAL_PROMOCODE),"");
        greStandardResPromo=PropertiesUtil.toString(properties.get(GRE_STANDARD_RESIDENTIAL_PROMOCODE),"");
        greStandardComPromo=PropertiesUtil.toString(properties.get(GRE_STANDARD_COMMERCIAL_PROMOCODE),"");

    }

    @Modified
    protected void modified(ComponentContext context){
        Dictionary properties = context.getProperties();
        primeEndPoint=PropertiesUtil.toString(properties.get(PRIME_ENDPOINT_URL),"");
        mySqlConnectionUrl=PropertiesUtil.toString(properties.get(MY_SQL_CONNECTION_URL),"");
        dataBaseUsername=PropertiesUtil.toString(properties.get(DATA_BASE_USERNAME),"");
        dataBasePassword=PropertiesUtil.toString(properties.get(DATA_BASE_PASSWORD),"");
        deltaSkyMilesEndPoint=PropertiesUtil.toString(properties.get(DELTA_SKY_MILES_ENDPOINT_URL),"");
        whatCountsUrl=PropertiesUtil.toString(properties.get(WHAT_COUNT_URL),"");
        toMailAddress = PropertiesUtil.toString(properties.get(TO_MAIL_ADDRESS),"");
        ohStandardResPromo=PropertiesUtil.toString(properties.get(OH_STANDARD_RESIDENTIAL_PROMOCODE),"");
        ohStandardComPromo=PropertiesUtil.toString(properties.get(OH_STANDARD_COMMERCIAL_PROMOCODE),"");
        greStandardResPromo=PropertiesUtil.toString(properties.get(GRE_STANDARD_RESIDENTIAL_PROMOCODE),"");
        greStandardComPromo=PropertiesUtil.toString(properties.get(GRE_STANDARD_COMMERCIAL_PROMOCODE),"");
    }

}
