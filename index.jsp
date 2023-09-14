<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<style>
    * {
        text-decoration: none;
        margin : 0;
        padding : 0;
    }
    h1, div {
        text-align: center;
    }
    #center {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
    button {
        padding: 10px 20px;
        font-size: 16px;
        background-color: #007bff;
        color: #fff;
        border: none;
        cursor: pointer;
        margin: 10px;
    }

    button:hover {
        background-color: #0056b3;
    }
</style>
<head>
    <title>민수대학교 포털</title>
</head>
<body>
<div id="center">
    <a href="#"><img src="/image/logo.png" /></a>
    <div>
        <button type="button" onclick="location.href='login' ">학생 로그인</button>
        <button type="button" onclick="location.href='loginP' ">교수 로그인</button>
    </div>
</div>
</body>
</html>

