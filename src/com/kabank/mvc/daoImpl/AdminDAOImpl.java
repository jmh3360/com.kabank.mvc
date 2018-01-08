package com.kabank.mvc.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.constant.AdminSql;
import com.kabank.mvc.constant.DBMS;
import com.kabank.mvc.dao.AdminDAO;
import java.util.*;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public List<String> createTable(String tname) {
		System.out.println("DAOIMPL cratetable()tname : "+tname);
		List<String> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			conn = DriverManager.getConnection(DBMS.ORACLE_CONNECITON_URL,DBMS.ORACLE_USERNAME,DBMS.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tab");
			while(rs.next()) {
				String temp = rs.getString("TNAME");
				list.add(temp);
			}
			boolean foo = false;
			for(String s: list) {
				if(s.equalsIgnoreCase(tname)) {
					foo = true;
					break;
				}
				
			}
			if(!foo) {
				if(tname.equalsIgnoreCase("member")) {
					stmt.executeUpdate(AdminSql.CREATE_MEMBER(tname));
					System.out.println("멤버 생성");
				}else if(tname.equalsIgnoreCase("attend")) {
					stmt.executeUpdate(AdminSql.CREATE_ATTEND);
					System.out.println("출석 생성");
					
				}
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
