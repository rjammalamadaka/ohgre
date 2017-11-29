package com.macquarium.ong.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.macquarium.ong.CommonConfigService;
import com.macquarium.ong.GetQuotesServlets;
import com.macquarium.ong.SendEmailService;

@Component(immediate=true, metatype=true, name="OHGRE SMTP Configuration", label="OHGRE SMTP Configuration Service")
@Service(value=SendEmailService.class)
@Properties({
		@Property(name="service.description", value="OHGRE SMTP Configuration Service"),
		@Property(name="service.vendor", value="Reply")
})
public class SendEmailServiceImpl implements SendEmailService {

	private Logger logger = LoggerFactory.getLogger(SendEmailServiceImpl.class);

	@Reference
	private MessageGatewayService messageGatewayService;

	@Reference
	private CommonConfigService commonConfigService;

	public boolean sendEmail(HashMap<String,String> mailContent) {
		logger.info("--> SendEmailServiceImpl sendEmail -->");
		ArrayList<InternetAddress> emailRecipients = new ArrayList<InternetAddress>();
		HtmlEmail email = new HtmlEmail();
		String request=mailContent.get("request");
		String response=mailContent.get("response");
		String responseMessage=mailContent.get("responseMessage");
		String currentPagePath=mailContent.get("currentPagePath");
		String domain=mailContent.get("siteDomain");
		try{
			logger.info("To Mail Address :"+commonConfigService.getToMailAddress());
			emailRecipients.add(new InternetAddress(commonConfigService.getToMailAddress()));
			email.setCharset("UTF-8");
			email.setTo(emailRecipients);
			email.setSubject("EM WEB: Prime Communications Error -");
			MimeMultipart mimeMultipart=new MimeMultipart();
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setContent("<p> ISSUE : PRIME ERROR </p>", "text/html");
			MimeBodyPart mbp2 = new MimeBodyPart();
			String responseMessage1="<p> Error : "+responseMessage+"</p>";
			mbp2.setContent(responseMessage1, "text/html");
			MimeBodyPart mbp3 = new MimeBodyPart();
			String currentPagePat1="<p> Page : "+currentPagePath+"</p>";
			mbp3.setContent(currentPagePat1, "text/html");
			MimeBodyPart mbp4 = new MimeBodyPart();
			mbp4.setContent("<p><b> Request </b></p>", "text/html");
			MimeBodyPart mbp5 = new MimeBodyPart();
			mbp5.setText(request);
			MimeBodyPart mbp6 = new MimeBodyPart();
			mbp6.setContent("<p><b> Response</b> </p>", "text/html");
			MimeBodyPart mbp7 = new MimeBodyPart();
			mbp7.setText(response);
			mimeMultipart.addBodyPart(mbp1);
			mimeMultipart.addBodyPart(mbp2);
			mimeMultipart.addBodyPart(mbp3);
			mimeMultipart.addBodyPart(mbp4);
			mimeMultipart.addBodyPart(mbp5);
			mimeMultipart.addBodyPart(mbp6);
			mimeMultipart.addBodyPart(mbp7);
			email.setContent(mimeMultipart,"alternative");
			MessageGateway<HtmlEmail> messageGateway = this.messageGatewayService.getGateway(HtmlEmail.class);
			messageGateway.send(email);
			emailRecipients.clear();
			logger.info("<-- SendEmailServiceImpl sendEmail <--");
		}catch(EmailException e){
			logger.info("EmailException :"+e.getMessage());
		} catch (AddressException e) {
			logger.info("AddressException :"+e.getMessage());
		} catch(Exception e) {
			logger.info("Exception :"+e.getMessage());
		}
		return false;
	}

	public boolean sendExceptionEmail(HashMap<String,String> mailContent) {
		logger.info("--> SendEmailServiceImpl sendEmail -->");
		ArrayList<InternetAddress> emailRecipients = new ArrayList<InternetAddress>();
		HtmlEmail email = new HtmlEmail();
		String stackTrace=mailContent.get("stackTrace");

		try{
			logger.info("To Mail Address :"+commonConfigService.getToMailAddress());
			emailRecipients.add(new InternetAddress(commonConfigService.getToMailAddress()));
			email.setCharset("UTF-8");
			email.setTo(emailRecipients);
			email.setSubject("OHGRE Error Print Stact Trace");
			MimeMultipart mimeMultipart=new MimeMultipart();
			MimeBodyPart mbp1 = new MimeBodyPart();
			//mbp1.setContent(stackTrace, "text/html");
			mbp1.setText(stackTrace);
			mimeMultipart.addBodyPart(mbp1);

			email.setContent(mimeMultipart,"alternative");
			MessageGateway<HtmlEmail> messageGateway = this.messageGatewayService.getGateway(HtmlEmail.class);
			messageGateway.send(email);
			emailRecipients.clear();
			logger.info("<-- SendEmailServiceImpl sendEmail <--");
		}catch(EmailException e){
			logger.info("EmailException :"+e.getMessage());
		} catch (AddressException e) {
			logger.info("AddressException :"+e.getMessage());
		} catch(Exception e) {
			logger.info("Exception :"+e.getMessage());
		}
		return false;
	}

}
