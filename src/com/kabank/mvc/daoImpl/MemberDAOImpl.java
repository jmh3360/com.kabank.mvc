package com.kabank.mvc.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.Oracle;
import com.kabank.mvc.factory.SqlFactory;
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
			DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().
			executeQuery(SqlFactory.create(6, " "+MemberEnum.ID.toString()+", "+MemberEnum.PASS.toString(),null));
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
			
			DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().
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
		System.out.println("=====selectMemberById IN======");
		System.out.println("====ID:"+m.getId());
		System.out.println("====ID:"+m.getPass());
		MemberBean mem = null;
		try {
			
			ResultSet rs = DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().
					executeQuery((String.format(DMLEnum.TUPLE_SERCH.toString(), InitCommand.cmd.getData(),m.getId())));
					
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
		System.out.println("====SPEC:"+m.toString());
		System.out.println("=====selectMemberById out======");
		return mem;
	}

	@Override
	public MemberBean login() {
		System.out.println("========member D: move IN======");
		StringBuffer sql = new StringBuffer(
				MemberEnum.LOGIN.toString());
		String[] arr = InitCommand.cmd.getData().split("/");
		System.out.println("ID :" + arr[0]);
		System.out.println("PASS :" +arr[1]);
		sql.replace(sql.indexOf("$"), sql.indexOf("$")+1, arr[0]);
		sql.replace(sql.indexOf("@"), sql.indexOf("@")+1, arr[1]);
		System.out.println(":::SQL:::"+sql.toString());
		MemberBean member = null;
		try {
			ResultSet rs = DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeQuery(sql.toString());
		while(rs.next()) {
			member = new MemberBean();
			member.setId(rs.getString(MemberEnum.ID.toString()));
			member.setPass(rs.getString(MemberEnum.PASS.toString()));
			member.setName(rs.getString(MemberEnum.NAME.toString()));
			member.setSsn(rs.getString(MemberEnum.SSN.toString()));
			member.setPhone(rs.getString(MemberEnum.PHONE.toString()));
			member.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
			member.setAddr(rs.getString(MemberEnum.ADDR.toString()));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		MemberBean m = null;
		System.out.println("========member D: move out======");
		return member;
	}

	@Override
	public void changePass(MemberBean member) {
		try {
			DataBaseFactory.create(Vendor.ORACLE).getConnection().
			createStatement().executeUpdate(String.format(DMLEnum.TUPLE_UPDATE_PASS.toString(), InitCommand.cmd.getData(),member.getId()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
