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
    div.box { padding: 10px; width: 1000px; height: 500px; }
  </style>
</head>
<body>
<div class="container">
  <div class="box">
    <h1>After Goal</h1>

      <a href="${R}login" class="banner" >로그인</a>
      <a href="${R}join" class="banner" >회원가입</a>
      <img src="/images/DSC_0077_edited.jpg" width="1100"; height="600";>                  
  
   
  </div>
</div>
</body>
</html>
