package com.kabank.mvc.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.decorate.ExecuteQuery;
import com.kabank.mvc.decorate.ExecuteUpdate;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.Oracle;
import com.kabank.mvc.factory.SqlFactory;
import com.kabank.mvc.query.member.DeleteMemberQuery;
import com.kabank.mvc.query.member.FindAccountByIdQuery;
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
	public void changePass(MemberBean member) {
		try {
			DataBaseFactory.create(Vendor.ORACLE).getConnection().
			createStatement().executeUpdate(String.format(DMLEnum.TUPLE_UPDATE_PASS.toString(), InitCommand.cmd.getData(),member.getId()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	public MemberBean login() {
		System.out.println("MEMBER login으로 들어옴");
		/*System.out.println("========member D: move IN======");
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
		System.out.println("========member D: move out======");*/
		return (MemberBean) new ExecuteQuery(new LoginQuery()).execute();
				
	}

	
	@Override
	public void deleteMyId() {
		/*StringBuffer sql = new StringBuffer(DMLEnum.TUPLE_DELETE_MYID.toString());
		System.out.println("DAOIMPL의 DeleteMyid?"+InitCommand.cmd.getData());
		sql.replace(sql.indexOf("@"), sql.indexOf("@")+1, InitCommand.cmd.getData());
		System.out.println(":::SQL:::"+sql.toString());
		try {
			DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeUpdate(sql.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}*/
		new ExecuteQuery(new DeleteMemberQuery()).execute();
		
	}

	@Override
	public void newMember() {
		System.out.println("newMember id 값" + InitCommand.cmd.getCmap().get("input_id"));
		System.out.println
		(InitCommand.cmd.getCmap().get("input_ssn").toString().concat("-").concat(InitCommand.cmd.getCmap().get("input_ssn2").toString()));
		
		try {
			DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeUpdate(String.format(DMLEnum.INSERT_MEMBER.toString(),
					
					InitCommand.cmd.getCmap().get("input_id"),
					InitCommand.cmd.getCmap().get("input_pass"),
					InitCommand.cmd.getCmap().get("input_name"),
					InitCommand.cmd.getCmap().get("input_ssn").toString().
					concat("-").concat(InitCommand.cmd.getCmap().get("input_ssn2").toString()),
					InitCommand.cmd.getCmap().get("phone1")+"-"+InitCommand.cmd.getCmap().get("phone2")
				    +"-"+InitCommand.cmd.getCmap().get("phone3"),
					InitCommand.cmd.getCmap().get("input_email"),
					"",
					InitCommand.cmd.getCmap().get("input_addr")));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public MemberBean findAccountById(String id) {
		
		return (MemberBean) new ExecuteUpdate(new FindAccountByIdQuery()).execute();
	}
}
