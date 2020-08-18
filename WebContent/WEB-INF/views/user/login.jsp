<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jspf"%>
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
					<span class="login100-form-title p-b-49"> Login </span>

					<div class="wrap-input100 validate-input m-b-23"
						data-validate="UserID is reauired">
						<span class="label-input100">User ID</span> <input
							class="input100" type="text" name="ui_id" id="ui_id"
							placeholder="Type your userId"> <span
							class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">Password</span> <input
							class="input100" type="password" name="ui_passowrd"
							id="ui_password" placeholder="Type your password"> <span
							class="focus-input100" data-symbol="&#xf190;"></span>
					</div>

					<div class="text-right p-t-8 p-b-31">
						<a href="#"> Forgot password? </a>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button type="button" class="login100-form-btn"
								onclick="doLogin()">Login</button>
						</div>
					</div>

					<div class="txt1 text-center p-t-54 p-b-20">
						<span> Or Sign Up Using </span>
					</div>

					<div class="flex-c-m">
						<a href="#" class="login100-social-item bg1"> <i
							class="fa fa-facebook"></i>
						</a> <a href="#" class="login100-social-item bg2"> <i
							class="fa fa-twitter"></i>
						</a> <a href="#" class="login100-social-item bg3"> <i
							class="fa fa-google"></i>
						</a>
					</div>

					<div class="flex-col-c p-t-155">
						<span class="txt1 p-b-17"> Or Sign Up Using </span> <a href="#"
							class="txt2"> Sign Up </a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="dropDownSelect1"></div>
	<script>
		function doLogin() {
			var uiId = $('#ui_id').val();
			var uiPassword = $('#ui_password').val();
			var cmd = 'login';
			var param = {
				ui_id : uiId,
				ui_password : uiPassword,
				cmd : cmd
			}
			$.ajax({
				method : 'POST',
				url : '/ajax/user',
				data : JSON.stringify(param),
				contentType:'application/json',
				success : function(res){
					if(res.rMap){
						alert(res.msg);
						location.href = res.url;
					}else{
						alert(res.msg);
						location.href = res.url;
					}
				}
			});
		}
//			
	</script>
</body>
</html>