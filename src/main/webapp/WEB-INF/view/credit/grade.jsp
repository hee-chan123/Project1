<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세부학점조회</title>
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

.top-menu a {
	text-decoration: none;
	color: gray;
	font-weight: bold;
	font-size: 1.2rem;
}

.row::after {
	content: "";
	display: block;
	clear: both;
}

.cell {
	float: left;
	box-sizing: border-box;
}

.cell-right {
	float: right;
	box-sizing: border-box;
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
	text-align: center;
}

.grade-table .th-term {
	width: 100px;
}

.grade-table .th-pname {
	width: 100px;
}

.grade-table .th-subname {
	width: 100px;
}

.grade-table .th-midtermGrade {
	width: 100px;
}

.grade-table .th-finalGrade {
	width: 100px;
}

.grade-table .th-attendanceDate {
	width: 100px;
}

.grade-table .th-credit {
	width: 100px;
}

.grade-table .th-grade {
	width: 100px;
}

.grade-table th, .grade-table td {
	padding: 15px 0;
}

.grade-table td {
	border-bottom: 15;
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

/* reset */
* {
	list-style: none;
	text-decoration: none;
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

.grade-table .main {
	text-align: right;
}

.container {
	width: 1500px;
	margin: 0 auto;
}

.grade-table .main {
	text-align: right;
}

</style>
</head>
<body>
	<section class="grade">
	<img class="img" src="/images/t1.png" >
		<div class="page-title">
			<div class="container">
				<h3>세부성적조회</h3>
			</div>
		</div>
		<div id="grade-list">
			<div class="container">
				<table class="grade-table">
				<div class="sname" >이름 : [${student.sname}] 상태 : [${student.status}] 전공 : [${student.major}]</div>
					<thead>
						<tr>
							<th scope="col" class="th-year">연도</th>
							<th scope="col" class="th-term">학기</th>
							<th scope="col" class="th-pname">교수이름</th>
							<th scope="col" class="th-subname">과목이름</th>
							<th scope="col" class="th-midtermGrade">점수(중간)</th>
							<th scope="col" class="th-finalGrade">점수(기말)</th>
							<th scope="col" class="th-attendanceDate">출석률</th>
							<th scope="col" class="th-credit">학점</th>
							<th scope="col" class="th-grade">등급</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="grade" items="${grades}" varStatus="status">
							<tr>
								<td>${grade.year} 년도</td>
								<td>${grade.term} 학기</td>
								<td>${names[status.index].pname}</td>
								<td>${names[status.index].subname}</td>
								<td>${grade.midtermGrade} 점</td>
								<td>${grade.finalGrade} 점</td>
								<td>${grade.attendanceDate} %</td>
								<td>${credits[status.index]}</td>
								<td>${grade.grade}</td>
							</tr>
						</c:forEach>
					</tbody>
					<tr>
						<td scope="col" class="main" colspan="9">
						<a href="/credit/sumGrade">[이전으로 이동하기]</a>
						<a href="/index2">[메인으로 이동하기]</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</section>
</body>
</html>
