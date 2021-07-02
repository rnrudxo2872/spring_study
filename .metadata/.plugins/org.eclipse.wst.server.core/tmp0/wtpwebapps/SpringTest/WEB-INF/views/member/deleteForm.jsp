<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>WebContent/member/deleteForm.jsp</h1>

<%
	request.setCharacterEncoding("utf-8");
	String id=(String)session.getAttribute("id");
	
	if(id == null){
		%>
		<script type="text/javascript">
		alert("아이디 세션없음");
		location.href = "./login";
		</script>
		<%
	}
	
%>

<fieldset>
<form method="post">
<!-- 아이디 : <input type="text" name="id" value="<%=id%>" readonly="readonly"/><br> -->
<input type="hidden" name="userid" value="<%=id%>">
비밀번호 확인 : <input type="password" name="userpw" /><br>
<input type="submit" value="삭제 확인">
</form>
</fieldset>
</body>
</html>