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
var userList = [
	{ui_name:'이상화',ui_age:23,ui_id:'tem11'},
	{ui_name:'도도',ui_age:25,ui_id:'dodo1'},
	{ui_name:'모모',ui_age:32,ui_id:'momo1'}
];
function loadData(){
	var html = '';
	var sumAge = 0;
	for(var i=0;i<userList.length;i++){
		var user = userList[i];
		html += '<tr>';
		$('th[data-col]').each(function(idx,th){
			var col = th.getAttribute('data-col');
			html += '<td>' +user[col]+'</td>';
			if(col=='ui_age'){
				sumAge += user[col];
			}
		})
		html += '</tr>';
	}
	html += '<tr>';
	html += '<th>나이 총합</th>';
	html += '<th colspan="2">' +sumAge+'</th>';
	html += '</tr>';
	$('#tbody').html(html);
}

$(document).ready(loadData);
</script>
<table class="table table-bordered">
	<tr>
		<th data-col="ui_name">이름</th>
		<th data-col="ui_age">나이</th>
		<th data-col="ui_id">아이디</th>
	</tr>
	<tbody id="tbody">
	</tbody>
</table>
</body>
</html>