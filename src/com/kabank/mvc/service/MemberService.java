package com.kabank.mvc.service;

import com.kabank.mvc.domain.MemberBean;

public interface MemberService {
	public MemberBean findById (MemberBean m);
	public void join(MemberBean bean);
	public MemberBean login();
}
