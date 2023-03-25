<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}res/common.css">
  <style>
   h2 { margin: 10% 0% 5% 20%; font-size: 20pt; }
    form { width: 500px; margin: 10% 0% 0% 42%; }
    button { margin: 10% 0% 0% 22%; }
    .error { color: red; }
    table { width: 50%; font-size: 15pt; margin-left: -5%; }
  </style>
</head>
<body>
<div class="container">
  <form method="post" action="${R}login_processing" class="box">
    <h1>After Goal</h1>
    <h2>Login</h2>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <table>
      <tr>
        <td>Id:</td>
        <td><input type="text" style="font-size: 13pt;" name="userId" /></td>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type="password" style="font-size: 13pt;" name="password" /></td>
      </tr>
    </table>
    <button type="submit" class="btn">로그인</button>

    <c:if test="${ param.error != null }">
      <div class="error">로그인 실패</div>
    </c:if>
  </form>
</div>
</body>
</html>
