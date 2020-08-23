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
	<input type="hidden" name="ui_num" id="ui_num" value="${user.ui_num}">
	<div class="container">
		${sessionScope.user.ui_name} 님 반갑습니다.<br>
		<c:if test="${sessionScope.user.ui_admin == '1'}">
			<a href="/views/user/list"><button class="btn btn-info">유저리스트</button></a>
		</c:if>
		<button class="btn btn-info" onclick="doLogout()">로그아웃</button>
		<a href="/views/user/modify"><button class="btn btn-info">정보수정</button></a>
		<button class="btn btn-info" onclick="doDelete()">회원탈퇴</button>
	</div>
	<script>
		function doLogout() {
			$.ajax({
				url : '/ajax/user',
				method : 'POST',
				data : JSON.stringify({
					cmd : 'logout'
				}),
				success : function(res) {
					if (res.result) {
						alert('로그아웃 되었습니다.');
						location.href = '/views/user/login';
					}
				}
			})
		}
		function doDelete() {
			var del;
			del = confirm('정말 탈퇴하시겠습니까?');
			if (del) {
				var uiPassword;
				uiPassword = prompt('탈퇴를 하시려면 비밀번호를 입력 해주세요.');
				if (uiPassword) {
					var uiNum = document.querySelector('#ui_num').value;
					var params = {};
					params.cmd = 'delete';
					params.ui_num = uiNum;
					params.ui_password = uiPassword;
					$.ajax({
						url : '/ajax/user',
						method : 'POST',
						data : JSON.stringify(params),
						success : function(res) {
							if (res.result === 1) {
								alert('회원이탈퇴 되었습니다.');
								location.href = '/views/user/login';
							} else if(res.result === -1){
								alert('비밀번호가 틀렸습니다.');
							} else {
								alert('이미 탈퇴된 회원입니다.');
							}
						}
					})
				}else if(''===uiPassword){
					alert('비밀번호를 입력해주세요');
				}
			}
		}
	</script>
</body>
</html>