package com.kabank.mvc.daoImpl;



import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.dao.TelecomDAO;
import com.kabank.mvc.enums.DMLEnum;
import com.kabank.mvc.enums.Vendor;
import com.kabank.mvc.factory.DataBaseFactory;

public class TelecomDAOImpl implements TelecomDAO{
	public static TelecomDAO getInstance() {return new TelecomDAOImpl();}
	
	private TelecomDAOImpl() {}

	@Override
	public void openPhone(String phone) {
		System.out.println("핸드폰 번호 : "+phone);
		System.out.println("아이디 : "+InitCommand.cmd.getData());
		StringBuffer sql = new StringBuffer(DMLEnum.CREATE_PHONE.toString());
		try {
			DataBaseFactory.create(Vendor.ORACLE).getConnection().createStatement().executeUpdate(String.format(sql.toString(), "customer_num.nextval","2018-01-18",phone,"7"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
