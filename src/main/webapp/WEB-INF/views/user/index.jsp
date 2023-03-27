<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}res/common.css">
  <style>
   h2 { margin: 10% 0% 5% 15%; font-size: 20pt; }
    div.box { width: 500px; margin: 10% 0% 0% 42%; }
    table { border-collapse: collapse; width: 80%; font-size: 13pt; margin-left: -13%; }
    td { border: 1px solid #aaa; padding: 8px; }
  </style>
</head>
<body>
<div class="container">
  <div class="box">
    <a href="${R}goal/list"><h1>After Goal</h1></a>
    <h2>My Page</h2>
    <table>
      <tr>
          <td>로그인ID</td>
          <td><sec:authentication property="name" /></td>
      </tr>
      <tr>
          <td>이름</td>
          <td><sec:authentication property="principal.name" /></td>
      </tr>
      <tr>
          <td>이메일</td>
          <td><sec:authentication property="principal.email" /></td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>
