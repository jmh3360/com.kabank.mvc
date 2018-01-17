<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
<%@ include file="../common/header.jsp"%>
<%@ include file="../common/nav.jsp"%>
<section>
<article>
<div id="wrapper">
<h2> 카카오 메인</h2>
<table>
	<tr>
		<td id =create_passBook colspan="3" ><button>통장 개설</button></td>
		
	</tr>
	<tr>
		<td><button>입금</button></td>
		<td><button>출금</button></td>
		<td><button>송금</button></td>
	</tr>
</table>

</div>
</article>
</section>
<aside></aside>
<%@ include file="../common/footer.jsp"%>
</body>
<script>
document.querySelector('#create_passBook').addEventListener("click",function(){
	alert("통장개설")
	location.href = "${ctx}/kakao.do?cmd=bank_book&dir=user&mypage"
	
},false);
</script>
</html>