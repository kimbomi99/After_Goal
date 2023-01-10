<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
  <style>
    td:nth-child(1) { text-align: center; min-width: 30px; }  
  </style>
</head>
<body>
<div class="container">
  <h1>목표</h1>
  
  <form method="post" action="insert">
    <table class="list condensed">
      <thead>
        <tr>
          <th>목표</th>
          <th>달성여부</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="goal" items="${ goals }">
          <tr>
            <td>${ goal.goalList }</td>
            <td>${ goal.success }</td>
          </tr>
        </c:forEach>
        <tr>
           <td></td>
           <td><input type="text" name="goalList" style="width: 250px;" /></td>
           <td><input type="text" name="success" style="width: 120px;" /></td>
           <td><button type="submit" class="btn">저장</button></td>
        </tr>
      </tbody>
    </table>
  </form>

</div>
</body>
</html>