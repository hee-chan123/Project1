<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>연도</th>
<th>학기</th>
<th>신청과목수</th>
<th>신청학점</th>
<th>취득학점</th>
<th>성적세부조회</th>
</tr>
<c:forEach var="gradeCommand" items="${gradeCommands}">
<tr>
<td>${gradeCommand.year} 년도</td>
<td>${gradeCommand.term} 학기</td>
<td>${gradeCommand.sub}</td>
<td>${gradeCommand.sumCredit}</td>
<td>${gradeCommand.getCredit}</td>
<td><a href="/credit/grade?snum=${snum}&year=${gradeCommand.year}&term=${gradeCommand.term}" />이동</a></td>
</tr>
</c:forEach>
</table>
</body> 
</html>