package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.DDL;
import com.kabank.mvc.enums.Table;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

public class ChangePassQuery implements IQuery {
	PreparedStatement pstmt;
	public ChangePassQuery(String id) {
		try {
			pstmt = DataBaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
					DDL.UPDATE+" "+Table.MEMBER+" "+DDL.SET+" pass = ? "+DDL.WHERE+" id = ?"
					);
			pstmt.setString(1, InitCommand.cmd.getData());
			pstmt.setString(2, id);
		
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
