package com.kabank.mvc.serviceimpl;

import java.util.List;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.daoImpl.AdminDAOImpl;
import com.kabank.mvc.service.AdminService;

public class AdminServiceImpl implements AdminService {

	AdminDAO dao;
	public AdminServiceImpl() {
		dao = new AdminDAOImpl();
	}
	@Override
	public void createTable(String tname) {
		System.out.println("serviceimpl createtable() :"+tname);
	dao.createTable(tname);

	}

}
