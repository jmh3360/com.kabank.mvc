package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.dao.CommonDAO;
import com.kabank.mvc.daoImpl.CommonDAOImpl;
import com.kabank.mvc.service.CommonService;

public class CommonServiceImpl implements CommonService {
	CommonDAO dao;

	public CommonServiceImpl() {
		dao = new CommonDAOImpl();
	}

	@Override
	public String coutTable() {
		return dao.selectTableCount();
	}

}
