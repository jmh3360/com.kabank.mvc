package com.kabank.mvc.constant;


public class CommonSQL {
	public static String getCount(String tname) {
		return "SELECT COUNT(*) AS count FROM "+tname;
	}
	
}
