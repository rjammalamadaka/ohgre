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
	
		private String primeEndPoint=PRIME_ENDPOINT_URL;
	
	
	public String getPrimeEndPoint() {
		
		return primeEndPoint;
	}

	protected void activate(ComponentContext context) {
		setup(context);
	}
	

	@SuppressWarnings("rawtypes")
	private void setup(ComponentContext context) {
		Dictionary properties = context.getProperties();
		primeEndPoint=PropertiesUtil.toString(properties.get(PRIME_ENDPOINT_URL),"");
	}

	@Modified 
	protected void modified(ComponentContext context){   
		Dictionary properties = context.getProperties();
		primeEndPoint=PropertiesUtil.toString(properties.get(PRIME_ENDPOINT_URL),"");

		}
	
}
