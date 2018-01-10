package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.OracleEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

import java.sql.*;
public class CommonDAOImpl implements CommonDAO {

	
	@Override
	public String selectTableCount() {
		String count = "";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(OracleEnum.ORACLE_DRIVER.toString());
			ResultSet rs = DataBaseFactory.createDatabase(Vendor.ORACLE).getConnection().createStatement().
			executeQuery(DMLEnum.COUNT.toString()+TnameEnum.MEMBER);
			while(rs.next()) {
				count = rs.getString(DMLEnum.COUNT.toString()); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

}
