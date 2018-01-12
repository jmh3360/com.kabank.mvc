package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		System.out.println("x의 경로" + x);
		Action action = null;
		if(x==null || x.equals("") == true) {x="move";}
		System.out.println("Action FACTORY x(move)의값" +x);
		switch (x) {
		case "move":action= Action.MOVE;break;
		case "login":action= Action.LOGIN;break;
		default:
			action=Action.MOVE;
			break;
		}
		return action;
	}
}
