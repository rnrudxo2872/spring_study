<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>

<h1>글본문 - ${boardVO.title }</h1>
<form method="post" role="form">
	<%-- <input type="hidden" name="bno" value="${boardVO.bno }"> --%>
</form>
                <div class="card-body">
                  <div class="form-group">
                    <label for="boardTitle">글번호</label>
                    <input type="text" readonly class="form-control" id="boardTitle" value="${boardVO.bno }">
                  </div>
                  <div class="form-group">
                    <label for="boardTitle">제목</label>
                    <input type="text" readonly class="form-control" id="boardTitle" value="${boardVO.title }">
                  </div>
                  <div class="form-group">
                    <label for="boardWriter">글쓴이</label>
                    <input type="text" readonly class="form-control" id="boardWriter" value="${boardVO.writer }">
                  </div>
                  <div class="form-group">
                    <label for="content">글 내용</label>
                    <textarea id="content" readonly rows="3" >${boardVO.content }</textarea>
                  </div>
                <div class="card-footer">
                  <button class="btn btn-warning">수정하기</button>
                  <button class="btn btn-danger">삭제하기</button>
                  <button id="listBtn" class="btn btn-primary">목록으로</button>
                </div>
              
              <script>
              	/* $(function(){
              		
              	}) */
              	$(document).ready(function(){
              		
              		//폼태그 정보를 가져오기
              		var formObj = $("form[role='form']");
              		console.log(formObj);
              		
              		//목록으로 버튼 클릭시
         			$("#listBtn").click(function(){
         				location.href="/board/listAll";
         			})
         			$(".btn-warning").on("click", function(){
         				//	/board/modify 주소로 이동 (get 방식)	=>	submit()
         				formObj.attr("action","/board/modify")
         				formObj.attr("method","get")
         				formObj.submit();
         			})
         			
         			$(".btn-danger").click(function(){
         				formObj.attr("action", "/board/delete");
         				formObj.submit();
         			})
              	})
              	
              </script>
              
<%@include file="../include/footer.jsp" %>
