package com.kabank.mvc.query.member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.DDL;
import com.kabank.mvc.enums.MemberEnum;
import com.kabank.mvc.enums.Table;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.PropertiesFactory;

public class InsertMemberQuery implements IQuery {
	PreparedStatement pstmt;
	public InsertMemberQuery() {
		try {
			pstmt = DataBaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
					DDL.INSERT+" "+DDL.INTO+" "+Table.MEMBER+" "+ DDL.VALUES+"(?, ?, ?, ?, ?, ?, ?, ?)");
					pstmt.setString(1, InitCommand.cmd.getCmap().get("input_id").toString());
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Object execute() {
		// TODO Auto-generated method stub
		return null;
	}
}
