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
			var html = '<table border="1"';
			html += '<tr><th>이름</th></tr>';
			for(var i=0;i<res.list.length;i++){
				var user = res.list[i];
				html += '<tr><th>' + user.ui_name + '</th></tr>';
			}
			html+= '</table>';
			$('#userListDiv').html(html);
		}
		
	})
})
</script>
<h3>유저리스트</h3>
<div id="userListDiv"></div>
</body>
</html>