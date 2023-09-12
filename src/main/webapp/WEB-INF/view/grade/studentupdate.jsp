<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="Edit" /></title>
</head>
<body>
<form action="update">
<table width="500" cellpadding="0" cellspacing="0" border="0">
<tr><td><spring:message code="name" /> :</td><td>${dto.sname}</td></tr>
<tr><td><spring:message code="midtermgrade" /></td><td><input type="text" name="midtermGrade" value="${dto.midtermGrade}"> </td></tr>
<tr><td><spring:message code="finalgrade" /></td><td><input type="text" name="finalGrade" value="${dto.finalGrade}"></td></tr>
<tr><td><spring:message code="attendancedate" /></td><td><input type="text" name="attendanceDate" value="${dto.attendanceDate}"></td></tr>
<tr><td><spring:message code="grade" /></td><td><input type="text" name="grade" value="${dto.grade}"></td></tr>
<input type="hidden" name="snum" value="${dto.snum}">

</table>
<input type="submit" value="<spring:message code="Edit" />">
</form>
</body>
</html>