package com.kabank.mvc.util;

public class MainTest {
	public static void main(String[] args) {
		for(Enums.MemberColumn c: Enums.MemberColumn.values()) { //values는 이미 만들어진 메소드다.
			System.out.println("컬럼명" + c);
		}
	}
}
