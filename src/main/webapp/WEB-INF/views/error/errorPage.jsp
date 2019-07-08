<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>	
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<h1>Oops you've ran into a problem</h1>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isErrorPage="true"%>
<h1>Error Page</h1>
URL: ${url}
<BR />
Exception: ${ex.message}
<!-- 
<c:forEach items="${ex.stackTrace}"
var="exceptionStackTrace">
${exceptionStackTrace}
</c:forEach>
 -->
</body>
</html>