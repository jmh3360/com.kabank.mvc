package com.kabank.mvc.daoImpl;



import com.kabank.mvc.dao.MobileDAO;
import com.kabank.mvc.decorate.ExecuteUpdate;
import com.kabank.mvc.query.mobile.InsertMobileQuery;

public class MobileDAOImpl implements MobileDAO{
	public static MobileDAO getInstance() {return new MobileDAOImpl();}
	
	private MobileDAOImpl() {}

	@Override
	public void openPhone() {
		
		new ExecuteUpdate(new InsertMobileQuery()).execute();
	}

}
