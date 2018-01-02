<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>JDBC TEST</title>
</head>
<body>
	<%
	try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", //연결 
			"bitcamp", "bitcamp"); 
	Statement stmt = conn.createStatement();
	String sql = "SELECT * FROM tab"; 
	ResultSet rs = stmt.executeQuery(sql); //실행하는 부분
	String count = "";
	while(rs.next()){
		count = rs.getString("tname"); //결과 전송
	}
	System.out.println("테이블 이름 :" + count);
	%>테이블 갯수는<%=count %> 입니다.<%
	}catch(Exception e){
		e.printStackTrace();
	}
	
	%>
	
</body>
</html>