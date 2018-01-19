package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.LottoDAO;
import com.kabank.mvc.domain.LottoBean;

public class LottoDAOImpl implements LottoDAO {

	public static LottoDAO getIstance() {
		return new LottoDAOImpl();
	}
	private LottoDAOImpl() {}
	@Override
	public LottoBean selectLottoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
