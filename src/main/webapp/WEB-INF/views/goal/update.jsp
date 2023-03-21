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
  <h1>After Goal</h1>
  <h2>목표수정</h2>
  
  <form method="post">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <table class="list condensed">
      <thead>
        <tr>
          <th>목표</th>
          <th>달성여부</th>
        </tr>
      </thead>
      <tbody>
        <tr>
        <input type="hidden" name="userId" value="${ goal.userId }">
           <td><input type="text" name="goalList" style="width: 500px;" value="${ goal.goalList }" /></td>
           <td>
           	<label>
           		<input type="radio" name="success" value="true" /> 달성 </label>
        	<label>
        		<input type= "radio" name="success"  value="false" /> 미달성 </label>
           	</td> 
           <td><button type="submit" class="btn">저장</button></td>
        </tr>
      </tbody>
    </table>
  </form>
  <script>
  	if(!$('input:radio[name=success]).is(':checked')) {   
	   		alert("꼭 선택해 주세요.");
	   		return;
			}
  </script>

</div>
</body>
</html>