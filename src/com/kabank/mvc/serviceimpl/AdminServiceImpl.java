package com.kabank.mvc.serviceimpl;


import com.kabank.mvc.daoImpl.AdminDAOImpl;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService {
	
	public static AdminService getInstance() {
		return new AdminServiceImpl();
	}
	private AdminServiceImpl() {}
	@Override
	public void createTable(String tname) {
		System.out.println("serviceimpl createtable() :"+tname);
	AdminDAOImpl.getInstance().createTable(tname);

	}

}
