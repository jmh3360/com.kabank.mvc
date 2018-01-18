package com.kabank.mvc.decorate;

public class ExecuteUpdate extends QueryDecorator {

	public ExecuteUpdate(IQuery query) {
		super(query);
	}
	@Override
	public Object execute() {
		return super.execute();
	}

}
