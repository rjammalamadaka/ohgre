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

    @Property(value="", label="Prime Header Handler End Point Url", description="Prime Header Handler End point url to communicate with prime", cardinality=0)
    private static final String PRIME_HEADER_HANDLER_ENDPOINT_URL = "prime.headerhandler.endpoint.url";

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

    private String primeEndPoint=PRIME_ENDPOINT_URL;
    private String primeHeaderHandlerEndPoint=PRIME_HEADER_HANDLER_ENDPOINT_URL;

    private String mySqlConnectionUrl=MY_SQL_CONNECTION_URL;
    private String dataBaseUsername=DATA_BASE_USERNAME;
    private String dataBasePassword=DATA_BASE_PASSWORD;
    private String deltaSkyMilesEndPoint=DELTA_SKY_MILES_ENDPOINT_URL;
    private String whatCountsUrl=WHAT_COUNT_URL;
    private String toMailAddress = TO_MAIL_ADDRESS;
    public String getPrimeEndPoint() {

        return primeEndPoint;
    }

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
    public String getPrimeHeaderHandlerUrl() {
        return primeHeaderHandlerEndPoint;
    }
    public String getWhatCountsUrl() {
        return whatCountsUrl;
    }

    public String getToMailAddress() {
        return toMailAddress;
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
        primeHeaderHandlerEndPoint=PropertiesUtil.toString(properties.get(PRIME_HEADER_HANDLER_ENDPOINT_URL),"");
        whatCountsUrl=PropertiesUtil.toString(properties.get(WHAT_COUNT_URL),"");
        toMailAddress = PropertiesUtil.toString(properties.get(TO_MAIL_ADDRESS),"");
    }

    @Modified
    protected void modified(ComponentContext context){
        Dictionary properties = context.getProperties();
        primeEndPoint=PropertiesUtil.toString(properties.get(PRIME_ENDPOINT_URL),"");
        mySqlConnectionUrl=PropertiesUtil.toString(properties.get(MY_SQL_CONNECTION_URL),"");
        dataBaseUsername=PropertiesUtil.toString(properties.get(DATA_BASE_USERNAME),"");
        dataBasePassword=PropertiesUtil.toString(properties.get(DATA_BASE_PASSWORD),"");
        deltaSkyMilesEndPoint=PropertiesUtil.toString(properties.get(DELTA_SKY_MILES_ENDPOINT_URL),"");
        primeHeaderHandlerEndPoint=PropertiesUtil.toString(properties.get(PRIME_HEADER_HANDLER_ENDPOINT_URL),"");
        whatCountsUrl=PropertiesUtil.toString(properties.get(WHAT_COUNT_URL),"");
        toMailAddress = PropertiesUtil.toString(properties.get(TO_MAIL_ADDRESS),"");
    }

}
