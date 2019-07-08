<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>App Home</title>
</head>
<body>
Hello home page
<p>
<spring:message code="home.welcome"/>
</p>
<div>And you are from <p>
<spring:message code="home.region"/>
</p></div>
</html>