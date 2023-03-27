<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}res/common.css" />
  
  <style>
    table { border-collapse: collapse;  }
    td:nth-child(1) { text-align: center; min-width: 100px; }  
     h2 { margin-top: 5%; margin-left: 20%; font-size: 25pt; }
     .btn { font-size: 12pt; margin-left: 95%; margin-top: 20px; }
  </style>
</head>
<body>
<div class="container">
  <a href="list"><h1>After Goal</h1></a><hr>
  <h2>보상 설정</h2>
  
  <form method="post" enctype="multipart/form-data">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <table class="list condensed">
     <thead>
        <tr>
          <th>모든 목표 달성 시 본인에게 주고 싶은 선물</th>
          <th>다짐의 말 한마디</th>
        </tr>
      </thead>
      <tbody>
        <tr>
           <td><input type="file" name="files"></td>
           <td><input type="text" name="resolution" style="width: 500px;" /></td>
        </tr>
        
      </tbody>
    </table>
    <button type="submit" class="btn">저장</button>
  </form>

</div>
</body>
</html>