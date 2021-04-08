<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 리스트</title>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	.dataRow:hover{
		background: #ddd;
		cursor: pointer;
	}
</style>

<script type="text/javascript">
	$(function(){
		$(".dataRow").click(function(){
			var no = $(this).find(".no").text();
			location = "view.do?no=" + no + "&inc=1"
					+ "&page=${pageObject.page}"
					+ "&perPageNum=${pageObject.perPageNum}"
					+ "&key=${pageObject.key}"
					+ "&word=${pageObject.word}";
		});
	});
</script>

</head>
<body>
<div class="container">
<h2>게시판 리스트</h2>
<div>
	<form class="navbar-form">
		<div class="input-group">
			<div class="form-group navbar-left">
				<select name="key" class="form-control">
					<option value="t" ${(pageObject.key == "t")? "selected":"" }
					>제목</option>
					<option value="c" ${(pageObject.key == "c")? "selected":"" }
					>내용</option>
					<option value="w" ${(pageObject.key == "w")? "selected":"" }
					>작성자</option>
					<option value="tc" ${(pageObject.key == "tc")? "selected":"" }
					>제목/내용</option>
					<option value="tw" ${(pageObject.key == "tw")? "selected":"" }
					>제목/작성자</option>
					<option value="cw" ${(pageObject.key == "cw")? "selected":"" }
					>내용/작성자</option>
					<option value="tcw" ${(pageObject.key == "tcw")? "selected":"" }
					>전체</option>
				</select>
		       <input type="text" class="form-control" placeholder="Search" name="word" value="${pageObject.word}">
	       </div>
		   <div class="input-group-btn">
		      <button class="btn btn-default" type="submit">
      	 	 	 <i class="glyphicon glyphicon-search"></i>
      		  </button>
    	   </div>
	    </div>
	</form>
</div>

<table class="table">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>별명</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<c:if test="${empty list}">
		<tr><td colspan="5">데이터가 존재하지 않습니다.</td></tr>
	</c:if>
	<c:if test="${!empty list}">
	<c:forEach items="${list}" var="vo">
		<tr class="dataRow">
			<td class="no">${vo.no}</td>
			<td >${vo.title}</td>
			<td >${vo.writer}</td>
			<td >
				<fmt:formatDate value="${vo.writeDate}"
				pattern="yyyy.MM.dd"/> </td>
			<td >${vo.hit}</td>
		</tr>
	</c:forEach>
	</c:if>
	<tr>
		<td colspan="5">
			<pageObject:pageNav pageObject="${pageObject }" listURI="list.do" />
		</td>
	</tr>
		<tr>
		<td colspan="5">
			<a href="write.do" class="btn btn-default">글쓰기</a>
		</td>
	</tr>
</table>

</div>
</body>
</html>