<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table , th, td {
    border: 1px solid #bcbcbc;
  }
  table {
    width: 100%;
    height: 200px;
  }
  #tr01 th {
  	text-align: center;
  	font-size: 20px;
  }
  #tr02 td {
  	text-align: center;
  	font-size: 15px;
  }
  h1{
  	text-align: center;
  }
</style>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
</head>
<body>
<script>
$(document).ready(function(){
	$.ajax({
		url:'/ajax/user',
		method:'GET',
		data:{cmd:'list'},
		success:function(res){
			var html = '<table border="1">';
			html += '<tr id="tr01">';
			html += '<th>번호</th>';
			html += '<th>이름</th>';
			html += '<th>나이</th>';
			html += '<th>생년월일</th>';
			html += '<th>아이디</th>';
			html += '<th>전화번호</th>';
			html += '<th>이메일</th>';
			html += '<th>가입일</th>';
			html += '<th>닉네임</th>';
			html += '<th>관리번호</th>';
			html += '</tr>';
			for(var i=0;i<res.list.length;i++){
				var user = res.list[i];
				html += '<tr id="tr02" onclick="userView()">';
				html += '<td>' + user.ui_num + '</td>';
				html += '<td>' + user.ui_name + '</td>';
				html += '<td>' + user.ui_age + '</td>';
				html += '<td>' + user.ui_birth + '</td>';
				html += '<td>' + user.ui_id + '</td>';
				html += '<td>' + user.ui_phone + '</td>';
				html += '<td>' + user.ui_email + '</td>';
				html += '<td>' + user.ui_credat + '</td>';
				html += '<td>' + user.ui_nickname + '</td>';
				html += '<td>' + user.ui_admin + '</td>';
				html += '</tr>';
			}
			html+= '</table>';
			$('#userListDiv').html(html);
		}
	})
})
function userView(res){
	colsole.log(res.list);
}
</script>
<h1>유저리스트</h1><br>
<div id="userListDiv"></div><br>
<a href="/"><button class="btn btn-info">관리자정보화면</button></a>
</body>
</html>