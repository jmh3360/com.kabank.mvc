package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Vendor;

public class DataBaseFactory {
	public static Database createDatabase(Vendor vendor) {
		Database db = null;
		
		switch (vendor) {
		case ORACLE:
			db = new Oracle();
			break;

		default:
			break;
		}
		return db;
	}
}
