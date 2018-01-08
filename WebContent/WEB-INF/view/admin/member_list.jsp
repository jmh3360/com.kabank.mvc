<%@page import="com.sun.org.apache.bcel.internal.generic.LSTORE"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%

Statement stmt = null;
Connection conn = null;
ResultSet rs = null;
String sql = null;
try{
	
	Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클 드라이버 소환
	 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
			,"bitcamp","bitcamp");  //오라클드라이버의 기능을 정해준 URL과 연결하여 사용할 수 있게하고 그것을 CONN에 담는다.
	stmt = conn.createStatement(); //기능이 정이된 conn에 담을수있는 statement라는 그릇을 만든다.
	sql = "SELECT * FROM tab"; // 모든 테이블을 읽어들여 sql에 담는다.
			
		rs = stmt.executeQuery(sql); // Resultset은 모든 타입을 받을수 있는 set이다, stmt에 sql(모든 테이블)을 담아 
		List<String> list = new ArrayList<>();
		while(rs.next()){
			String temp = rs.getString("TNAME"); //TNAME은 SCEHMA
			list.add(temp);
		}
		boolean exist =false;
		for(String s : list) {
			if(s.equalsIgnoreCase("member")){
				exist = true;
				break;
			}
		}
			if(!exist) {
				stmt.executeUpdate(
						"CREATE TABLE Member("
						+"id VARCHAR2(20) PRIMARY KEY,"
						+"pass VARCHAR2(20),"
						+"name VARCHAR2(20),"
						+"ssn VARCHAR2(20)," 
						+"phone VARCHAR2(20),"
						+"email VARCHAR2(20),"
						+"profile VARCHAR2(20),"
						+"addr VARCHAR2(20)" 
						+")");
			}else{
			rs = stmt.executeQuery("SELECT id,pass,name,ssn,phone,email,profile,addr from Member");
			//rs.next() 다음 값이 있으면 움직여라 
				while(rs.next()){
					String id = rs.getString("id");
					String name = rs.getString("name");
					String pass = rs.getString("pass");
					String ssn = rs.getString("ssn");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String profile = rs.getString("profile");
					String addr = rs.getString("addr");
					
				}
			}
		
}catch(Exception e){
	e.printStackTrace();
	
}finally{
	if(stmt !=null){
		try{stmt.close();}catch(Exception e){e.printStackTrace();}
	}if(conn !=null){
		try{conn.close();}catch(Exception e){e.printStackTrace();}
		
	}
	
}

%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/admin.css" />
</head>

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


<div >
	<table id="admin_table">
	<tr><th colspan = "8">
	<form id = "admin_serchbox" action=""><select id="admin_select"><option value="">이름</option>
	<option value="">id</option><option value="">성별</option></select>
	<input style="width: 400px;" id ="input_serch" type="text" /><button id ="input_serch_btn">검색</button></form>
	</th></tr>
		<tr>
		<th>NO</th>
		<th>아이디2</th>
		<th>이 름</th>
		<th>생년월일</th>
		<th>성별</th>
		<th>전화번호</th>
		<th>이메일</th>
		<th>주소</th>
		</tr>
		
		
		<tr><td colspan="8"><button id="member_register_form_btn">추가</button></td></tr>
	</table>
	</div>
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>
<script>
document.querySelector('#member_register_form_btn').addEventListener('click',function(){
	location.href = "${pageContext.request.contextPath}/admin/member_register_form.do";
},false);
</script>