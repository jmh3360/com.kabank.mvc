package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.TnameEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

import java.sql.*;
public class CommonDAOImpl implements CommonDAO {

	
	@Override
	public String selectTableCount() {
		String count = "";
		try {
			ResultSet rs = DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().
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
