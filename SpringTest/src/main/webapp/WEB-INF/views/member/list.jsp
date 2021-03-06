<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<%@include file="../partials/head.jsp"%>
<body>
<h1>Views/member/list.jsp</h1>
<h2>회원목록을 확인(관리자) (Spring)</h2>

<table>
<tr>
<th>아이디</th>
<th>비밀번호</th>
<th>이름</th>
<th>이메일</th>
<th>가입일</th>
<th>수정일</th>
</tr>

<c:forEach var="vo" items="${memberList }">
	<tr>
		<td>${vo.userid }</td>
		<td>${vo.userpw }</td>
		<td>${vo.username }</td>
		<td>${vo.useremail }</td>
		<td>${vo.regdate }</td>
		<td>${vo.updatedate }</td>
	</tr>
</c:forEach>
</table>
<button onclick="location.href='./main'">메인페이지</button>
</body>
</html>