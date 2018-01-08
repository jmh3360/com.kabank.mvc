package com.kabank.mvc.constant;

public class AdminSql {
			public static String CREATE_MEMBER(String tname) {
		return "CREATE TABLE "
				+tname
				+"("
				+" ID VARCHAR2(20) PRIMARY KEY,"
				+" pass VARCHAR2(20), "
				+" name VARCHAR2(20), "
				+" ssn VARCHAR2(20), "
				+" phone VARCHAR2(20), "
				+" email VARCHAR2(20), "
				+" profile VARCHAR2(20), "
				+" addr VARCHAR2(20) "
				+")";
	}
	public static final String CREATE_ATTEND =
			"CREATE TABLE Attendance("
					+"id VARCHAR2(20) PRIMARY KEY,"
					+"week VARCHAR2(10),"
					+"status VARCHAR2(10)"
					+")";
}
