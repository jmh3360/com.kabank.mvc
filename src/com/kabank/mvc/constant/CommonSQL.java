package com.kabank.mvc.constant;


public class CommonSql {
	public static String getCount(String tname) {
		return "SELECT COUNT(*) AS count FROM "+tname;
	}
	
}
