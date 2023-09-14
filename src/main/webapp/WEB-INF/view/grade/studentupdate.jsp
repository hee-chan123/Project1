<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="Edit" /></title>
    <style>
      div {
        text-align: center;
    }
    
	.tbl_type{border-bottom:2px solid #ccc;font-size:12px;text-align:center;border-collapse:collapse}
	.tbl_type td{padding:6px 0 4px;border:1px solid #e5e5e5;color:#4c4c4c}
    
  .custom-btn {
  color: #fff;
  border-radius: 5px;
  padding: 8px 25px;
  display: inline-block;
   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  outline: none;
    width: 150px;
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
  width: 150px;
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
<form action="update">
<table class="tbl_type" width="500" cellpadding="0" cellspacing="0" border="0"style="border:1px solid black;margin-left:auto;margin-right:auto;">
<tr><td><spring:message code="name" /> :</td><td>${dto.sname}</td></tr>
<tr><td><spring:message code="midtermgrade" /></td><td><input type="text" name="midtermGrade" value="${dto.midtermGrade}"> </td></tr>
<tr><td><spring:message code="finalgrade" /></td><td><input type="text" name="finalGrade" value="${dto.finalGrade}"></td></tr>
<tr><td><spring:message code="attendancedate" /></td><td><input type="text" name="attendanceDate" value="${dto.attendanceDate}"></td></tr>
<tr><td><spring:message code="grade" /></td><td><input type="text" name="grade" value="${dto.grade}"></td></tr>
<input type="hidden" name="snum" value="${dto.snum}">

</table>
<div>
<input class="custom-btn btn-1" type="submit" value="<spring:message code="Edit" />"><br>
</form>
      <button type="button"  class="custom-btn1 btn-2" onclick="location.href='studentsview' ">뒤로가기</button>
</div>
</body>
</html>