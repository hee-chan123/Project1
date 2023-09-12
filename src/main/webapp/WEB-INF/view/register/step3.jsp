?<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="student.register" /></title>
</head>
<body>
    <p>
        <spring:message code="register.done">
        <spring:argument value="${registerRequest.sname}" />
        	<spring:argument value="${registerRequest.major}" />
        	<spring:argument value="${registerRequest.snum}" />
        </spring:message>
    </p>
    <p>
        <a href="<c:url value='/'/>"> 
            [<spring:message code="go.main" />]
        </a>
    </p>
</body>
</html>
