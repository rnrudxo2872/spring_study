<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../partials/head.jsp"%>
<body>
<header><h1>회원정보</h1></header>
<main>

<%
//model("infoVO")
%>

<table border="1">
<tr>
<th>아이디</th>
<td>${infoVO.userid }</td>
</tr>

<tr>
<th>비밀번호</th>
<td>${infoVO.userpw }</td>
</tr>

<tr>
<th>이름</th>
<td>${infoVO.username }</td>
</tr>

<tr>
<th>이메일</th>
<td>${infoVO.useremail }</td>
</tr>

<tr>
<th>가입날짜</th>
<td>${infoVO.regdate }</td>
</tr>

<tr>
<th>정보수정 날짜</th>
<td>${infoVO.updatedate }</td>
</tr>

</table>
<h2><a href="main">메인페이지로 이동</a></h2>
</main>
</body>
</html>