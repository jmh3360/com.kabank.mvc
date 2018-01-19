package com.kabank.mvc.service;

import com.kabank.mvc.domain.MobileBean;

public interface MobileService {

	public void openPhone();

	public MobileBean findMobileById(String id);

}
