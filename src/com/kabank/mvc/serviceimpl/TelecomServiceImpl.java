package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.daoImpl.TelecomDAOImpl;
import com.kabank.mvc.service.TelecomService;

public class TelecomServiceImpl implements TelecomService{
	public static TelecomService getInstance() {return new TelecomServiceImpl();}
	
	private TelecomServiceImpl() {}

	@Override
	public void openPhone() {
		TelecomDAOImpl.getInstance().openPhone(
				String.valueOf("010-"+(int) (Math.random() * 8999 + 1000))+"-"
						+((int) (Math.random() * 8999 + 1000)));
	}
}
