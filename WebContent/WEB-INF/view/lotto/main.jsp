<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%@ include file="../common/head.jsp"%>
<body>
<%@ include file="../common/header.jsp"%>

<%@ include file="../common/nav.jsp"%>
<section>
<article>
<div id="wrapper">
<form action="result.jsp">
<table id =><tr><td>
	구매 금액 : <input type="text" name="money" placeholder="게임당 1000원 최대 5게임"/>
	<input type="submit" value="전 송"/>
</td></tr>
</table>
</form>
</div>
</article>
</section>

<aside></aside>
<%@ include file="../common/footer.jsp"%>

</body>
<script src="../../js/lotto/lotto.js"></script>
</html>