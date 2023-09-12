<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="classsubject" /></title>
</head>
<body>
<table width="200" cellpadding="0" cellspacing="0" border="1">
    <tr>
        <td><spring:message code="cnum" /></td>
        <td><spring:message code="name" /></td>
    <tr>
    <c:forEach items="${list}" var="dto">
    <tr>
    <td>${dto.snum}</td>
        <td><a href="studentupdate?snum=${dto.snum}">${dto.sname}</a></td>
    <tr>
    </c:forEach>
</table>
</body>
</html>