<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<script>
var corList = [
	{corNo:1,corArea:'대구',corSum:6978, corNew:0},
	{corNo:2,corArea:'서울',corSum:2986, corNew:96},
	{corNo:3,corArea:'경기',corSum:2612, corNew:85},
	{corNo:4,corArea:'경북',corSum:1443, corNew:6},
	{corNo:5,corArea:'검역',corSum:1322, corNew:4},
	{corNo:6,corArea:'인척',corSum:543, corNew:20},
	{corNo:7,corArea:'광주',corSum:280, corNew:1},
	{corNo:8,corArea:'부산',corSum:262, corNew:3}

];
var loadData = function(){
	var html = '';
	var corSumTotal = 0;
	var corNewTotal = 0;		
	for(var i=0;i<corList.length;i++){
		html += '<tr>';
		var corl = corList[i];
		$('th[data-col]').each(function(idx,th){
			var col = th.getAttribute('data-col');
			html += '<td>'+corl[col]+'</td>';
			if(col=='corSum'){
				corSumTotal += corl[col];
			}else if(col=='corNew'){
				corNewTotal += corl[col];
			}
		})
		html += '</tr>';
	}
		html += '<tr>';
		html += '<td colspan="2">합계</td>';
		html += '<td>'+corSumTotal+'</td>';
		html += '<td>'+corNewTotal+'</td>';
		html += '</tr>';
	$('#tbody').html(html);
}
$(document).ready(loadData);
</script>
<table class="table table-bordered">
	<tr>
		<th data-col="corNo">번호</th>
		<th data-col="corArea">지역</th>
		<th data-col="corSum">총확진자</th>
		<th data-col="corNew">신규확진자</th>
	</tr>
	<tbody id="tbody">
	</tbody>
</table>
</body>
</html>