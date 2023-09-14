<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <style>
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
    
<title><spring:message code="confirmpassword" /></title>
</head>
<body>
 <div>
	<img src="/image/logo.png" style="width:400px; height:400px; "><br/>
<spring:message code="confirmpassword.in1" /><br/>
<spring:message code="confirmpassword.in2" />

<form method="post">
<input type="text" name="confirmpassword"><br/>
${error}<br/>
<input type="submit" class="custom-btn btn-1" value="<spring:message code="confirmpassword" />">
</form>
</div>


</body>
</html>