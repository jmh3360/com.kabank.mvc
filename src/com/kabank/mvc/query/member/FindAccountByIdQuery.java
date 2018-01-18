package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DDL;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

public class FindAccountByIdQuery implements IQuery {
	PreparedStatement pstmt;
	public FindAccountByIdQuery() {
		
		try {
			pstmt = DataBaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
					DDL.SELECT
					+ " m.id,"
					+ "m.pass,"
					+ "m.name,"
					+ "m.ssn,"
					+ "m.phone,"
					+ "m.email,"
					+ "m.profile,"
					+ "m.addr,"
					+ "b.customer_num,"
					+ "b.account_num,"
					+ "b.money "
					+ DDL.FROM
					+" Member m, Bank b "
					+ DDL.WHERE
					+" m.id=b.id"
					+ " and m.id LIKE ? ");
			
			
			pstmt.setString(1, InitCommand.cmd.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Object execute() {
		MemberBean mem =null;
		AccountBean account = null;
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mem = new MemberBean();
				account = new AccountBean();
				mem.setId(rs.getString(MemberEnum.ID.toString()));
				mem.setPass(rs.getString(MemberEnum.PASS.toString()));
				mem.setName(rs.getString(MemberEnum.NAME.toString()));
				mem.setSsn(rs.getString(MemberEnum.SSN.toString()));
				mem.setPhone(rs.getString(MemberEnum.PHONE.toString()));
				mem.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				mem.setAddr(rs.getString(MemberEnum.ADDR.toString()));
				mem.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
				account.setCustomerNum(rs.getString("customer_num"));
				account.setAccountNum(rs.getString("account_num"));
				account.setMoney(rs.getString("money"));
				mem.setAccount(account);
				
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return mem;
	}

}
