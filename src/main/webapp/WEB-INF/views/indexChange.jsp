<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home for App</title>
</head>
<body>
Hello home page
<p>
<spring:message code="home.welcome"/>
</p>
<div>And you are from <p>
<spring:message code="home.region"/>
</p></div>
</body>
</html>