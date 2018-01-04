package com.kabank.mvc.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.kabank.mvc.dao.MemberDAO;
import com.kabank.mvc.daoImpl.MemberDAOImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao;
	public MemberServiceImpl() {
		dao = new MemberDAOImpl();
	}
	@Override
	public boolean login(MemberBean m) {
		boolean foo = false;
		
		List<MemberBean> list = dao.selectMembers();
			
		for(int i = 0; i<list.size(); i++) {
				if(m.getId().equals(list.get(i).getId())
						&&m.getPass().equals(list.get(i).getPass())) {
					foo = true;
					
				}
			}
		return foo;
	}

}
