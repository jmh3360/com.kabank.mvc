package com.kabank.mvc.serviceimpl;

import com.kabank.mvc.domain.FoodBean;
import com.kabank.mvc.service.FoodService;

public class FoodServiceImpl implements FoodService {

	public static FoodService getIstance() {
		return new FoodServiceImpl();
	}
	private FoodServiceImpl() {}
	@Override
	public FoodBean selectFoodById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
