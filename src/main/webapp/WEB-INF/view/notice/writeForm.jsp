<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 등록</title>
</head>
<body>
<h1>공지사항 등록 페이지</h1>
<form action="/notice/write" method="post">
	<label for="title">제목 : </label>
	<input type="text" id="title" name="title" required><br>
	<label for="author">작성자 : </label>
	<input type="text" id="author" name="author" required><br>
	<label for="content">내용 : </label>
	<textarea id="content" name="content" rows="4" cols="50" required></textarea><br>
	<input type="submit" value="글쓰기">
</form>
</body>
</html>