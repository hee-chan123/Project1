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
    <form:form modelAttribute="loginCommand" class="login-form">
        <form:errors />
        <div id="grid">
            <div>
                <label for="snum"><spring:message code="snum" /></label>
            </div>
            <div>
                <form:input path="snum" id="snum" class="input-field"/>
            </div>
        </div>
        <form:errors path="snum" style="margin-left : 25px"/>
        <div id="grid">
            <div>
                <label for="password"><spring:message code="password" /></label>
            </div>
            <div>
                <form:password path="password" id="password" class="input-field" />
            </div>
        </div>
        <form:errors path="password" style="margin-left : 25px"/>
        <p>
            <input type="checkbox" id="rememberSnum" name="rememberSnum" class="input-field"/>
            <label class="checkbox-label" for="rememberSnum"><spring:message code="rememberSnum" /></label>
        </p>
        <input type="submit" value="<spring:message code="login.btn" />" class="submit-button">
        <a href="register/step1" class="register-button">회원가입</a>
    </form:form>
</div>
</body>
</html>
