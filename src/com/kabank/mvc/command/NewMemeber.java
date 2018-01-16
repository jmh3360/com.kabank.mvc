package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.iterator.ParamsIterator;

public class NewMemeber implements IOrder {
	Map<?, ?> map;
	public NewMemeber(HttpServletRequest request) {
		map = ParamsIterator.execute(request);
		
		
	}
	@Override
	public void execute() {
		System.out.println("NewMemeber map?"+map);
		InitCommand.cmd.setCmap(map);
		
	}
	
}
