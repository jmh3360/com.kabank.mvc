package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.domain.LottoBean;
import com.kabank.mvc.service.LottoService;

public class LottoServiceImpl implements LottoService {

	public static LottoService getIstance() {
		return new LottoServiceImpl();
	}
	private LottoServiceImpl() {}
	@Override
	public LottoBean selectLottoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
