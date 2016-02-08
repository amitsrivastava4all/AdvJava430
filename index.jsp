<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String userid = request.getParameter("userid");
    String pwd = request.getParameter("pwd");
    if(userid!=null && pwd!=null){
    	if(userid.trim().length()>0 && pwd.trim().length()>0){
    if(userid.equals(pwd)){
%>
	<h1>Welcome <%=userid %></h1>
<%
    }
    else{
%>
<h1>Invalid Userid and Password</h1>
<%
    }
    }
    }
%>
<form action="index.jsp" method="post">

Login Page <br>
<input type="text" name="userid" placeholder="Type Userid here"/>
<input type="text" name="pwd" placeholder="Type Password here"/>
<input type="submit" value="Login"/>
</form>
</body>
</html>