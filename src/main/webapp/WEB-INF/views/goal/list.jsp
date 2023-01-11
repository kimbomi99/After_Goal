<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="${R}common.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
  <style>
    td:nth-child(1) { text-align: center; min-width: 100px; }  
  </style>
</head>
<body>
<div class="container">
  <h1>목표</h1>
  
  <form method="post" action="insert">
    <table class="list condensed">
      <thead>
        <tr>
          <th>아이디</th>
          <th>목표</th>
          <th>달성여부</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="goal" items="${ goals }">
          <tr>
          	<td>${goal.userId }</td>
            <td><a href="update?id=${ goal.id }">${ goal.goalList }</a></td> 
            <td>${ goal.success =="true" ? "Complete" : "falid" }</td>
            
            <td><a href="delete?id=${ goal.id }" class="btn" data-confirm-delete>삭제</a></td>
          </tr>
        </c:forEach>
        <tr>
           <td><input type="text" name="userId" style="width: 250px;" /></td>
           <td><input type="text" name="goalList" style="width: 500px;" /></td>
           <td>
           	<label>
           		<input type="radio" name="success" value="true" /> 달성 </label>
        	<label>
        		<input type= "radio" name="success" value="false" /> 미달성 </label>
           	</td> 
           <td><button type="submit" class="btn">저장</button></td>
        </tr>
      </tbody>
    </table>
  </form>

</div>
</body>
</html>