package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.AccountDAO;

public class AccountDAOImpl implements AccountDAO {
	public static AccountDAOImpl getInstance() {
		return new AccountDAOImpl();
	}
	private AccountDAOImpl() {
		
	}
}
