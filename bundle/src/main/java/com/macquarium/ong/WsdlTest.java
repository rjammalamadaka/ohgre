package com.macquarium.ong;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.tempuri.quoteservice.GetQuotesResult;
import org.tempuri.quoteservice.GetQuotesResult.Customer;
import org.tempuri.quoteservice.GetQuotesResult.Customer.Product;
import org.tempuri.quoteservice.QuoteRequest;

import com.primesw.webservices.GetQuotes;
import com.primesw.webservices.GetQuotesResponse;
import com.primesw.webservices.QuoteService;
import com.primesw.webservices.QuoteServiceSoap;


public class WsdlTest {

	public static void main(String[] args){
		URL url=null;
		try {
			url = new URL("https://test.prime.southstarenergy.com/Prime1/webservices/quoteservice.asmx?wsdl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		QuoteService quoteService=new QuoteService(url);
		HeaderHandlerResolver handlerResolver=new HeaderHandlerResolver();
		quoteService.setHandlerResolver(handlerResolver);
		QuoteServiceSoap quoteServiceSoap=quoteService.getQuoteServiceSoap();
		GetQuotes parameters=new GetQuotes();
		QuoteRequest quoteRequest=new QuoteRequest();
		quoteRequest.setLDC("DUK");
		quoteRequest.setPrimaryProduct("ALL");
		quoteRequest.setEnrolledByUserId("Web Enroll-ONG");
		quoteRequest.setRateClass("01");
		quoteRequest.setAuthorizationCode("internal");
		quoteRequest.setAuthorizationLevel("3");
		parameters.setQuoteRequest(quoteRequest);
		System.out.println(quoteRequest);
		GetQuotesResponse getQuotesResponse =quoteServiceSoap.getQuotes(parameters);
		System.out.println("Got Response");
		GetQuotesResult getQuotesResult=getQuotesResponse.getGetQuotesResult();
		String responseStatus=getQuotesResult.getResponseStatus();
		String responsemessage=getQuotesResult.getResponseMessage();
		System.out.println("responseStatus :"+responseStatus);
		System.out.println("responsemessage :"+responsemessage);
		List<Customer> customerList=getQuotesResult.getCustomer();
		System.out.println("retrive customerList");
		for(Customer customer:customerList){
			String LDCDesc=customer.getLDCDesc();
			//String LDC=customer.getLDC();
			//System.out.println(LDC);
			System.out.println(LDCDesc);
			List<Product> productList =customer.getProduct();
			for(Product product:productList){
				String productDesc=product.getProductCode();
				System.out.println(productDesc);
			}
		}
	}

}
