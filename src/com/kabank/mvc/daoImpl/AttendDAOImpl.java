package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.AttendDAO;
import com.kabank.mvc.domain.AttendBean;

public class AttendDAOImpl implements AttendDAO {
	
	public static AttendDAO getIstance() {
		return new AttendDAOImpl();
	}
	private AttendDAOImpl() {}
	@Override
	public AttendBean selectAttendById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
