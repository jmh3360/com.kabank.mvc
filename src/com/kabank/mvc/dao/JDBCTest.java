package com.kabank.mvc.dao;

import java.sql.*;

import com.kabank.mvc.enums.OracleEnum;
import com.kabank.mvc.factory.Oracle;

public class JDBCTest {
	public static void main(String[] args) {
		try {
			Class.forName(OracleEnum.ORACLE_DRIVER.toString());
			Connection conn = DriverManager.getConnection(OracleEnum.ORACLE_CONNECITON_URL.toString(),
					OracleEnum.ORACLE_USERNAME.toString(),OracleEnum.ORACLE_PASSWORD.toString());
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
