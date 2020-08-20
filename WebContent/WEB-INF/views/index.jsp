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
<div class="container">
	${sessionScope.user.ui_name} 님 반갑습니다.
	<button class="btn btn-info" onclick="doLogout()">로그아웃</button>
	<a href="/views/user/modify"><button class="btn btn-info">정보수정</button></a>
</div>
<script>
function doLogout(){
	alert('로그아웃');
	$.ajax({
		url:'/ajax/user',
		method:'POST',
		data:JSON.stringify({cmd:'logout'}),
		success : function(res){
			if(res.result){
				alert('로그아웃 되었습니다.');
				location.href='/views/user/login';
			}
		}
	})
}
</script>
</body>
</html>