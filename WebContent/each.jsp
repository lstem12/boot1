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
이름 : <input type="text" id="name"><br>
나이 : <input type="number" id="age"><br>
아이디 : <input type="text" id="id"><br>
비번 : <input type="password" id="pwd"><br>
<button>입력</button>
<script>
	$('button').click(function(){
		var params ={};
		$('input[id]').each(function(idx, input){
			params[input.id] = input.value;
		})
		console.log(params);
	})
</script>
</body>
</html>