<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>
<link rel="stylesheet" href="${css}/bitcamp.css" />
<div id ="wrapper">
<h2> 비트 캠프 메인</h2>
<section>


<table id="mypage_table">
<tr>
	<td rowspan="5"></td>
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
<tr><td>회원번호</td><td></td><td>계좌번호</td><td></td></tr>
<tr><td colspan="5"><button>수정</button><button id ="bye">탈퇴</button></td></tr>
</table>


</section>
</div>
<%@ include file="../common/footer.jsp"%>
</body>
<script>
document.querySelector('#kakao').addEventListener('click',function(){
	location.href = "${ctx}/user.do?cmd=move&dir=kakao&page=main";},false);

document.querySelector('#bye').addEventListener('click',function(){
	alert('정말 삭제할겁니까?'); 
	location.href = "${ctx}/user.do?cmd=delete";},false);
</script>