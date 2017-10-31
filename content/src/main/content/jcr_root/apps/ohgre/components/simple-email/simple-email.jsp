<%@include file="/libs/foundation/global.jsp"%>
<%@page import="com.adobe.acs.commons.email.EmailService, java.util.*"%><%

// Get the OSGi Email Service
EmailService emailService = sling.getService(EmailService.class);

// Specify the template file to use (this is an absolute path in the JCR)
String templatePath = "/etc/notification/email/en.html";

//Set the dynamic vaiables of your email template
Map<String, String> emailParams = new HashMap<String,String>();
emailParams.put("message","hello there");

//  Customize the sender email address - if required
emailParams.put("senderEmailAddress","abcd@example.com");
emailParams.put("senderName","OH-GRE");
emailParams.put("recipientName","Avinash");

// Array of email recipients
String[] recipients = { "avinash.dhannuri@macquarium.com" }; //you will want to change this to your email address so you can recieve the email

// emailService.sendEmail(..) returns a list of all the recipients that could not be sent the email
// An empty list indicates 100% success
List<String> failureList = emailService.sendEmail(templatePath, emailParams, recipients);

if (failureList.isEmpty()) {
	out.println("Email sent successfully to the recipients");
} else {
	out.println("Email sent failed");
}
%>