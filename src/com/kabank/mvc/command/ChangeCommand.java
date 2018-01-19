package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.iterator.ParamsIterator;

public class ChangeCommand implements IOrder{
	
	Map<?, ?> map;
	
	public ChangeCommand(HttpServletRequest request) {
		map = ParamsIterator.execute(request);
		
	}
	@Override
	public void execute() {
		String newPass = String.valueOf(map.get("change_pass"));
		
		InitCommand.cmd.setData(newPass);
		System.out.println("ChangeCommand map입니다."+map);
	}

}
