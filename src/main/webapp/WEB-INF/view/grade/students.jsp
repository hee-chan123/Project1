<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="myclass" /></title>
<style>
    div {
        text-align: center;
    }
    
	.tbl_type{border-bottom:2px solid #ccc;font-size:12px;text-align:center;border-collapse:collapse}
	.tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}
	
	    .custom-btn1 {
  border-radius: 5px;
  padding: 8px 25px;
  display: inline-block;
   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  outline: none;
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
<table class="tbl_type" width="200" cellpadding="0" cellspacing="0" border="1"style="border:1px solid black;margin-left:auto;margin-right:auto;">
    <tr>
        <td><spring:message code="classname" /></td>
    <tr>
    <c:forEach items="${list}" var="dto">
    <tr>
        <td><a href="studentsview?subnum=${dto.subnum}">${dto.subname}</a></td>
    <tr>
    </c:forEach>
</table>
<p>



</p>
<button type="button"  class="custom-btn1 btn-2" onclick="location.href='mypage/mypage' ">마이페이지 이동</button>
</div>
</body>
</html>