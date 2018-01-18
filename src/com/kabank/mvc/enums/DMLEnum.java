package com.kabank.mvc.enums;

public enum DMLEnum {
	TAB,COUNT,
	TABLE_COUNT{
		@Override
		public String toString() {
			return "SELECT COUNT(*) AS count FROM ";
		}
	},
	SELECT{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "SELECT FROM ";
		}
	},
	TUPLE_SERCH{
		@Override
		public String toString() {
			return "SELECT * FROM MEMBER WHERE id ='%s' AND pass='%s'";
		}
		
	},
	TUPLE_UPDATE_PASS{
		@Override
		public String toString() {
			
			return "UPDATE MEMBER SET PASS = '%s' where id = '%s'";
		}
	},
	TUPLE_DELETE_MYID{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "DELETE FROM Member WHERE id ='@'";
		}
	},
	INSERT_MEMBER{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "INSERT INTO Member(id,pass,name,ssn,phone,email,profile,addr) VALUES('%s',"
					+ "'%s','%s','%s','%s','%s','%s','%s')";
		}
	},
	CREATE_BANKBOOK{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "INSERT INTO Bank(customer_num,account_num,money,id) VALUES("
					+ "%s,'%s','%s','%s')";
		}
	},
	ASTER{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "*";
		}
	}, FROM, WHERE,
	CREATE_PHONE{
		@Override
		public String toString() {
			return "INSERT INTO Telecom(customer_num,regdate,num,id) values (%s,'%s','%s','%s')";
		}
	}
}
