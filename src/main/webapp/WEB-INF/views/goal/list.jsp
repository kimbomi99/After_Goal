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
  <script src="${R}res/rolling.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}res/common.css" />
  <style>
    td:nth-child(1) { text-align: center; min-width: 100px; }  
    div.box { background-color: #FFFACD; width: 30%; height: 150px; border-style: outset; padding-top: 30px;
    position: relative; top: 100px; left: 10%; text-align: center; color: gray;}
  </style>
</head>
<body>
<div class="container">
<a style="margin: 10% 1% 0% 80%; font-size: 13pt;"><sec:authentication property="name" />님 안녕하세요! </a>
<a href="${R}user/index" style="margin-right: 1%;">마이페이지</a>
<a href="${R}logout_processing" >로그아웃</a>
  <h1>After Goal</h1><hr>
 
  <table width="757" border="0" cellspacing="0" cellpadding="0">


 <tr>
  <td height="62">
  
   <div style="position:absolute; width:25%; height:3%; overflow:hidden; left: 70%; top: 16%;">
   
       <div style="position:relative; top: 10%; text-align: center;" id="banner_1">
       
       	 <c:forEach var="success" items="${ allSuccess }">
            <a style="font-size: 12pt; color: blue;">${ success.userId }님이 모든 목표를 달성했습니다! <br></a>
          </c:forEach>
        </div>
      </div>
    </td>       
  </tr>
</table>

    
  <form method="post" action="insert">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
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
            <td><a href="update?id=${ goal.id }">${ goal.goalList }</a></td> 
            <td style="color: red;">${ goal.success =="true" ? "Complete" : "falid" }</td>
            <td><a href="delete?id=${ goal.id }" class="btn" data-confirm-delete>삭제</a></td>
          </tr>
        </c:forEach>
       
        <tr>
           <td><input type="text" name="goalList" style="width: 80%;" /></td>
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
    
    
    <div class="box">
    	<h2>${ list_count }개 중 ${ success_count }개 달성 완료!</h2>
    	<h3>모든 목표 달성까지 ${ list_count-success_count } 목표 남음.</h3>
    	<c:if test="${ list_count == success_count && list_count != 0 }">
      		<h4 style="color: red;"> "모든 목표 달성!! 축하드립니다~" </h4>
    	</c:if>
   </div>
    
    <c:if test="${ image==null  }" >
    	<a href="present" class="btn" style="font-size: 13pt; position: relative; top: -150px; left: 80%;">보상 설정</a>
    </c:if>
    <c:if test="${ image!=null  }" >
    	<a href="present"><img src="/images/${image.filename}" style="width:35%; height:250px; 
    		 border-color: #FAEBD7; border-style: double; position: relative; top: -120px; left: 50%;"></a>
    </c:if>
    
  </form>
 <footer>${ image.resolution }</footer>
  
</div>
</body>
<script>
// banner_roll("div태그 id", 배너1개높이, 딜레이, 1칸이동속도, 0);

banner_roll("banner_1", 18, 2000, 40, 0);
</script>
</html>