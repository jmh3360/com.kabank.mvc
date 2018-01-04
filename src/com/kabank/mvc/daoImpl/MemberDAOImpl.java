package com.kabank.mvc.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.constant.CommonSQL;
import com.kabank.mvc.constant.DBMS;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<MemberBean> selectMembers() {
		String id = "";
		String pass = "";
		List<MemberBean> list = new ArrayList<MemberBean>();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			 conn = DriverManager.getConnection(DBMS.ORACLE_CONNECITON_URL,
						DBMS.ORACLE_USERNAME,DBMS.ORACLE_PASSWORD);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id,pass FROM Member");
			while(rs.next()) {
				MemberBean m = new MemberBean();
				id = rs.getString("id");
				pass = rs.getString("pass");
					m.setId(id);
					m.setPass(pass);
					list.add(m);
						}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		return list;
		}
	

}
