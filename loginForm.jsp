<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    #center {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height : 100vh;
    }
    .login-form {
        background-color : #ffffff;
        border : 1px solid #ccc;
        border-radius: 5px;
        padding : 20px;
        box-shadow: 0 2px 5px rgba(0,0,0,1);
        text-align: center;
        margin-top : 30px;
    }

    .input-field {
        border : 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
        text-align: center;
    }

    .checkbox-label {
        display : inline-block;
        font-size: 14px;
        margin-left: 5px;
    }

    .submit-button {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        font-size: 16px;
        cursor : pointer;
        margin-top: 10px;
    }
    .submit-button:hover {
        background-color: #0056b3;
    }
    .register-button {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        font-size: 16px;
        cursor: pointer;
        margin-top: 10px;
        text-decoration: none;
        display: inline-block;
    }

    .register-button:hover {
        background-color: #0056b3;
    }
    #grid {
        display : grid;
        grid-template-columns: 70px 1fr;
    }

</style>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
<div id="center">
    <a href="index"><img src="image/logo.png"></a>
    <form:form modelAttribute="pLoginCommand" class="login-form">
    <form:errors />
        <div id="grid">
            <div>
                <label><spring:message code="pnum" /></label>
            </div>
            <div>
                <form:input path="pnum" id="snum" class="input-field" />
            </div>
        </div>
        <form:errors path="pnum" style="margin-left:25px"/>
        <div id="grid">
            <div>
                <label><spring:message code="password" /></label>
            </div>
            <div>
                <form:password path="password" id="password" class="input-field" />
            </div>
        </div>
        <form:errors path="password" style="margin-left:25px"/>
        <p>
            <input type="checkbox" id="rememberPnum" name="rememberPnum" class="input-field"/>
            <label class="checkbox-label" for="rememberPnum"><spring:message code="rememberPnum" /></label>
        </p>
    <input type="submit" value="<spring:message code="login.btn" />" class="submit-button">
    </form:form>
</div>
</body>
</html>
