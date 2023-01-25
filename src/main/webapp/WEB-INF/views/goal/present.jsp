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
    td:nth-child(1) { text-align: center; min-width: 100px; }  
  </style>
</head>
<body>
<div class="container">
  <h1>보상 설정</h1>
  
  <form method="post">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <table class="list condensed">
      <tbody>
        <tr>
           <td><input type="text" name="reward" style="width: 500px;" /></td>
           </tr>
        <tr>
           <td><input type="text" name="resolution" style="width: 500px;" /></td>
        </tr>
        <tr>
           <td><button type="submit" class="btn">설정</button></td>
        </tr>
      </tbody>
    </table>
  </form>
  <script>
  	
  </script>

</div>
</body>
</html>