package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		System.out.println("action 탐"+x);
		Action action = null;
		if(x==null || x.equals("") == true) {x="move";}
		switch (x) {
		case "move":action= Action.MOVE;break;
		case "login":action= Action.LOGIN;break;
		case "update_pass" :action = Action.UPDATE_PASS; break;
		case "delete" : action = Action.DELETE; break;
		case "join" : action = Action.JOIN;break;
		case "bank_book": action = Action.BANK_BOOK;break;
		case "open": action = Action.OPEN_PHONE;break;
		case "mypage": action = Action.MYPAGE;break;
		case "logout": action = Action.LOGOUT; break;

				default:
			action=Action.MOVE;
			break;
		}
		System.out.println("action값"+action);
		return action;
	}
}
