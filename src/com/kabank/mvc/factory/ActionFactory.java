package com.kabank.mvc.factory;

import com.kabank.mvc.enums.Action;

public class ActionFactory {
	public static Action create(String x) {
		System.out.println("x의 경로" + x);
		Action action = null;
		if(x==null) {x="move";}
		switch (x) {
		case "move":action= Action.MOVE;break;

		default:
			break;
		}
		return action;
	}
}
