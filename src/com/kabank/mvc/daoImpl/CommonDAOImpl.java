package com.kabank.mvc.daoImpl;

import com.kabank.mvc.constant.CommonSql;
import com.kabank.mvc.constant.DBMS;
import com.kabank.mvc.dao.CommonDAO;
import java.sql.*;
public class CommonDAOImpl implements CommonDAO {

	
	@Override
	public String selectTableCount() {
		String count = "";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBMS.ORACLE_CONNECITON_URL,
					DBMS.ORACLE_USERNAME,DBMS.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(CommonSql.getCount("Member"));
			while(rs.next()) {
				count = rs.getString("count"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
