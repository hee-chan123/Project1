<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="Edit" /></title>
</head>
<body>
<c:if test="${!dis}">
<form action="updatepage">
<table width="500" cellpadding="0" cellspacing="0" border="0">
<tr><td><spring:message code="name" /> :</td><td><input type="text" name="pname" value="${dto.pname}"></td></tr>
<tr><td><spring:message code="addr" /> :</td><td><input type="text" name="addr" value="${dto.addr}"> </td></tr>
<tr><td><spring:message code="phone" /> :</td><td><input type="text" name="phone" value="${dto.phone}"></td></tr>
<tr><td><spring:message code="email" /> :</td><td><input type="text" name="email" value="${dto.email}"></td></tr>
<tr><td><spring:message code="major" /> :</td><td><input type="text" name="major" value="${dto.major}"></td></tr>
</table>
<input type="submit" value="<spring:message code="Editpersonalinformation"/>">
</form>
</c:if>
<c:if test="${dis}">
<form action="updatepage">
<table width="500" cellpadding="0" cellspacing="0" border="0">
<tr><td><spring:message code="name" /> :</td><td><input type="text" name="sname" value="${dto.sname}"></td></tr>
<tr><td><spring:message code="addr" /> :</td><td><input type="text" name="addr" value="${dto.addr}"> </td></tr>
<tr><td><spring:message code="phone" /> :</td><td><input type="text" name="phone" value="${dto.phone}"></td></tr>
<tr><td><spring:message code="email" /> :</td><td><input type="text" name="email" value="${dto.email}"></td></tr>
<tr><td><spring:message code="class" /> :</td><td><input type="text" name="grade" value="${dto.grade}"></td></tr>
<tr><td><spring:message code="status" /> :</td><td><input type="text" name="status" value="${dto.status}"></td></tr>
<tr><td><spring:message code="major" /> :</td><td><input type="text" name="major" value="${dto.major}"></td></tr>
</table>
<input type="submit" value="<spring:message code="Editpersonalinformation"/>">
</form>
</c:if>
</body>
</html>