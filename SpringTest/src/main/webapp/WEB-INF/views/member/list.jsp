<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	font-family: Georgia, sans-serif;
}
table{
border: 3px dashed #04AA6B;
}
th,td{
border: 1px solid gray;
}

</style>
</head>
<body>
<h1>WebContent/member/list.jsp</h1>
<h2>회원목록을 확인(관리자)</h2>

<table>
<tr>
<th>아이디</th>
<th>비밀번호</th>
<th>이름</th>
<th>나이</th>
<th>성별</th>
<th>이메일</th>
<th>가입일</th>
</tr>

<%while(rs.next()){ 
/* if(rs.getString(1).equals("admin"))
	continue; */
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getInt(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
<td><%=rs.getTimestamp(7) %></td>
</tr>
<%} %>
</table>
<button onclick="location.href='./main'">메인페이지</button>
</body>
</html>