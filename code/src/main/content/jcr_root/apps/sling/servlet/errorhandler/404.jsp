ong-faq-page.html<%@ page session="false" %><%
%><%@ page import="
    java.net.URLEncoder,
    com.day.cq.wcm.api.WCMMode" %><%!
    //declaration of any methods goes here
%><%

    // get here if authentication should not take place or if
    // no Authenticator service is available or if no
    // AuthenticationHandler is willing to authenticate
    // So we fall back to plain old 404/NOT FOUND    
         String domainName=request.getServerName();
if(domainName.indexOf("ong")!=0){
        response.sendRedirect("/content/onlyong/404.html");
}else if(domainName.indexOf("grandrapidsenergy")!=0){
		response.sendRedirect("/content/gre/404.html");
}else{
		response.sendRedirect("/content/onlyong/404.html");
}

%>