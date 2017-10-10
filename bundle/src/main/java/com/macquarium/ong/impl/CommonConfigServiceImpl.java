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

    @Property(value="https://prime.southstarenergy.com/webservices/quoteservice.asmx?wsdl", label="Prime End Point Url", description="Prime End point url to communicate with prime", cardinality=0)
    private static final String PRIME_ENDPOINT_URL = "prime.endpoint.url";

    @Property(value="https://test.prime.southstarenergy.com/SouthStar.Services.Web/Service.svc?wsdl", label="Delta Sky Miles End Point Url", description="Delta Sky Miles End point url to communicate with SouthStar", cardinality=0)
    private static final String DELTA_SKY_MILES_ENDPOINT_URL = "deltaskymiles.endpoint.url";


    @Property(value="jdbc:mysql://localhost:3306/dream11", label="My SQL Connection URL", description="My SQL Connection URL with schema name", cardinality=0)
    private static final String MY_SQL_CONNECTION_URL = "mysql.connection.url";

    @Property(value="root", label="Data Base Username", description="Data Base Username", cardinality=0)
    private static final String DATA_BASE_USERNAME = "data.base.username";

    @Property(value="root", label="Data Base Password", description="Data Base Password", cardinality=0)
    private static final String DATA_BASE_PASSWORD = "data.base.password";


    private String primeEndPoint=PRIME_ENDPOINT_URL;

    private String mySqlConnectionUrl=MY_SQL_CONNECTION_URL;
    private String dataBaseUsername=DATA_BASE_USERNAME;
    private String dataBasePassword=DATA_BASE_PASSWORD;
    private String deltaSkyMilesEndPoint=DELTA_SKY_MILES_ENDPOINT_URL;

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
    }

    @Modified
    protected void modified(ComponentContext context){
        Dictionary properties = context.getProperties();
        primeEndPoint=PropertiesUtil.toString(properties.get(PRIME_ENDPOINT_URL),"");
        mySqlConnectionUrl=PropertiesUtil.toString(properties.get(MY_SQL_CONNECTION_URL),"");
        dataBaseUsername=PropertiesUtil.toString(properties.get(DATA_BASE_USERNAME),"");
        dataBasePassword=PropertiesUtil.toString(properties.get(DATA_BASE_PASSWORD),"");
        deltaSkyMilesEndPoint=PropertiesUtil.toString(properties.get(DELTA_SKY_MILES_ENDPOINT_URL),"");
    }

}
