package com.kabank.mvc.daoImpl;

import com.kabank.mvc.dao.FoodDAO;
import com.kabank.mvc.domain.FoodBean;

public class FoodDAOImpl implements FoodDAO {
	public static FoodDAO getIstance() {
		return new FoodDAOImpl();
	}
	private FoodDAOImpl() {}
	@Override
	public FoodBean selectFoodById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
