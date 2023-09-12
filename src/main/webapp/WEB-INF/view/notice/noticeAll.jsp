<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
</head>
<body>
<a href="/main">메인으로</a>
<h1>공지사항 목록</h1>
<%int num=1; %>
<table border="1">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
	</tr>
	<c:forEach items="${noticeAll}" var="notice">
		<tr>
			<td><%=num++ %></td>
			<td><a href="/notice/${notice.id}">${notice.title}</a></td>
			<td>${notice.author}</td>
			<td>${notice.date}</td>
			<td><a href="/notice/delete/${notice.id}">삭제하기</a></td>
		</tr>
	</c:forEach>
</table>
<a href="/notice/write">글쓰기</a>
</body>
</html>