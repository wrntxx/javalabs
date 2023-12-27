<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Example</title>
</head>
<body>

<c:set var="isAdmin" value="true" />

<c:choose>
    <c:when test="${isAdmin == true}">
        <h2>Welcome, Admin!</h2>
    </c:when>
    <c:otherwise>
        <h2>Welcome, User!</h2>
    </c:otherwise>
</c:choose>

<p>Loop Example:</p>
<c:forEach begin="0" end="10" var="i">
    Index: ${i}<br/>
</c:forEach>

<p>Conditional Expression Example:</p>
<c:if test="${isAdmin == true}">
    <p>This content is visible to administrators only.</p>
</c:if>

<p>URL Example:</p>
<c:url value="/login" var="loginUrl"/>
<a href="${loginUrl}">Login</a>

<p>Redirect Example:</p>
<form action="" method="post">
    <input type="submit" value="Click to Redirect"/>
</form>

</body>
</html>
