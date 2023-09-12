<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
    <form:form modelAttribute="loginCommand">
    <form:errors />
    <p>
        <label><spring:message code="snum" />:<br>
        <form:input path="snum" />
        <form:errors path="snum"/>
        </label>
    </p>
    <p>
        <label><spring:message code="password" />:<br>
        <form:password path="password" />
        <form:errors path="password"/>
        </label>
    </p>
    <p>
        <label><spring:message code="rememberSnum" />:
        <form:checkbox path="rememberSnum"/> 
        </label>
    </p>
    <input type="submit" value="<spring:message code="login.btn" />">
    <a href="register/step1">회원가입</a>
    
    </form:form>
</body>
</html>
