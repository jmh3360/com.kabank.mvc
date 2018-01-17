package com.kabank.mvc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.iterator.ParamsIterator;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class CreateCommand implements IOrder {
	Map<?, ?> map;
	String go; 
	HttpSession session;
	public CreateCommand(HttpServletRequest request) {
		map = ParamsIterator.execute(request);
		 go = request.getServletPath();
		session = request.getSession();
		 System.out.println("어디서 만들래?" + go);
		 System.out.println(session.getAttribute("user"));
	}
	@Override
	public void execute() {
		switch (go) {
		case "/kakao.do":
			System.out.println("switch 문 kakao.do로 들어옴");
			/* Memberbean bean = session.getAttribute("user") 이런식으로 해서 캐스팅 시키고 타입을 스트링으로
			 * 바꿔주면 getId가 붙는다.!!*/
			InitCommand.cmd.setData(((MemberBean) session.getAttribute("user")).getId());
			break;
		case "/user.do":
			System.out.println("NewMemeber map?"+map);
			InitCommand.cmd.setCmap(map);
			break;
		default:
			break;
		}
		
		
	}
	
}
