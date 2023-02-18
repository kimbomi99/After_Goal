<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}res/common.css" />
  
  <script src="${R}res/summernote/summernote-lite.js"></script>
  <script src="${R}res/summernote/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="${R}res/summernote/summernote-lite.css">
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
           <td><textarea class="summernote" name="reward">${ present.reward }</textarea></td>
           </tr>
        <tr>
           <td><input type="text" name="resolution" style="width: 500px;" /></td>
        </tr>
        <tr>
           <td><a onclick="save()">설정</a></td>
        </tr>
      </tbody>
    </table>
  </form>
  <script>
  $('.summernote').summernote({
      // 에디터 높이
      height: 150,
      // 에디터 한글 설정
      lang: "ko-KR",
      // 에디터에 커서 이동 (input창의 autofocus라고 생각)
      focus : true,
      toolbar: [
          // 글꼴 설정
          ['fontname', ['fontname']],
          // 글자 크기 설정
          ['fontsize', ['fontsize']],
          // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
          ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
          // 글자색
          ['color', ['forecolor','color']],
          // 표만들기
          ['table', ['table']],
          // 글머리 기호, 번호매기기, 문단정렬
          ['para', ['ul', 'ol', 'paragraph']],
          
          ['insert',['picture','link','video']],
          // 줄간격
          ['height', ['height']],
          // 코드보기, 확대해서보기, 도움말
          ['view', ['codeview','fullscreen', 'help']]
      ],
      // 추가한 글꼴
      fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
      // 추가한 폰트사이즈
      fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']

  });
  
  function save() {
	    var s = $('.summernote').summernote('code');
	    $('input[name=reward]').val(s);
	    $('form').submit();
	  }

  
  	
  </script>

</div>
</body>
</html>