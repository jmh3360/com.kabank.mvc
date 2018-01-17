package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.service.AccountService;

public class AccountServiceImpl implements AccountService{
	public static AccountServiceImpl getInstance() {
		return new AccountServiceImpl();
	}
	private AccountServiceImpl() {}
	
}
