package com.kabank.mvc.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.decorate.ExecuteQuery;
import com.kabank.mvc.decorate.ExecuteUpdate;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.MobileBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Member;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.Oracle;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.query.member.ChangePassQuery;
import com.kabank.mvc.query.member.DeleteMemberQuery;
import com.kabank.mvc.query.member.FindAccountByIdQuery;
import com.kabank.mvc.query.member.FindMobileByIdQuery;
import com.kabank.mvc.query.member.InsertMemberQuery;
import com.kabank.mvc.query.member.LoginQuery;
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
			executeQuery(SqlFactory.create(6, " "+Member.ID.toString()+", "+Member.PASS.toString(),null));
			while(rs.next()) {
				MemberBean m = new MemberBean();
				id = rs.getString(Member.ID.toString());
				pass = rs.getString(Member.PASS.toString());
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
				mem.setId(rs.getString(Member.ID.toString()));
				mem.setPass(rs.getString(Member.PASS.toString()));
				mem.setName(rs.getString(Member.NAME.toString()));
				mem.setSsn(rs.getString(Member.SSN.toString()));
				mem.setPhone(rs.getString(Member.PHONE.toString()));
				mem.setEmail(rs.getString(Member.EMAIL.toString()));
				mem.setAddr(rs.getString(Member.ADDR.toString()));
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
	public void changePass(MemberBean member) {
		new ExecuteUpdate(new ChangePassQuery(member.getId())).execute();
		
		
		
	}
	@Override
	public MemberBean login() {
		
		return (MemberBean) new ExecuteQuery(new LoginQuery()).execute();
				
	}

	
	@Override
	public void deleteMyId() {
		new ExecuteQuery(new DeleteMemberQuery()).execute();
		
	}

	@Override
	public void newMember() {
		
		new ExecuteUpdate(new InsertMemberQuery()).execute();
	}

	@Override
	public AccountBean findAccountById(String id) {
		
		return (AccountBean) new ExecuteUpdate(new FindAccountByIdQuery()).execute();
	}

	@Override
	public MobileBean findMobileById(String id) {
		
		return (MobileBean) new ExecuteUpdate(new FindMobileByIdQuery()).execute();
	}
}
