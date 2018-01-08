package com.kabank.mvc.util;

public class Enums {
	//enum은 맞춤표시인 ;을 해주면 안된다.
	public enum MemberColumn {
		ID,PASS,NAME,SSN,PHONE,EMAIL,PROFILE,ADDR
	}
	public enum AttendColumn{
		ID,PASS,NAME
	}
	public enum TABLE{
		MEMBER,ATTEND,ADIMIN
	}
	public enum DML{
		SELECT,INSERT,INTO,UPDATE,DELETE,FROM
	}
	public static String getEnu() {
		String enu = "";
		Enums.MemberColumn[] en =Enums.MemberColumn.values();
		for(int i=0; i<en.length;i++) {
			System.out.println("en : "+en[i]);
			if(i==en.length-1) {
				enu+=en[i];
			}else {
				enu+=en[i]+",";
			}
		}
		return enu;
	}
	public static String getBlanks(int count) {
		String  blanks="";
		for(int i = 0;i<count;i++) {
			if(i==count-1) {
				blanks += "'%s'";
			}else {
				blanks +="'%s',";
			}
		}
		return blanks;
	}
}
