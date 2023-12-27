<%-- JSP Directive --%>
<%@ page import="com.education.ztu.User, java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
</head>
<body>

<%-- JSP Declaration --%>
<%!
    private java.util.Date today = new java.util.Date();
%>

<%-- JSP Scriplet --%>
<%
    User user = (User) request.getAttribute("user");
%>

<h2>Profile - <%= today %></h2>
<%-- JSP Expression --%>
<p>Welcome, <%= user.getUsername() %>!</p>
<p>Your password: ${user.getPassword()}</p>
<a href="./logout">Logout</a>

</body>
</html>
