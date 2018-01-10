package com.kabank.mvc.enums;

public enum MemberEnum {
	ID, PASS, NAME, SSN, PHONE, EMAIL, PROFILE, ADDR,
	PROPERTIES{
		@Override
		public String toString() {
			return ID+","+PASS+","+NAME+","+SSN+","+PHONE+","+EMAIL+","+PROFILE+","+ADDR;
		}
	}
}
