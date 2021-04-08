<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 페이지</title>
</head>
<body>
	<form method="post">
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
			<td><input type="submit" value="로그인"></td>
			<td><input type="button" value="회원가입" onclick="location.href='gaip.do'"></td>
		</tr>		
	</table>
	</form>
</body>
</html>