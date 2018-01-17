package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.DDL;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.MemberEnum;
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
					DDL.SELECT+" "
					+PropertiesFactory.create(MemberEnum.values())
					+" "
					+DDL.FROM
					+" "
					+Table.MEMBER
					+" "
					+DDL.WHERE
					+" id LIKE ? AND pass LIKE ?");
			
			String[] arr = InitCommand.cmd.getData().split("/");
			System.out.println("arr값"+arr[0]+arr[1]);
			for(int i = 0; i<arr.length;i++) {
				pstmt.setString((i+1), arr[i]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	@Override
	public Object execute() {
		MemberBean mem =null;
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mem = new MemberBean();
				mem.setId(rs.getString(MemberEnum.ID.toString()));
				mem.setPass(rs.getString(MemberEnum.PASS.toString()));
				mem.setName(rs.getString(MemberEnum.NAME.toString()));
				mem.setSsn(rs.getString(MemberEnum.SSN.toString()));
				mem.setPhone(rs.getString(MemberEnum.PHONE.toString()));
				mem.setEmail(rs.getString(MemberEnum.EMAIL.toString()));
				mem.setAddr(rs.getString(MemberEnum.ADDR.toString()));
				mem.setProfile(rs.getString(MemberEnum.PROFILE.toString()));
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("결과는"+mem.toString());
		return mem;
	}

}
