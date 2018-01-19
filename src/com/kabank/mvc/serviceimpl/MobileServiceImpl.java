package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.daoImpl.MobileDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.MobileBean;
import com.kabank.mvc.service.MobileService;

public class MobileServiceImpl implements MobileService{
	public static MobileService getInstance() {return new MobileServiceImpl();}
	
	private MobileServiceImpl() {}

	@Override
	public void openPhone() {
		MobileDAOImpl.getInstance().openPhone();
	}

	@Override
	public MobileBean findMobileById(String id) {
		
		return MemberDAOImpl.getInstance().findMobileById(id);
	}
}
