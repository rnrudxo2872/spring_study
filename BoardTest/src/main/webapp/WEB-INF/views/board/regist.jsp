<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>

<h1>하이염</h1>
<form method="post">
                <div class="card-body">
                  <div class="form-group">
                    <label for="boardTitle">제목</label>
                    <input type="text" name="title" class="form-control" id="boardTitle" placeholder="제목을 입력하세욤">
                  </div>
                  <div class="form-group">
                    <label for="boardWriter">글쓴이</label>
                    <input type="text" name="writer" class="form-control" id="boardWriter" placeholder="작성자욤">
                  </div>
                  <div class="form-group">
                    <label for="content">글 내용</label>
                    <textarea id="content" class="form-control" name="content" rows="3" placeholder="내용을 입력해주셔요"></textarea>
                  </div>
                  <!-- <div class="form-group">
                    <label for="exampleInputEmail1">제목</label>
                    <input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="제목을 입력하세욤">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">제목</label>
                    <input type="text" name="title" class="form-control" id="exampleInputEmail1" placeholder="제목을 입력하세욤">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <div class="input-group">
                      <div class="custom-file"> -->
              <!--           <input type="file" class="custom-file-input" id="exampleInputFile">
                        <label class="custom-file-label" for="exampleInputFile">Choose file</label>
                      </div>
                      <div class="input-group-append">
                        <span class="input-group-text">Upload</span>
                      </div>
                    </div>
                  </div>
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                  </div>
                </div> -->
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </form>
<%@include file="../include/footer.jsp" %>
