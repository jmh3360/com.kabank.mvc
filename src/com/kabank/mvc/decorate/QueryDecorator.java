package com.kabank.mvc.decorate;

	public abstract class QueryDecorator implements IQuery {
		protected IQuery query;
		public QueryDecorator(IQuery query) {
			this.query = query;
		}
		@Override
		public Object execute() {
			// TODO Auto-generated method stub
			return query.execute();
		}

}
