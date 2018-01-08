package com.kabank.mvc.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.constant.AdminSql;
import com.kabank.mvc.constant.CommonSql;
import com.kabank.mvc.constant.DBMS;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.util.Enums;

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

	@Override
	public void memberJoin(MemberBean bean) {
		System.out.println("쿼리문 진입");
		Statement stmt;
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn=DriverManager.getConnection(
					DBMS.ORACLE_CONNECITON_URL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD);
			stmt=conn.createStatement();
			String a=
					String.format("%s %s %s("
							+Enums.getEnu()+")"
							+ " VALUES("
							+Enums.getBlanks(Enums.MemberColumn.values().length)
							+")",
							Enums.DML.INSERT,
							Enums.DML.INTO,
							Enums.TABLE.MEMBER,
							bean.getId(),
							bean.getName(),
							bean.getPass(),
							bean.getSsn(),
							bean.getPhone(),
							bean.getEmail(),
							bean.getProfile(),
							bean.getAddr()
							);
			System.out.println(a);
			stmt.executeQuery(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberBean selectMemberById(MemberBean m) {
		MemberBean mem = null;
		String sql = "SELECT * FROM MEMBER WHERE id =? AND pass = ?";
		String id = "";
		String pass = "";
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection(DBMS.ORACLE_CONNECITON_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPass());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				mem = new MemberBean();
				mem.setId(rs.getString("id"));
				mem.setPass(rs.getString("pass"));
				mem.setName(rs.getString("name"));
				mem.setSsn(rs.getString("ssn"));
				mem.setPhone(rs.getString("phone"));
				mem.setEmail(rs.getString("email"));
				mem.setAddr(rs.getString("addr"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mem;
	}
}
