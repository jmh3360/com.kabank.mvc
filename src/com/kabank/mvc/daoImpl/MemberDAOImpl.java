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
	
	public static MemberDAO getInstance() {
		return new MemberDAOImpl();
	}
	
	private MemberDAOImpl() {
		try {
			Class.forName(DBMS.ORACLE_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberBean> selectMembers() {
		String id = "";
		String pass = "";
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			
			ResultSet rs = DriverManager.getConnection(DBMS.ORACLE_CONNECITON_URL,
						DBMS.ORACLE_USERNAME,DBMS.ORACLE_PASSWORD).createStatement().executeQuery("SELECT id,pass FROM Member");
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
		try {
			
			DriverManager.getConnection(
					DBMS.ORACLE_CONNECITON_URL,
					DBMS.ORACLE_USERNAME,
					DBMS.ORACLE_PASSWORD).createStatement().executeQuery(String.format("%s %s %s("
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
							));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberBean selectMemberById(MemberBean m) {
		MemberBean mem = null;
		try {
			ResultSet rs = DriverManager.getConnection(DBMS.ORACLE_CONNECITON_URL, DBMS.ORACLE_USERNAME, DBMS.ORACLE_PASSWORD).
			createStatement().executeQuery(String.format("SELECT * FROM MEMBER WHERE id ='%s' AND pass='%s'", m.getId(),m.getPass()));
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
