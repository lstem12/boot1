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
	{ui_num:'이상화', ui_age:31, ui_id:'tem11'},
	{ui_num:'도도', ui_age:23, ui_id:'abc11'},
	{ui_num:'모모', ui_age:41, ui_id:'tre11'}
];

var loadData = function(){
	var html='';
	for(var i=0;i<userList.length;i++){
		var user = userList[i];
		html += '<tr>';
		$('th[data-col]').each(function(idx,th){
			var col = th.getAttribute('data-col');
			html += '<td>'+user[col] +'</td>';
		})
		html += '</tr>';
	}
	$('#tbody').html(html);
}			
$(document).ready(loadData);
</script>

	<table border="1">
		<tr>
			<th data-col="ui_num">이름</th>
			<th data-col="ui_age">나이</th>
			<th data-col="ui_id">아이디</th>
		</tr>
		<tbody id="tbody">
		</tbody>
	</table>
</body>
</html>