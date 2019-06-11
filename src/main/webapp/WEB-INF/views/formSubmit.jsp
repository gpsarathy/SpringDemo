<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.greeny
{
color:green;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>All bind error</p>
<form:form modelAttribute="bindingObject" action="form-data-test" method="POST">
      <table>
          <tr>
              <td>First Name:</td>
              <td><form:input path="id" /></td>
              
          </tr>
          <tr>
              <td>Last Name:</td>
              <td><form:input path="name" type="text"/></td>
              <td>
              <div><form:errors path="name" cssClass="greeny" element="div"/></div><form:errors path="name" cssStyle="color : red;" element="div"/>
              </td>
          </tr>
          <tr>
              <td colspan="2">
                  <input type="submit" value="Save Changes" />
              </td>
          </tr>
      </table>
      <div>outer div
      <form:errors path="name" cssStyle="color : red;" element="div"/></div>
  </form:form>
</body>
</html>