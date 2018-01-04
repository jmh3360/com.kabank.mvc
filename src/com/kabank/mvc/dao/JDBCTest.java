package com.kabank.mvc.dao;

import java.sql.*;

import com.kabank.mvc.constant.DBMS;

public class JDBCTest {
	public static void main(String[] args) {
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECITON_URL,
					 DBMS.ORACLE_USERNAME,DBMS.ORACLE_PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT COUNT(*) AS count FROM tab";
			ResultSet rs = stmt.executeQuery(sql);
			String count = "";
			while(rs.next()) {
				count = rs.getString("count");
			}
			System.out.println("테이블수 : " +count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
