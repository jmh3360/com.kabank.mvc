package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kabank.mvc.factory.ActionFactory;
import com.kabank.mvc.iterator.ParamsIterator;

public class InitCommand implements IOrder {
	public static Command cmd;
	
	Map<?, ?> map;
	public InitCommand(HttpServletRequest request) {
		cmd = new Command();
		map = ParamsIterator.execute(request);
	}
	@Override
	public void execute() {
		System.out.println("init//execute get.cmd?"+String.valueOf(map.get("cmd")));
		String o = String.valueOf(map.get("cmd"));
		if(o.equals("null")) {
			cmd.setAction(ActionFactory.create("move"));
		}else {
			System.out.println("액션이 정해졌다" + o);
		cmd.setAction(ActionFactory.create(o));
		}
	}
}
