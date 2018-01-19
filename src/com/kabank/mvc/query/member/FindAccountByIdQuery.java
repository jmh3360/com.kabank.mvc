package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DDL;
import com.kabank.mvc.enums.Member;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

public class FindAccountByIdQuery implements IQuery {
	PreparedStatement pstmt;
	public FindAccountByIdQuery() {
		
		try {
			pstmt = DataBaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
					DDL.SELECT
					 +" account_num,"
                     +"customer_num,"
                     +"money "
                     +DDL.FROM
                     +" bank  "
                     +DDL.WHERE
                     +" id LIKE ?");
			
			System.out.println(DDL.SELECT
					 +"account_num,"
                     +"customer_num,"
                     +"money "
                     +DDL.FROM
                     +" bank  "
                     +DDL.WHERE
                     +" id LIKE ?");
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
				mem.setId(rs.getString(Member.ID.toString()));
				mem.setPass(rs.getString(Member.PASS.toString()));
				mem.setName(rs.getString(Member.NAME.toString()));
				mem.setSsn(rs.getString(Member.SSN.toString()));
				mem.setPhone(rs.getString(Member.PHONE.toString()));
				mem.setEmail(rs.getString(Member.EMAIL.toString()));
				mem.setAddr(rs.getString(Member.ADDR.toString()));
				mem.setProfile(rs.getString(Member.PROFILE.toString()));
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
