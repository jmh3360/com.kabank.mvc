package com.kabank.mvc.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao;
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
	}
	
	@Override
	public MemberBean findById (MemberBean m) {
		MemberBean mem = dao.selectMemberById(m);

		return mem;
	}
	@Override
	public void join(MemberBean bean) {
		System.out.println("서비스impl :\n"+bean);
		dao.memberJoin(bean);
	}


}
