<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../partials/head.jsp"%>
<body>
<%if(session.getAttribute("id") == null){
	response.sendRedirect("/web/member/login");
	return;
}
	%>
	
	<main>
		<h1>안녕하세요 <%if(session.getAttribute("id") != null){%><%=session.getAttribute("id")%><%} else{%>게스트<%}%>님</h1>
		<h3><a href="delete">회원 정보 탈퇴(삭제)</a></h3>
		
		<button onclick="location.href='./info'">회원정보 조회</button>
		<button onclick="location.href='./update'">회원정보 수정</button>
		<button onclick="location.href='./logout'">로그아웃</button>
		
		<button onclick="location.href='./list'"></button>
	</main>
</body>
</html>