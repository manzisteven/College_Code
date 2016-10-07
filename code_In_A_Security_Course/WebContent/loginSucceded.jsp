<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//allow access only if session exists
String user = null;
if(session.getAttribute("user") == null){
    response.sendRedirect("Login.html");
}else user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userName = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}

else{
    sessionID = session.getId();
}
%>
<h3>Hi <%=user %>, Login successful. Your Session ID=<%=sessionID %></h3>
<h3>Your session is expiring in<%=session.getMaxInactiveInterval() %> s</h3>


<a href="<%=response.encodeURL("CheckSession.jsp") %>">Check session status</a>
<a href="<%=response.encodeURL("data1.html") %>">Access a guest book</a>
<br>
</body>
</html>