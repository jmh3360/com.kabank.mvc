package com.kabank.mvc.query.mobile;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.decorate.IQuery;
import com.kabank.mvc.enums.DDL;
import com.kabank.mvc.enums.Member;
import com.kabank.mvc.enums.MobileProps;
import com.kabank.mvc.enums.Table;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;
import com.kabank.mvc.factory.PropertiesFactory;

public class InsertMobileQuery implements IQuery {
	PreparedStatement pstmt;
	public InsertMobileQuery() {
		try {
			pstmt = DataBaseFactory.create(Vendor.ORACLE).getConnection().prepareStatement(
					DDL.INSERT+" "+DDL.INTO+" "+Table.MOBILE+" ("+PropertiesFactory.create(MobileProps.values())+") "+ 
							DDL.VALUES+" (customer_num.nextval, sysdate, ?, ?)");
			System.out.println("getdta에 뭐드름ㅇ?"+InitCommand.cmd.getData());
			String[] arr = InitCommand.cmd.getData().split("/");
			for(int i = 0;i<arr.length;i++) {
				pstmt.setString((i+1), arr[i]);
			}
					
					
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
