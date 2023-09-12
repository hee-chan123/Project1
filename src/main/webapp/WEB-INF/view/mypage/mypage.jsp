<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="user.info" /></title>
</head>
<body>
<c:if test="${!Distinction}">
<table width="500" cellpadding="0" cellspacing="0" border="1">
    <tr>

        <td><spring:message code="name" /></td>
        <td><spring:message code="addr" /></td>
        <td><spring:message code="phone" /></td>
        <td><spring:message code="email" /></td>
        <td><spring:message code="major" /></td>
    <tr>
    <tr>

        <td>${dto.pname}</td>
        <td>${dto.addr}</td>
        <td>${dto.phone}</td>
        <td>${dto.email}</td>
        <td>${dto.major}</td>
    <tr>
 
</table>
<a href="<c:url value="/modified" />"><spring:message code="subject.check" /></a>
</c:if>
<c:if test="${Distinction}">
<table width="500" cellpadding="0" cellspacing="0" border="1">
    <tr>

        <td><spring:message code="name" /></td>
        <td><spring:message code="addr" /></td>
        <td><spring:message code="phone" /></td>
        <td><spring:message code="email" /></td>
        <td><spring:message code="class" /></td>
         <td><spring:message code="status" /></td>
        <td><spring:message code="major" /></td>
    <tr>
    <tr>

        <td>${dto.sname}</td>
        <td>${dto.addr}</td>
        <td>${dto.phone}</td>
        <td>${dto.email}</td>
        <td>${dto.grade}</td>
        <td>${dto.status}</td>
        <td>${dto.major}</td>
    <tr>
 
</table>
</c:if>
<form action="confirmpassword">
<input type="submit" value="<spring:message code="Editpersonalinformation"/>">
</form>
</body>
</html>
