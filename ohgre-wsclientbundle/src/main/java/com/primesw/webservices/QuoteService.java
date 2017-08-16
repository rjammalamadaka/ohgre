package com.primesw.webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2017-08-16T11:25:42.371-04:00
 * Generated source version: 2.6.2
 * 
 */
@WebServiceClient(name = "QuoteService", 
                  wsdlLocation = "file:/Users/avinash.dhannuri/OH_GRE_Project/OH-GRE/ohgre-wsclientbundle/src/main/resources/wsdl/quoteservice.wsdl",
                  targetNamespace = "http://primesw.com/webservices") 
public class QuoteService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://primesw.com/webservices", "QuoteService");
    public final static QName QuoteServiceSoap = new QName("http://primesw.com/webservices", "QuoteServiceSoap");
    public final static QName QuoteServiceSoap12 = new QName("http://primesw.com/webservices", "QuoteServiceSoap12");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/avinash.dhannuri/OH_GRE_Project/OH-GRE/ohgre-wsclientbundle/src/main/resources/wsdl/quoteservice.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(QuoteService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/avinash.dhannuri/OH_GRE_Project/OH-GRE/ohgre-wsclientbundle/src/main/resources/wsdl/quoteservice.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public QuoteService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public QuoteService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public QuoteService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns QuoteServiceSoap
     */
    @WebEndpoint(name = "QuoteServiceSoap")
    public QuoteServiceSoap getQuoteServiceSoap() {
        return super.getPort(QuoteServiceSoap, QuoteServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns QuoteServiceSoap
     */
    @WebEndpoint(name = "QuoteServiceSoap")
    public QuoteServiceSoap getQuoteServiceSoap(WebServiceFeature... features) {
        return super.getPort(QuoteServiceSoap, QuoteServiceSoap.class, features);
    }
    /**
     *
     * @return
     *     returns QuoteServiceSoap
     */
    @WebEndpoint(name = "QuoteServiceSoap12")
    public QuoteServiceSoap getQuoteServiceSoap12() {
        return super.getPort(QuoteServiceSoap12, QuoteServiceSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns QuoteServiceSoap
     */
    @WebEndpoint(name = "QuoteServiceSoap12")
    public QuoteServiceSoap getQuoteServiceSoap12(WebServiceFeature... features) {
        return super.getPort(QuoteServiceSoap12, QuoteServiceSoap.class, features);
    }

}
