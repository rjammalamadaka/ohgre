package com.macquarium.ong;

import java.util.HashMap;

public interface SendEmailService {
	public boolean sendEmail(HashMap<String,String> mailContent);
	public boolean sendExceptionEmail(HashMap<String,String> mailContent);
}
