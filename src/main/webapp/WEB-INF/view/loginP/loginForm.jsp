<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
    <form:form modelAttribute="pLoginCommand">
    <form:errors />
    <p>
        <label><spring:message code="pnum" />:<br>
        <form:input path="pnum" />
        <form:errors path="pnum"/>
        </label>
    </p>
    <p>
        <label><spring:message code="password" />:<br>
        <form:password path="password" />
        <form:errors path="password"/>
        </label>
    </p>
    <p>
        <label><spring:message code="rememberPnum" />:
        <form:checkbox path="rememberPnum"/> 
        </label>
    </p>
    <input type="submit" value="<spring:message code="login.btn" />">
  
    
    </form:form>
</body>
</html>
