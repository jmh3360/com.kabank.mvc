<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp"%>
<link rel="stylesheet" href="../../css/bitcamp.css" />
<body>
	<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>
<div id ="wrapper">
<h2> 비트 캠프 메인</h2>
<section>
	<form id = "bitcamp_form" action="result.jsp">
<table >
	<tr>
		<th>이름</th>
		<th>월</th>
		<th>화</th>
		<th>수</th>
		<th>목</th>
		<th>금</th>
		<th>결과</th>
	</tr>
	<tr>
		<td></td>
		<td >
		<select id ="monday" >
		<option value="">결석</option>
		<option value="">출석</option>
		<option value="">지각</option>
		<option value="">조퇴</option>
		</select></td>
		<td >
		<select id ="tuseday">
		<option value="">결석</option>
		<option value="">출석</option>
		<option value="">지각</option>
		<option value="">조퇴</option>
		</select></td>
		<td >
		<select id ="wednesday">
		<option value="">결석</option>
		<option value="">출석</option>
		<option value="">지각</option>
		<option value="">조퇴</option>
		</select></td>
		<td >
		<select id ="thursday">
		<option value="">결석</option>
		<option value="">출석</option>
		<option value="">지각</option>
		<option value="">조퇴</option>
		</select></td>
		<td >
		<select id ="friday">
		<option value="">결석</option>
		<option value="">출석</option>
		<option value="">지각</option>
		<option value="">조퇴</option>
		</select></td>
		
		<td> 		</td>
	</tr>
	<tr><td id ="bitcamp_attendance_btn_box" colspan="7"><button id ="bitcamp_attendance_btn" style="">확인</button></td></tr>
	</table>
	<input name ="id" value="jmh3360" type="hidden"  />
	</form>
</section>
</div>
<aside> </aside>
<%@ include file="../common/footer.jsp"%>
</body>
<script src="../../js/bitcamp/bitcamp.js"></script>
</html>