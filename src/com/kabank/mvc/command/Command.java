package com.kabank.mvc.command;

import com.kabank.mvc.enums.Action;

public class Command  {
	protected String dir,page,search,column,cmd,data,view;
	

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	protected Action action;

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = (page==null) ? "login":page;
			
		
	}


	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	

	
	
		
	}


