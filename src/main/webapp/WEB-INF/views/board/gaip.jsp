<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입 페이지</title>
</head>

<script type="text/javascript">
	function check(){
		if(document.frm.userId.value==""){
			alert("아이디를 입력하세요.");
			frm.userId.focus();
			return false;			
		}
		if(document.frm.userPw.value==""){
			alert("비밀번호를 입력하세요.");
			frm.userPw.focus();
			return false;			
		}
		return true;
	}
</script>

<body>
<h2>회원가입</h2>
	<form method="post" name="frm">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="userPw"></td>
		</tr>
		<tr>
			<td><input type="submit" value="회원가입" onclick="return check()"></td>
			<td><input type="button" value="취소" onclick="history.back()"></td>
		</tr>		
	</table>
	</form>
</body>
</html>