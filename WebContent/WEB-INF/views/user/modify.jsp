<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/views/common/head.jsp"></jsp:include>
<title>Login V4</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('/res/images/abc123.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form">
					<input type="hidden" name="ui_num" id="ui_num"
						value="${user.ui_num}"> <span
						class="login100-form-title p-b-49"> SIGN UP </span>

					<div class="wrap-input100 validate-input m-b-23"
						data-validate="UserID is reauired">
						<span class="label-input100">User ID</span> <input
							class="input100" type="text" name="ui_id" id="ui_id"
							placeholder="Type your Id" value="${user.ui_id}" disabled><span
							class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">User Password</span> <input
							class="input100" type="password" name="ui_password"
							id="ui_password" placeholder="Type your password"
							value="${user.ui_password}"> <span class="focus-input100"
							data-symbol="&#xf190;"></span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">User Name</span> <input
							class="input100" type="text" name="ui_name" id="ui_name"
							placeholder="Type your name" value="${user.ui_name}"> <span
							class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">User Birth</span> <input
							class="input100" type="date" name="ui_birth" id="ui_birth"
							placeholder="Type your birth" value="${user.ui_birth}"> <span
							class="focus-input100" data-symbol="&#x212C;"></span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">User Age</span> <input
							class="input100" type="number" name="ui_age" id="ui_age"
							placeholder="Type your age" value="${user.ui_age}"> <span
							class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">User Phone</span> <input
							class="input100" type="text" name="ui_phone" id="ui_phone"
							placeholder="Type your phone" value="${user.ui_phone}"> <span
							class="focus-input100" data-symbol="&#x260F;"></span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">User Email</span> <input
							class="input100" type="email" name="ui_email" id="ui_email"
							placeholder="Type your email" value="${user.ui_email}"> <span
							class="focus-input100" data-symbol="&#x40;"></span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">User NickName</span> <input
							class="input100" type="text" name="ui_nickname" id="ui_nickname"
							placeholder="Type your nickName" value="${user.ui_nickname}">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<br>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type="button" class="login100-form-btn"
								onclick="doModify()">회원수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		function doModify() {
			var els = document.querySelectorAll('input');
			var params = {};
			for (var i = 0; i < els.length; i++) {
				var el = els[i];
				params[el.name] = el.value;
			}
			params.cmd = 'modify';
			$.ajax({
				url : '/ajax/user',
				method : 'POST',
				data : JSON.stringify(params),
				contentType : 'application/json',
				success : function(res) {
					if (res.result === 1) {
						alert('회원수정 성공');
						location.href = '/';
					} else {
						alert("회원수정 실패");
					}
				}

			});
		}
		function checkId() {
			var uiId = $('#ui_id').val();
			var cmd = "checkId";
			$.ajax({
				method : 'GET',
				url : '/ajax/user?ui_id=' + uiId + '&cmd=' + cmd,
				success : function(res) {
					if (res.result) {
						alert("이미 있는 아이디입니다.");
					} else {
						alert("가입 가능한 아이디입니다.");
					}
				}
			});

		}
	</script>
</body>
</html>