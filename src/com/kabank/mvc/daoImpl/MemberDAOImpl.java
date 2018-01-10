package com.kabank.mvc.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.Oracle;
import com.kabank.mvc.util.Enums;

public class MemberDAOImpl implements MemberDAO {
	
	public static MemberDAO getInstance() {
		return new MemberDAOImpl();
	}
	
	private MemberDAOImpl() {}
	
	@Override
	public List<MemberBean> selectMembers() {
		String id = "";
		String pass = "";
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			StringBuffer buff = new StringBuffer(DMLEnum.SELECT.toString());
			ResultSet rs =
			DataBaseFactory.createDatabase(Vendor.ORACLE).getConnection().createStatement().
			executeQuery(buff.insert(6, " "+MemberEnum.ID+", "+MemberEnum.PASS).toString());
			
			while(rs.next()) {
				MemberBean m = new MemberBean();
				id = rs.getString(MemberEnum.ID.toString());
				pass = rs.getString(MemberEnum.PASS.toString());
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
			
			DataBaseFactory.createDatabase(Vendor.ORACLE).getConnection().createStatement().
			executeQuery(String.format("%s %s %s("
					+Enums.getEnu()+")"
					+ " VALUES("
					+Enums.getBlanks(Enums.MemberColumn.values().length)
					+")",
					Enums.DML.INSERT,
					Enums.DML.INTO,
					Enums.TABLE.MEMBER,
					bean.getId(),
					bean.getPass(),
					bean.getName(),
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
			ResultSet rs = DataBaseFactory.createDatabase(Vendor.ORACLE).getConnection().createStatement().
					executeQuery((String.format(DMLEnum.TUPLE_SERCH.toString(), m.getId(),m.getPass())));
					
			while(rs.next()) {
				mem = new MemberBean();
				mem.setId(rs.getString(MemberEnum.ID.toString()));
				mem.setPass(rs.getString(MemberEnum.PASS.toString()));
				mem.setName(rs.getString(MemberEnum.NAME.toString()));
				mem.setSsn(rs.getString(MemberEnum.SSN.toString()));
				mem.setPhone(rs.getString(MemberEnum.PHONE.toString()));
				mem.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				mem.setAddr(rs.getString(MemberEnum.ADDR.toString()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mem;
	}
}
