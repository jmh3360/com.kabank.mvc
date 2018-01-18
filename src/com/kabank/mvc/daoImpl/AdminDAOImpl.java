package com.kabank.mvc.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.enums.DDLEnum;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.OracleEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.IDatabase;

import java.util.*;

public class AdminDAOImpl implements AdminDAO {

	public static AdminDAO getInstance() {
		return new AdminDAOImpl();
	}
	private AdminDAOImpl() {}
	
	@Override
	public List<String> createTable(String tname) {
		System.out.println("DAOIMPL cratetable()tname : "+tname);
		List<String> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		try {
			ResultSet rs =DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().
			executeQuery((new StringBuffer(DMLEnum.SELECT.toString()).insert(6, " " + DMLEnum.ASTER).append(DMLEnum.TAB).toString()));
			stmt = DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement();
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
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_MEMBER.toString());
					System.out.println("멤버 생성");
				}else if(tname.equalsIgnoreCase("attend")) {
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_ATTEND.toString());
					System.out.println("출석 생성");
				}else if(tname.equalsIgnoreCase("bank")) {
					System.out.println("bank위치");
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_BANK.toString());
				}else if(tname.equalsIgnoreCase("telecom")) {
					System.out.println("telecom위치");
					stmt.executeUpdate(DDLEnum.CREATE_TABLE_TELECOM.toString());
					
				}
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
