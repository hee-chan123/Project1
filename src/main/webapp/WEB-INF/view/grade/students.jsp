<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="myclass" /></title>
</head>
<body>
<table width="200" cellpadding="0" cellspacing="0" border="1">
    <tr>
        <td><spring:message code="classname" /></td>
    <tr>
    <c:forEach items="${list}" var="dto">
    <tr>
        <td><a href="studentsview?subnum=${dto.subnum}">${dto.subname}</a></td>
    <tr>
    </c:forEach>
</table>
</body>
</html>