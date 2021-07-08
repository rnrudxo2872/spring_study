<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>

<h1>글 수정하기</h1>
<form method="post" role="form">

                <div class="card-body">
                  <div class="form-group">
                    <label for="boardTitle">글번호</label>
                    <input name="bno" type="text" readonly class="form-control" id="boardTitle" value="${uvo.bno }">
                  </div>
                  <div class="form-group">
                    <label for="boardTitle">제목</label>
                    <input name="title" type="text" class="form-control" id="boardTitle" value="${uvo.title }">
                  </div>
                  <div class="form-group">
                    <label for="boardWriter">글쓴이</label>
                    <input name="writer" type="text" class="form-control" id="boardWriter" value="${uvo.writer }">
                  </div>
                  <div class="form-group">
                    <label for="content">글 내용</label>
                    <textarea name="content" id="content" rows="3" >${uvo.content }</textarea>
                  </div>
                <div class="card-footer">
                  <button class="btn btn-warning">수정하기</button>
                  <button id="listBtn" class="btn btn-primary">목록으로</button>
                </div>
              </form>
              
              <script>
              	/* $(function(){
              		
              	}) */
              	$(document).ready(function(){
              		
              		//폼태그 정보를 가져오기
              		var formObj = $("form[role='form']");
              		console.log(formObj);
              		
              		//목록으로 버튼 클릭시
         			$("#listBtn").click(function(event){
         				event.preventDefault();
         				location.href="/board/listAll";
         			})
         			$(".btn-warning").click(function(){
         		
         			})
              	})
              	
              </script>
              
<%@include file="../include/footer.jsp" %>
