package com.kabank.mvc.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	
	private MemberServiceImpl() {}
	
	@Override
	public MemberBean findById (MemberBean m) {
		return MemberDAOImpl.getInstance().selectMemberById(m);
	}
	@Override
	public void join(MemberBean bean) {
		System.out.println("서비스impl :\n"+bean);
		MemberDAOImpl.getInstance().memberJoin(bean);
	}

	@Override
	public MemberBean login() {
		return MemberDAOImpl.getInstance().login()
				;
		
	}

	public void updatePass(MemberBean member) {
		MemberDAOImpl.getInstance().changePass(member);
	}

	public void deleteMyId() {
		MemberDAOImpl.getInstance().deleteMyId();
	}

	public void newMember() {
		MemberDAOImpl.getInstance().newMember();
		
	}


}
