package com.kabank.mvc.daoImpl;

import java.sql.SQLException;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.AccountDAO;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

public class AccountDAOImpl implements AccountDAO {
	public static AccountDAOImpl getInstance() {
		return new AccountDAOImpl();
	}
	private AccountDAOImpl() {
		
	}
	public void createBankBook(String[] arr) {
		System.out.println("==========DAOIMPL createBankBook들어옴=========");
		System.out.println("========fk값 :"+InitCommand.cmd.getData());
		System.out.println("arr 값: "+arr);
		try {
			DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeUpdate(String.format(DMLEnum.CREATE_BANKBOOK.toString(), 
					"customer_num.nextval",
					arr[1],
					"0",
					InitCommand.cmd.getData()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
