<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			var html = '';
			for(var i=0;i<res.list.length;i++){
				var user = res.list[i];
				html += '<tr">';
				$('th[data-col]').each(function(idx,th){
					var col = th.getAttribute('data-col');
					html += '<td>' + user[col] +'</td>';
				})				
				html += '</tr>';
			}
			$('#tBody').html(html);
		}
	})
})
</script>
<h1>유저리스트</h1><br>
	<table class="table table-bordered">
		<tr>
			<th data-col="ui_num">번호</th>
			<th data-col="ui_name">이름</th>
			<th data-col="ui_age">나이</th>
			<th data-col="ui_birth">생년월일</th>
			<th data-col="ui_id">아이디</th>
			<th data-col="ui_phone">휴대폰번호</th>
			<th data-col="ui_email">이메일</th>
			<th data-col="ui_credat">생성일</th>
			<th data-col="ui_nickname">닉네임</th>
			<th data-col="ui_admin">관리번호</th>
		</tr>
		<tbody id="tBody">
		</tbody>
	</table>
	<a href="/"><button class="btn btn-info">관리자정보화면</button></a>
</body>
</html>