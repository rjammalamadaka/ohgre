package com.macquarium.ong;

import java.util.ArrayList;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.macquarium.ong.SendEmailService;

@Component(immediate=true, metatype=true, name="OHGRE SMTP Configuration", label="OHGRE SMTP Configuration Service")
@Service(value=SendEmailService.class)
@Properties({
		@Property(name="service.description", value="OHGRE SMTP Configuration Service"),
		@Property(name="service.vendor", value="Reply")
})
public class SendEmailServiceImpl implements SendEmailService {

	@Reference
	private MessageGatewayService messageGatewayService;

	public boolean sendEmail(CommonConfigService commonConfigService, String soapRequest, String soapResponse) {
		ArrayList<InternetAddress> emailRecipients = new ArrayList<InternetAddress>();
		HtmlEmail email = new HtmlEmail();
		String mailBody = "Soap Request:  "+soapRequest +"**************** Soap Response: " +soapResponse;

		System.out.println("Mail Body :" +mailBody);
		try{
			emailRecipients.add(new InternetAddress(commonConfigService.getToMailAddress()));
			email.setCharset("UTF-8");
			email.setTo(emailRecipients);
			email.setSubject("Mail Subject");
			email.setHtmlMsg(mailBody);
			MessageGateway<HtmlEmail> messageGateway = this.messageGatewayService.getGateway(HtmlEmail.class);
			messageGateway.send(email);
			emailRecipients.clear();
		}catch(EmailException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
