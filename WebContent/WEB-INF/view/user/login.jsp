<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Index</title>
	<link rel="shortcut icon" href="<%=application.getContextPath()%>/resources/img/favicon.ico" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/common.css" />
	<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/index.css" />
	<script src="../js/index.js"></script>
	<script src="../js/link.js"></script>
</head>

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
			
			<form action="burgerking/main.jsp">
					<table id="index_login_box">
					<tr>
						<td>
						<input id="index_input_id" type="text" name="id" placeholder = "아이디" tabindex="1"/>
						</td>
						
						<td rowspan="2" >
						<button id="index_input_btn" >로그인</button>
						
						</td>
						
					</tr>
					
					<tr >
						<td >
						<input id="index_input_pass" name="pw" placeholder = "비밀번호" tabindex="2"/>
						</td>
					</tr>
					
					</table>
				</form>
				<a id="go_admin_link" href="#">관리자</a>
				<a id="go_join_link" href="#">회원가입</a>
			
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
var join_link = document.querySelector('#go_join_link');
join_link.addEventListener("click",goJoin,false);
function goJoin() {
	location.href = "<%=application.getContextPath()%>/member/join.do";
	
}
</script>
