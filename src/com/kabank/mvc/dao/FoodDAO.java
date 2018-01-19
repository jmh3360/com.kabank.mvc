package com.kabank.mvc.dao;

import com.kabank.mvc.domain.FoodBean;

public interface FoodDAO {
	public FoodBean selectFoodById(String id);
}
