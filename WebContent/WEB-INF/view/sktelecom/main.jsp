<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>
<section>
<article>
<div id="wrapper">
<h2> 에케메인</h2>
<table>
	<tr>
		<td colspan="3"><button id ="sktelecom-open" >개통</button></td>
	</tr>
	<tr>
		<td><button></button></td>
		<td><button></button></td>
		<td><button></button></td>
	</tr>
</table>

</div>
</article>
</section>
<aside></aside>
<%@ include file="../common/footer.jsp"%>
</body>
<script >
document.querySelector('#sktelecom-open').addEventListener('click',function(){
	location.href = "${ctx}/telecom.do?cmd=open&dir=user&page=mypage"
},false);
</script>
</html>