package com.kabank.mvc.enums;

public enum DDLEnum {
	INSERT,INTO,SELECT,WHERE,AND,FROM,VALUES,DELETE,
	
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
		
	},
		CREATE_TABLE_BANK{
		@Override
		public String toString() {
			return "CREATE TABLE Bank("
					+ "customer_num number primary key,"
					+ "account_num varchar2(20) not null,"
					+ "money varchar2(20) default 0,"
					+ "id varchar2(20) "
					+ "FOREIGN KEY (id) REFERENCES Member(id) ON DELETE CASCADE)";
		}
	},
		CREATE_TABLE_TELECOM{
		@Override
		public String toString() {
			return "CREATE TABLE Telecom("
					+ "customer_num number primary key,"
					+ "regdate date,"
					+ "num varchar2(20),"
					+ "id varchar2(20) "
					+ "FOREIGN KEY (id) REFERENCES Member(id) ON DELETE CASCADE)";
		}
	}
}
