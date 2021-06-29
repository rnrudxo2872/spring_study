<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form action="" method="post">
<input type="hidden" name="msg" value="1234">
	아이디 : <input type="text" name="userid"><br>
	비밀번호 : <input type="password" name="userpw"><br>
	이름 : <input type="text" name="username"><br>
	이메일 : <input type="text" name="useremail"><br>
	<hr>
	<input type="submit" value="회원가입">
</form>
</body>
</html>
