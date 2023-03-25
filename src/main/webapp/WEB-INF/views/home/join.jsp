<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${R}res/common.css">
<style>
  div.box { width: 500px; margin: 10% 0% 0% 42%; } 
  div.label { margin-top:10px; }
  form { margin: 10% 0% 0% 9%; }
  h2 { margin: 10% 0% 0% 20%; font-size: 20pt; }
  .error { color: red; display: block; }
  button { margin: 10% 2% 0% 20%; }
</style>
</head>
<body>
<div class="container">
  <div class="box">
    <h1>After Goal</h1>
    <h2>Join</h2>
    <form:form method="post" modelAttribute="userRegistration">
      <div>
        <div class="label">아이디:</div>
        <form:input path="userId" />
        <form:errors path="userId" class="error" />
      </div>
      <div>
        <div class="label">비밀번호:</div>
        <form:password path="passwd1" />
        <form:errors path="passwd1" class="error" />
      </div>
      <div>
        <div class="label">비밀번호 학인:</div>
        <form:password path="passwd2" />
        <form:errors path="passwd2" class="error" />
      </div>
      <div>
        <div class="label">이름:</div>
        <form:input path="name" />
        <form:errors path="name" class="error" />
      </div>
      <div>
        <div class="label">이메일:</div>
        <form:input path="email" />
        <form:errors path="email" class="error" />
      </div>
      <button type="submit" class="btn">회원가입</button>
      <a href="${R}" class="btn">취소</a>
    </form:form>
  </div>    
</div>
</body>
</html>

