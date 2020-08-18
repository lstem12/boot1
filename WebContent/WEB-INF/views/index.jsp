<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 화면</h2> <br>
	<c:if test="${sessionScope.id == null }">
		<a href="/views/user/login"><button>로그인</button></a>
	</c:if>
	<c:if test="${sessionScope.id != null }">
		<button onclick="doLogout()">로그아웃</button>
	</c:if>
</body>
</html>