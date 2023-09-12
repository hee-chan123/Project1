<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="confirmpassword" /></title>
</head>
<body>
<spring:message code="confirmpassword.in1" /><br/>
<spring:message code="confirmpassword.in2" />
<form method="post">
<input type="text" name="confirmpassword">
${error}<br/>
<input type="submit" value="<spring:message code="confirmpassword" />">
</form>



</body>
</html>