<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<body>
<%@ include file="../common/header.jsp"%>
<header id="admin_header"><h2>관리자 페이지</h2></header>
	<aside id="admin_sidebar" >
	<ul >
		<li>관리자 화면</li>
		<li><a href="#">회원관리</a></li>
	</ul>
	</aside>
<section style="margin-left: 10px;">



	<form id ="member_register_form" action="${pageContext.request.contextPath}/admin/member_list.do">
	<table id="admin_table">
		<tr><td>ID : <input name = "id" type="text" /></td></tr>
		<tr><td>PASS : <input name = "pass" type="text" /></td></tr>
		<tr><td>이름 : <input name = "name" type="text" /></td></tr>
		<tr><td>SSN : <input name= "ssn" type="text" /></td></tr>
		<tr><td>전화번호 : <input name = "phone" type="text" /></td></tr>
		<tr><td>이메일 : <input name = "email" type="text" /></td></tr>
		<tr><td>Profile : <input name = "profile" type="text" /></td></tr>
		<tr><td>주소 : <input name= "addr" type="text" /></td></tr>
		
		<tr><td colspan="8"><button id="memeber_register_btn">추가</button></td></tr>
	</table>
	</form>

	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>
<script>
document.querySelector('#memeber_register_btn').addEventListener('click',function(){
	document.querySelector('#member_register_form').submit();
},false);
</script>