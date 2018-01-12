package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kabank.mvc.enums.Action;
import com.kabank.mvc.iterator.ParamsIterator;

public class SearchCommand implements IOrder{
	Map<?, ?> map;
	public SearchCommand(HttpServletRequest request) {
		map = ParamsIterator.execute(request);
	}
	@Override
	public void execute() {
		String id = String.valueOf(map.get("id"));
		String pass = String.valueOf(map.get("pass"));
		InitCommand.cmd.setColumn("id/pass");
		InitCommand.cmd.setData(id+"/"+pass);
		
	}
	
}
