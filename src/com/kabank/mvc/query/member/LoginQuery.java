package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DDL;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Member;
import com.kabank.mvc.enums.Table;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.PropertiesFactory;
import com.kabank.mvc.util.Enums.TABLE;

public class LoginQuery implements IQuery {
	PreparedStatement pstmt;
	public LoginQuery() {
		
		try {
			pstmt = DataBaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
					DDL.SELECT
					+ " id,"
					+ "pass,"
					+ "name,"
					+ "ssn,"
					+ "phone,"
					+ "email,"
					+ "profile,"
					+ "addr "
					+ DDL.FROM
					+" Member "
					+ DDL.WHERE
					+ " id LIKE ? AND pass LIKE ?");
			
			
			String[] arr = InitCommand.cmd.getData().split("/");
			for(int i = 0; i<arr.length;i++) {
				pstmt.setString((i+1), arr[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Object execute() {
		MemberBean mem =null;
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mem = new MemberBean();
				mem.setId(rs.getString(Member.ID.toString()));
				mem.setPass(rs.getString(Member.PASS.toString()));
				mem.setName(rs.getString(Member.NAME.toString()));
				mem.setSsn(rs.getString(Member.SSN.toString()));
				mem.setPhone(rs.getString(Member.PHONE.toString()));
				mem.setEmail(rs.getString(Member.EMAIL.toString()));
				mem.setAddr(rs.getString(Member.ADDR.toString()));
				mem.setProfile(rs.getString(Member.PROFILE.toString()));
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return mem;
	}

}
