<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>
<h1>공지사항 수정 페이지</h1>
<form action="/notice/update/${notice.id}" method="post">
	<label for="title">제목 : </label>
	<input type="text" id="title" name="title" value="${notice.title}" required><br>
	<label for="author">작성자 : </label>
	<input type="text" id="author" name="author" value="${notice.author}" required><br>
	<label for="content">내용 : </label>
	<textarea id="content" name="content" rows="4" cols="50" required>${notice.content}</textarea><br>
	<input type="submit" value="수정하기">
</form>
</body>
</html>