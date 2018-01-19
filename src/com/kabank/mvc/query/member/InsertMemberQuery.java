package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.DDL;
import com.kabank.mvc.enums.Member;
import com.kabank.mvc.enums.Table;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.PropertiesFactory;

public class InsertMemberQuery implements IQuery {
	PreparedStatement pstmt;
	public InsertMemberQuery() {
		try {
			pstmt = DataBaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
					DDL.INSERT+" "+DDL.INTO+" "+Table.MEMBER+" ("+PropertiesFactory.create(Member.values())+") "+ 
							DDL.VALUES+" (?, ?, ?, ?, ?, ?, ?, ?)");
					pstmt.setString(1, InitCommand.cmd.getCmap().get("input_id").toString());
					pstmt.setString(2, InitCommand.cmd.getCmap().get("input_pass").toString());
					pstmt.setString(3, InitCommand.cmd.getCmap().get("input_name").toString());
					pstmt.setString(4, InitCommand.cmd.getCmap().get("input_ssn").toString().
					concat("-").concat(InitCommand.cmd.getCmap().get("input_ssn2").toString()));
					pstmt.setString(5, InitCommand.cmd.getCmap().get("phone1")+"-"
					+InitCommand.cmd.getCmap().get("phone2")+"-"+InitCommand.cmd.getCmap().get("phone3"));
					pstmt.setString(6, InitCommand.cmd.getCmap().get("input_email").toString());
					pstmt.setString(7, "defalut_img.jsp");
					pstmt.setString(8, InitCommand.cmd.getCmap().get("input_addr").toString());
					System.out.println("vlaue값"+Member.values());
					
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Object execute() {
		String temp = "";
		try {
			temp = String.valueOf(pstmt.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
}
