<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

	<link rel="stylesheet" href="${css}/common.css" />
	<link rel="stylesheet" href="${css}/index.css" />

<body>
<div id="wrapper">
<header id="index_header">
<h1> BIT CAMP SAMPLE <br /> PROJECT </h1>
</header>
<section id="index_section">
<article>
	<table id ="index_table">
		<tr >
			<td colspan="5">

		</tr>
		
		<tr >
			<td  colspan="5">
				
<!-- 	submit은 버튼 을 형성함
	text는 빈창을 생성하고 placeholder는 빈창에 미리보기기능
	  -->
			
			<form id = "go_bitcamp_link" action="${ctx}/user.do">
					<table id="index_login_box">
					<tr>
						<td>
						<input id="index_input_id" type="text" name="id" placeholder = "아이디" tabindex="1" value="jmh3360"/>
						</td>
						
						<td rowspan="2" >
						<button id="index_input_btn" >로그인</button>
						
						</td>
						
					</tr>
					
					<tr >
						<td >
						<input id="index_input_pass" name="pass" placeholder = "비밀번호" tabindex="2" value="123" />
						<input type="hidden" name="cmd" value="login" />
						<input type="hidden" name="page" value="mypage" />
						
						</td>
					</tr>
					
					</table>
				</form>
				<a id="go_admin_link" href="#">관리자</a>
				<a id="go_join_link" href="#">회원가입</a>
				<a id="go_jdbc_link" href="#">JDBCTest</a>
			
			</td>
		</tr>
	</table>
</article>
</section>
</div>
<%@ include file="../common/footer.jsp"%>
</body>
</html>
<script> 
document.querySelector('#go_join_link').addEventListener("click",function() {
	location.href = "${ctx}/user.do?dir=user&page=join";},false);

document.querySelector('#go_admin_link').addEventListener("click",function() {
	location.href = "${ctx}/admin/main.do"},false);

document.querySelector('#go_jdbc_link').addEventListener("click",function() {
	location.href = "${ctx}/common/jdbc_test.do"},false);
	
	document.querySelector("#index_input_btn").addEventListener("click",function(){
		alert('로그인입니다.');
		document.querySelector('#go_bitcamp_link').submit()
	},false);
	/* 스크립틀릿은 자바영역이기때문에 application을 사용하여 이동하지만 EL은jsp영역이이게 현재 page에 해당하는
    pageContext를 사용하여 이동한다. */
</script>
