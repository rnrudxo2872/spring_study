<%@page import="java.sql.Timestamp"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="../partials/head.jsp"%>
<body>
<header><h1>회원정보 수정</h1></header>
<main>
        <form method="post" style="display:flex; flex-direction: column;">
            <div class="form-container__email-container">
            <input class="email-container__inputEmail" type="email" value="${infoVO.userid}" name="userid" readonly>
            <span class="idSearchInfo"></span>
            </div>
			
            <input type="password" placeholder="비밀번호를 입력해주세요!" name="userpw" required>
            <input type="text" value="${infoVO.username}" name="username" required>
            <input type="text" value="${infoVO.useremail}" name="useremail" required>
    <p>
			
        	<input type="submit" value="정보수정">
        	<input type="button" value="회원탈퇴" onclick="delFun(this.form)">
        </form>

</main>
</body>
</html>
