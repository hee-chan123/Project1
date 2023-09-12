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
<th>교수이름</th>
<th>과목이름</th>
<th>점수(중간)</th>
<th>점수(기말)</th>
<th>출석률</th>
<th>학점</th>
</tr>
<c:forEach var="grade" items="${grades}" varStatus="status">
<tr>
<td>${grade.year} 년도</td>
<td>${grade.term} 학기</td>
<td>${names[status.index].pname}</td>
<td>${names[status.index].subname}</td>
<td>${grade.midtermGrade} 점</td>
<td>${grade.finalGrade} 점</td>
<td>${grade.attendanceDate} %</td>
<td>${grade.grade}</td>
</tr>
</c:forEach>
</table>
</body>
</html>