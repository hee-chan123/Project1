<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 보기</title>
</head>
<body>
<a href="/">메인으로</a>
<a href="/notice">목록으로</a>

<h1>공지사항 상세 내용</h1>
<table border="1">
	<tr>
		<th>ID</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
	</tr>
	<tr>
		<td>${notice.id}</td>
		<td>${notice.title}</td>
		<td>${notice.author}</td>
		<td>${notice.date}</td>
	</tr>
</table>
<div>
	<h2>내용</h2>
	<p>${notice.content}</p>
</div>
<a href="/notice/delete/${notice.id}">삭제하기</a>
<a href="/notice/update/${notice.id}">수정하기</a>
</body>
</html>