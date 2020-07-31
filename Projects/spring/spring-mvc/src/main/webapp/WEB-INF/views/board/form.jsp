
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>자유게시판</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container mt-3 mb-5">
      <div class="row">
         <div class="col-12">
            <form id="form-board" method="post" action="add.do" enctype="multipart/form-data">
               <div class="card">
                  <div class="card-header">새 글 입력폼</div>
                  <div class="card-body">
                     <div class="form-group">
                        <label>Title</label>
                        <input type="text" class="form-control" name="title" id="board-title" />
                     </div>
                     <div class="form-group">
                        <label>Writer</label>
                        <input type="text" class="form-control" name="writer" id="board-writer" />
                     </div>
                     <div class="form-group">
                        <label>Content</label>
                        <textarea rows="5" class="form-control" name="content"></textarea>
                     </div>
                     <div class="form-group">
                        <label>File</label>
                        <input type="file" class="form-control" name="upfile" />
                     </div>
                     <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" name="password" id="board-password" />
                     </div>
                  </div>
                  <div class="card-footer text-right">
                     <a href="list.do" class="btn btn-secondary">Cancel</a>
                     <button type="submit" class="btn btn-primary">Submit</button>
                  </div>
               </div>
            </form>   
         </div>
      </div>
   </div>
<script type="text/javascript" src="/resources/jquery/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
   // 입력폼에서 submit 이벤트 발생시 실행할 이벤트핸들러 함수 등록해두기
   $("#form-board").submit(function() {
      var $titleField = $("#board-title");
      var $writerField = $("#board-writer");
      var $passwordField = $("#board-password");
      
      if ($titleField.val() == "") {
         alert("Title Title !!");
         $titleField.focus();
         return false;
      }
      if ($writerField.val() == "") {
         alert("Writer Writer !!");
         $writerField.focus();
         return false;
      }
      if ($passwordField.val() == "") {
         alert("Password Password !!");
         $passwordField.focus();
         return false;
      }
      return true;
   });
})
</script>
</body>
</html>