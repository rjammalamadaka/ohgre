package com.macquarium.ong;

public interface SendEmailService {
	public boolean sendEmail(CommonConfigService commonConfigService, String soapRequest, String soapResponse);
}
