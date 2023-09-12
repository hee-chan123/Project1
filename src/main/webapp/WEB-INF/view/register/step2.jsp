<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="student.register" /></title>
</head>
<body>
    <h2><spring:message code="student.info" /></h2>
    <form:form action="step3" modelAttribute="registerRequest">
    <p>
        <label><spring:message code="snum" />:<br>
        <form:input path="snum" />
        <form:errors path="snum"/>
        </label>
    </p>
    <p>
        <label><spring:message code="sname" />:<br>
        <form:input path="sname" />
        <form:errors path="sname"/>
        </label>
    </p>
    <p>
        <label><spring:message code="password" />:<br>
        <form:password path="password" />
        <form:errors path="password"/>
        </label>
    </p>
    <p>
        <label><spring:message code="confirmPassword" />:<br>
        <form:password path="confirmPassword" />
        <form:errors path="confirmPassword"/>
        </label>
    </p>
    <P>
    <label for="major">학과명:</label>
        <select id="major" name="major">
            <option value="경영학과">경영학과</option>
            <option value="행정학과">행정학과</option>
            <option value="컴퓨터공학과">컴퓨터공학과</option>
            <option value="화학과">화학과</option>
            <option value="물리학과">물리학과</option>
            <option value="경제학과">경제학과</option>
            <option value="국제통상학과">국제통상학과</option>
            <option value="영어학과">영어학과</option>
            <option value="독어학과">독어학과</option>
            </select>
            </P>
 		 <P>
    <label for="grade">학년:</label>
    <select id="grade" name="grade">
    <option value="1학년">1학년</option>
     <option value="2학년">2학년</option>
     <option value="3학년">3학년</option>
     <option value="4학년">4학년</option>
     
      </select>
            </P>
       <p>
        <label><spring:message code="addr" />:<br>
        <form:input path="addr" />
        <form:errors path="addr"/>
        </label>
    </p> 
     <p>
        <label><spring:message code="phone" />:<br>
        <form:input path="phone" />
        <form:errors path="phone"/>
        </label>
    </p> 
         <p>
        <label><spring:message code="email" />:<br>
        <form:input path="email" />
        <form:errors path="email"/>
        </label>
    </p> 
    
    
    
    <P>
    <label for="status">재학상태:</label>
    <select id="status" name="status">
    <option value="재학">재학</option>
     <option value="휴학">휴학</option>
      </select>
            </P>
    
            
                  
    <input type="submit" value="<spring:message code="register.btn" />">
    </form:form>
</body>
</html>
