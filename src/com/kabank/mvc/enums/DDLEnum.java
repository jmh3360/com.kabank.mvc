package com.kabank.mvc.enums;

public enum DDLEnum {
	
	CREATE_TABLE_MEMBER{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "CREATE TABLE "
			+"MEMBER"
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
	
	},
	

		
		CREATE_TABLE_ATTEND{
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "CREATE TABLE Attendance("
				+"id VARCHAR2(20) PRIMARY KEY,"
				+"week VARCHAR2(10),"
				+"status VARCHAR2(10)"
				+")";
	}
		
	}
}
