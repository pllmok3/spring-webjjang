<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 글수정</title>

 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- <script type="text/javascript">
	function check(){
		if(document.frm.pw.value==""){
			alert("비밀번호를 입력하세요.")
			document.frm.pw.focus();
			return false;
		}else{
			return true;
		}
		
	}
</script> -->

</head>
<body>
<div class="container">
<h2>게시판 글수정</h2>
<form method="post" name="frm">
<!-- 숨겨서 넘길 데이터 : 페이지 관련 데이터들 :Spring param 데이터를 잡아서넘겨주는 것 같다. -->
<%-- 	<input name="page" type="hidden" value="${pram.page}" />
	<input name="perPageNum" type="hidden" value="${pram.perPageNum}" />
	
	<input name="key" type="hidden" value="${pram.key}" />
	<input name="word" type="hidden" value="${pram.word}" />
	 --%>
<table class="table">
	<tr>
		<th>번호</th>
		<td><input name="no" value="${vo.no}" readonly class="form-control"> </td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input name="title" value="${vo.title}" class="form-control"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
		<textarea rows="5" class="form-control" name="content">${vo.content}</textarea>
		</td>
	</tr>
	<tr>
		<th>별명</th>
		<td><input name="writer" value="${vo.writer}" class="form-control"></td>
	</tr>
	<tr>
		<td colspan="2">
			<button class="btn btn-default" onclick="return check()">수정</button>
			<button class="btn btn-default" type="reset">다시입력</button>
			<button class="btn btn-default" type="button" class="cancelBtn"
			onclick="history.back()">취소</button>
		</td>
	</tr>

</table>
</form>

</div>
</body>
</html>