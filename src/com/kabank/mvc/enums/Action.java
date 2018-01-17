package com.kabank.mvc.enums;

public enum Action {
	MOVE,ADD,LOGIN,JOIN,SEARCH,UPDATE_PASS,DELETE,BANK_BOOK,
	VIEW{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "/WEB-INF/view/";
		}
	},
	EXTENSION{
		@Override
		public String toString() {
			return ".jsp";
		}
	},
	SEPARATOR{
		@Override
		public String toString() {
			
			return "/";
		}
	}
	
}
