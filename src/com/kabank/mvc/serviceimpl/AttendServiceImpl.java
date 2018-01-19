package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.domain.AttendBean;
import com.kabank.mvc.service.AttendSerivice;

public class AttendServiceImpl implements AttendSerivice {
	
	public static AttendSerivice getIstance() {
		return new AttendServiceImpl();
	}
	private AttendServiceImpl() {}
	@Override
	public AttendBean selectAttendById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
