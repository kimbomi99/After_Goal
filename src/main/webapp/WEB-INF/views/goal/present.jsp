<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}res/common.css" />
  
  <script src="${R}res/summernote/summernote-lite.js"></script>
  <script src="${R}res/summernote/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="${R}res/summernote/summernote-lite.css">
  <style>
    td:nth-child(1) { text-align: center; min-width: 100px; }  
  </style>
</head>
<body>
<div class="container">
  <h1>After Goal</h1>
  <h2>보상 설정</h2>
  
  <form method="post" enctype="multipart/form-data">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <table class="list condensed">
      <tbody>
        <tr>
           <td><input type="file" name="files"></td>
           </tr>
        <tr>
           <td><input type="text" name="resolution" style="width: 500px;" /></td>
        </tr>
        <tr>
           <td><button type="submit" class="btn">저장</button></td>
        </tr>
      </tbody>
    </table>
  </form>

</div>
</body>
</html>