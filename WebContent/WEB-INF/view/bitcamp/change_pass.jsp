<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>
<link rel="stylesheet" href="${css}/bitcamp.css" />

<body>
	<h1>비밀번호 변경</h1>
	<form id = "change" action="${ctx}/user.do">
		<table>
			<tr>
				<td><input name="current_pass" type="text"
					placeholder="현재 비밀번호 확인" /></td>
			</tr>
			<tr>
				<td><input name="change_pass" type="text"
					placeholder="변경할 비밀번호" /></td>
			</tr>
			<tr>
				<td><input name="change_pass_check" type="text"
					placeholder="변경할 비밀번호 확인" />
					<input type="hidden" name="cmd" value="move" />
						<input type="hidden" name="dir" value="bitcamp" />
						<input type="hidden" name="page" value="main" />
					</td>
					
			</tr>
			<tr>
				<td>
					<button id="ok">확인</button>
				</td>
			</tr>
		</table>

	</form>
	<%@ include file="../common/footer.jsp"%>
</body>
	<script>
		document.querySelector('#ok').addEventListener("click",function(){
			alert("변경확인");
			document.querySelector('#change').submit
		},false);
	</script>
</html>