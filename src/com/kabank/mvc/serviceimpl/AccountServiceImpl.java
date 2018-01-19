package com.kabank.mvc.serviceimpl;

import java.util.*;

import com.kabank.mvc.daoImpl.AccountDAOImpl;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.AccountService;

public class AccountServiceImpl implements AccountService{
	public static AccountServiceImpl getInstance() {
		return new AccountServiceImpl();
	}
	private AccountServiceImpl() {}
	public String[] createBankBook(String count) {
		System.out.println("acoountSeviceImpl createBook");
		String[] arr = new String[2];
		arr[0] = String.valueOf(count);
		Random r = new Random();
		boolean flag = true;
		while(flag) {
			int temp = r.nextInt(1000000);
			if(temp >100000) {
				System.out.println("temp의 크기"+temp);
				arr[1] = String.valueOf(temp);
				flag = false;
			}
		}
		AccountDAOImpl.getInstance().createBankBook(arr);
	
		return arr;
		
		
	}
	public AccountBean findAccountById(String id) {
		return MemberDAOImpl.getInstance().findAccountById(id);
	}
	
}
