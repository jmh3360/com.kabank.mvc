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
	ASTER{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "*";
		}
	}
}
