<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>
<link rel="stylesheet" href="${css}/bitcamp.css" />
<div id ="wrapper">
<h2> 비트 캠프 메인</h2>
<section>
	<table><tr><td ><button id ="bitcamp_passupdate_btn" >비밀번호 변경</button></td></tr></table>
	<form id = "bitcamp_form" action="result.jsp">
<article>
<table id="mypage_table">
<tr>
	<td rowspan="4"></td>
	<td class="column">id</td>
	<td>${sessionScope.user.id}</td>
	<td class="column">생년월일</td>
	<td>${sessionScope.user.ssn}</td>
</tr>
<tr>
	<td class="column">pass</td>
	<td>${sessionScope.user.pass}</td>
	<td class="column">전화번호</td>
	<td>${sessionScope.user.phone}</td>
</tr>
<tr>
	<td class="column">이름</td>
	<td>${sessionScope.user.name}</td>
	<td class="column">email</td>
	<td>${sessionScope.user.email}</td>
</tr>
<tr>
	<td class="column">성별</td>
	<td>성별 값</td>
	<td class="column">주소</td>
	<td>${sessionScope.user.addr}</td>
</tr>
</table>
</article>
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
	<tr>
	
	<td id ="bitcamp_attendance_btn_box" colspan="7"><button id ="bitcamp_attendance_btn" style="">확인</button></td>
	</tr>
	</table>
	<input name ="id" value="jmh3360" type="hidden"  />
	</form>
</section>
</div>
<aside> </aside>
<%@ include file="../common/footer.jsp"%>
</body>
<script>
	document.querySelector("#bitcamp_passupdate_btn").addEventListener('click',function(){
		alert("난 자바가 좋아");
		location.href = "${ctx}/user.do?cmd=move&dir=bitcamp&page=change_pass";
	},false);
	</script>
	