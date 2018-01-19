<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<link rel="stylesheet" href="${css}/admin.css" />
<body>
<%@ include file="../common/header.jsp"%>
<header id="admin_header"><h2>관리자 페이지</h2></header>
	<div id = "admin_main_wrapper">
	<aside id="admin_sidebar" >
	<ul >
		<li>관리자 화면</li>
		<li><a id = "member_mgmt_link">회원관리</a></li>
	</ul>
	</aside>
<section id = "admin_section">

	<table id="admin_table">
		<tr>
			<td  > <button id="table_btn"> 테이블</button> </td>
			<td >준비중</td>
			<td >준비중</td>
		</tr>
		<tr>
			<td >준비중</td>
			<td >준비중</td>
			<td >테이블 생성 <br />
				<form id ="create_table" action="${ctx}/admin/create_table.do">
					<select name = table_name>
						<option  value ="member" >회원 테이블</option>
						<option  value="attend">출석 테이블</option>
						<option  value="bank">뱅크 테이블</option>
						<option  value="mobile">telecom 테이블</option>
					</select>
					<input type="text" placeholder="생성할 테이블 명" />
					<button id ="create_table_btn">생성</button>
				</form>
			</td> 
		</tr>
	</table>
	
	</section>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>
<script>
document.querySelector('#table_btn').addEventListener('click',function(){
	location.href = "${ctx}/admin/member_list.do";
},false);

document.querySelector('#create_table_btn').addEventListener("click",function(){
	document.querySelector('#create_table').submit;
},false);

</script>