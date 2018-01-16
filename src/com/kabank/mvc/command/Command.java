package com.kabank.mvc.command;

import java.util.Map;

import com.kabank.mvc.enums.Action;

import lombok.Data;

@Data
public class Command  {
	protected String dir,page,search,column,cmd,data,view;
	protected Action action;
	protected Map<?, ?> cmap;

	
	}


