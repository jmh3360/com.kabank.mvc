package com.kabank.mvc.dao;

import java.util.List;

import com.kabank.mvc.domain.MemberBean;

public interface MemberDAO {
	public List<MemberBean> selectMembers();
	public void memberJoin(MemberBean bean);
	public MemberBean selectMemberById(MemberBean m);
	public MemberBean login();
	public void changePass(MemberBean member);
	public void deleteMyId();
	public void newMember();
}
