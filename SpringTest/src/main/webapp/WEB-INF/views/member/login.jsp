<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../partials/head.jsp"%>
<body>
<div class="basicFrame">
<div class="header">
</div>

<div class="form-container">
        <form method="post">
            <input type="text" placeholder="아이디(이메일)을 입력해주세요!" name="userid" required>
            <input type="password" placeholder="비밀번호를 입력해주세요!" name="userpw" required>
    <p>

            <input type="submit" value="로그인">
        </form>
        <button onclick="location.href='./insert'">회원이 아니신가요?</button>
</div>
<div>
</div> 
</div>
</body>
</html>