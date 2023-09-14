<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점조회</title>
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
}

section.grade {
	padding: 20px 0;
}

.img {
	text-align: center;
}

.page-title {
	margin-bottom: 60px;
}

.page-title h3 {
	font-size: 28px;
	color: #333333;
	font-weight: 400;
	text-align: center;
}

.sname {
	text-align: right;
}

.grade-table {
	font-size: 13px;
	width: 100%;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

.grade-table a {
	color: #333;
	display: inline-block;
	line-height: 5;
	word-break: break-all;
	vertical-align: middle;
}

.grade-table a:hover {
	text-decoration: underline;
}

.grade-table th {
	text-align: center;
}

.grade-table .th-year {
	width: 100px;
}

.grade-table .th-term {
	width: 100px;
}

.grade-table .th-sub {
	width: 100px;
}

.grade-table .th-sumCredit {
	width: 100px;
}

.grade-table .th-getCredit {
	width: 100px;
}

.grade-table .th-grade {
	width: 100px;
}

.grade-table th, .grade-table td {
	padding: 15px 0;
}

.grade-table tbody td {
	border-top: 1px solid #e7e7e7;
	text-align: center;
}

.grade-table tbody th {
	padding-left: 28px;
	padding-right: 14px;
	border-top: 1px solid #e7e7e7;
	text-align: left;
}

.grade-table tbody th p {
	display: none;
}

.grade-table .main {
	text-align: right;
}

/* reset */
* {
	list-style: none;
	text-decoration: none;
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

.container {
	width: 1500px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<section class="grade">
	<img class="img" src="/images/t1.png" >
		<div class="page-title">
			<div class="container">
				<h3>성적조회</h3>
			</div>
		</div>
		<div id="grade-list">
			<div class="container">
				<table class="grade-table">
				<div class="sname" >[${student.sname}][${student.status}][${student.major}]</div>
					<thead>
						<tr>
							<th scope="col" class="th-year">연도</th>
							<th scope="col" class="th-term">학기</th>
							<th scope="col" class="th-sub">신청과목수</th>
							<th scope="col" class="th-sumCredit">신청학점</th>
							<th scope="col" class="th-getCredit">취득학점</th>
							<th scope="col" class="th-grade">성적세부조회</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="gradeCommand" items="${gradeCommands}">
							<tr>
								<td>${gradeCommand.year}년도</td>
								<td>${gradeCommand.term}학기</td>
								<td>${gradeCommand.sub}</td>
								<td>${gradeCommand.sumCredit}</td>
								<td>${gradeCommand.getCredit}</td>
								<td><a href="/credit/grade?snum=${snum}&year=${gradeCommand.year}&term=${gradeCommand.term}">이동</a></td>
							</tr>
						</c:forEach>
					</tbody>
					<tr>
						<td scope="col" class="main" colspan="6"><a href="/index2">[메인으로 이동하기]</a></td>
					</tr>
				</table>
			</div>
		</div>

	</section>
</body>
</html>
