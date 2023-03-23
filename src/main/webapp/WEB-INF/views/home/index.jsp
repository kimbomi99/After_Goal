<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}res/common.css">
  <script src="${R}res/rolling.js"></script>
  <style>
    div.box { width: 100%; }
  </style>
</head>
<body>
<div class="container">
 	  <a href="${R}login" style="margin: 0% 1% 0% 90%; font-size: 13pt; ">로그인</a>
      <a href="${R}join" style="font-size: 13pt;">회원가입</a>
  <div class="box">
    <h1>After Goal</h1><hr>
    
    
    <table width="757" border="0" cellspacing="0" cellpadding="0">


 <tr>
  <td height="62">
  
   <div style="position:absolute; width:25%; height:3%; overflow:hidden; left: 38%; top: 40%;">
   
       <div style="position:relative; top: 10%; text-align: center;" id="banner_1">
       
       	 <c:forEach var="success" items="${ allSuccess }">
          
            <a style="font-size: 14pt; color: blue;">${ success.userId }님이 모든 목표를 달성했습니다! <br></a>
          </c:forEach>
      
       	
        </div>
          
      </div>
      
    </td>       
  </tr>
 
</table>

     
      <img src="/images/DSC_0077_edited.jpg" width="50%"; height="10%"; style="margin:10% 10% 1% 25%;">                  
  
   
  </div>
</div>
</body>
<script>
// banner_roll("div태그 id", 배너1개높이, 딜레이, 1칸이동속도, 0);

banner_roll("banner_1", 18, 2000, 40, 0);
</script>
</html>
