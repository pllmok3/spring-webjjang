<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 글보기</title>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>



</head>
<body>
<div class="container">
<h2>게시판 글보기</h2>
<% String userId =(String)session.getAttribute("userId"); %>

<input type="hidden" value="${vo.userId}">

<table class="table">
	<tr>
		<th>번호</th>
		<td>${vo.no}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${vo.title}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><pre style="border:none;">${vo.content}</pre></td>
	</tr>
	<tr>
		<th>별명</th>
		<td>${vo.writer}</td>
	</tr>
	<tr>
		<th>작일성</th>
		<td><fmt:formatDate value="${vo.writeDate}"
		pattern="yyyy.MM.dd"/></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${vo.hit}</td>
	</tr>
	<tr>
		<td colspan="2">
		
		
		<c:choose>
			<c:when test="${vo.userId eq userId}">
				<a href="update.do?no=${vo.no}&inc=0&page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}"
					class="btn btn-default">수정</a>
			
				<a href="delete.do?no=${vo.no}"
				class="btn btn-default">삭제</a>
			</c:when>
		</c:choose>

			<a href="list.do?page=${param.page}&perPageNum=${param.perPageNum}&key=${param.key}&word=${param.word}"
			class="btn btn-default">리스트</a>
			
				
		</td>
	</tr>

</table>

</div>
</body>
</html>