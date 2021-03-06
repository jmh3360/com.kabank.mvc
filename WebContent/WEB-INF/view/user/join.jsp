<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<link rel="stylesheet" href="${ctx}/resources/css/member.css" />
<body>
<%@ include file="../common/header.jsp"%>
<section>
<article>

<h2>회원가입</h2>

</article>
</section>
<aside></aside>
<form id = "join_form" action="${ctx}/user.do;"> <!-- 위치 경로를 servlet으로 보내고 
servlet에서 경로를 지정하여 이동한다.!!  -->
<table id="member_table">

<!-- 페이지 안에는 동일한 id가 존재해서는 안된다.  -->
	<tr>
	<td>ID </td>
		<td colspan="2">
		<input id ="input_id" name="input_id" type="text"  placeholder="ID" />
		 <button id ="check_dupl_btn" name= "check_dupl_btn" type="button" >중복확인</button></td>
	</tr>
	
	<tr>
	<td>Password </td>
		<td colspan="2"><input id ="input_pass" name="input_pass" type="text" name="pw" placeholder="비밀번호"/> 비밀번호가 일치합니다.</td>
		
	</tr>
	
	<tr>
	<td>Password(중복확인) </td>
		<td colspan="2"><input id ="input_pass_check" name="input_pass_check" type="text" name="pw2" placeholder="비밀번호 확인" />
		</td>
		
	</tr>
	
	<tr>
	<td>이름 </td>
		<td colspan="2"><input id ="input_name" type="text" name="input_name" placeholder="이름" /> </td>
	</tr>
	
	<tr>
	<td>가입일</td><td><input id ="input_startdate" name="input_startdate" type="date" /></td>
	</tr>
	
	<tr>
		<td>주민번호 </td>
		<td colspan="2"><input id ="input_ssn" name="input_ssn" type="text" /> -
		<input id ="input_ssn2" name="input_ssn2" type="text"  placeholder="앞 1자리"/> </td>
		
	</tr>
	
	<tr>
	<td>이메일 </td>
		<td colspan="2"><input id ="input_email" name="input_email" type="email"  placeholder="이메일"/>@
		<select id ="input_email2">
		<option >naver.com</option>
		<option >google.com</option>
		<option >daum.com</option>
		<option >nate.com</option>
		<option >yahoo.com</option>
		<option >op.gg</option>
		</select> </td> 
	
	</tr>
	<tr id="member_table_profile">
		<td>프로필</td>
		<td>프로필 사진</td>
		<td ><input id ="check_find_btn" name="check_find_btn" type="submit" value="찾아보기"/></td>
	</tr>
	<tr>
	<td>주소 </td>
		<td colspan="2"><input id ="input_addr" name="input_addr" type="text"  placeholder="주소" /> 
		<input id ="check_addrfind_btn" name="check_addrfind_btn" type="submit" value="주소찾기"/></td>
	</tr>
	<tr>
	<td>전화번호</td>
	<td >
	<select name = "phone1" style="width: 50px; height: 34px;">
	<option value="010">010</option>
	<option value="02">02</option>
	<option value="031">031</option>
	</select> -
	<input name="phone2" style="width: 80px; height: 30px;" pattern="[0-9]{4}" type="text" /> -
	<input name="phone3" style="width: 80px; height: 30px;" pattern="[0-9]{4}" type="text" />
	</td>	
	</tr>
	
	
	<tr><td colspan="3" style="text-align: center;" > <button id="join_confirm_btn" name="join_confirm_btn">회원가입</button>
	<input type="hidden" name = "cmd" value="join" />
	</td></tr>
</table>



</form>
<%@ include file="../common/footer.jsp"%>
<script>  /* form의 쌓여진 순간 location은 사용못한다 그래서 submit을 사용하면된다. */
/* var join_link = document.querySelector('#join_confirm_btn');
join_link.addEventListener("click",goLogin,false);
function goLogin() {
	
	document.querySelector('#join_form').submit();
} */

document.querySelector('#join_confirm_btn').addEventListener('click',function(){
	document.querySelector('#joun_form').submit();
},false);
/* form의 기능을 정의해준다. */
</script>
</body>
</html>