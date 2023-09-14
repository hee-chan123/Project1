<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="user.info" /></title>
    <style>
	.tbl_type{border-bottom:2px solid #ccc;font-size:12px;text-align:center;border-collapse:collapse}
	.tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}

    div {
        text-align: center;
    }
    .custom-btn {
  color: #fff;
  border-radius: 5px;
  padding: 8px 25px;
  display: inline-block;
   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  outline: none;
    width: 180px;
  height: 40px;
}

.btn-1 {
  background: rgb(6,14,131);
  background: linear-gradient(0deg, rgba(6,14,131,1) 0%, rgba(12,25,180,1) 100%);
  border: none;
}

.btn-1:hover {
   background: rgb(0,3,255);
background: linear-gradient(0deg, rgba(0,3,255,1) 0%, rgba(2,126,251,1) 100%);
}

    .custom-btn1 {
  border-radius: 5px;
  padding: 8px 25px;
  display: inline-block;
   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  outline: none;
    width: 180px;
  height: 40px;
}

.btn-2 {
  border: none;
}

.btn-2:hover {
 background: rgb(150,150,150);
}
    </style>
</head>
<body>
 <div>
			<img src="/img/jms.png" style="width:400px; height:400px; ">
</div>
<c:if test="${!Distinction}">

<table width="500" cellpadding="0" cellspacing="0" border="0" class="tbl_type" style="border:1px solid black;margin-left:auto;margin-right:auto;">
    	<tr>
        <td><spring:message code="name" /></td><td>${dto.pname}</td>
        <tr>
    	<tr>
        <td><spring:message code="addr" /></td><td>${dto.addr}</td>
        <tr>
   		<tr>
        <td><spring:message code="phone" /></td><td>${dto.phone}</td>
        <tr>
   		<tr>
        <td><spring:message code="email" /></td><td>${dto.email}</td>
        <tr>
   		<tr>
        <td><spring:message code="major" /></td><td>${dto.major}</td>
   		 <tr>
 
</table>
<div>
<button type="button"  class="custom-btn btn-1" onclick="location.href='/modified' "><spring:message code="subject.check"/></button>
</div>
</c:if>
<c:if test="${Distinction}">
<table width="500" cellpadding="0" cellspacing="0" border="0" class="tbl_type" style="border:1px solid black;margin-left:auto;margin-right:auto;">
    <tr>

        <td><spring:message code="name" /></td><td>${dto.sname}</td>
        <tr>
   		<tr>
        <td><spring:message code="addr" /></td><td>${dto.addr}</td>
        <tr>
   		<tr>
        <td><spring:message code="phone" /></td><td>${dto.phone}</td>
        <tr>
   		<tr>
        <td><spring:message code="email" /></td><td>${dto.email}</td>
        <tr>
   		<tr>
        <td><spring:message code="class" /></td><td>${dto.grade}</td>
        <tr>
   		<tr>
        <td><spring:message code="status" /></td><td>${dto.status}</td>
        <tr>
   		<tr>
        <td><spring:message code="major" /></td><td>${dto.major}</td>
    	<tr>
    	<tr>
    	
</table>

</c:if>
<div>
<button type="button"  class="custom-btn btn-1" onclick="location.href='confirmpassword' "><spring:message code="Editpersonalinformation"/></button><br>
<button type="button"  class="custom-btn1 btn-2" onclick="location.href='/index2' "><spring:message code="go.main"/></button>
</div>
</body>
</html>
