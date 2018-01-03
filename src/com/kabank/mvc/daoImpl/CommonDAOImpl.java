package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.CommonDAO;
import java.sql.*;
public class CommonDAOImpl implements CommonDAO {

	@Override
	public String selectTableCount() {
		String count = "";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"bitcamp","bitcamp");
			stmt = conn.createStatement();
			String sql = "SELECT COUNT(*) AS count FROM tab";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				count = rs.getString("count"); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}
