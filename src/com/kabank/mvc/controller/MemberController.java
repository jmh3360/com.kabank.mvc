package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.ChangeCommand;
import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.DeleteCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.command.CreateCommand;
import com.kabank.mvc.command.SearchCommand;
import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.FoodBean;
import com.kabank.mvc.domain.LottoBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.MobileBean;
import com.kabank.mvc.enums.Action;
import com.kabank.mvc.factory.ActionFactory;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceimpl.AccountServiceImpl;
import com.kabank.mvc.serviceimpl.FoodServiceImpl;
import com.kabank.mvc.serviceimpl.LottoServiceImpl;
import com.kabank.mvc.serviceimpl.MemberServiceImpl;
import com.kabank.mvc.serviceimpl.MobileServiceImpl;
import com.kabank.mvc.util.DispatcherSelvlet;
import com.sun.xml.internal.ws.server.ServiceDefinitionImpl;

import javafx.scene.control.Alert;

@WebServlet({ "/user.do" }) // , urlPatterns = { "/MemberController" })
public class MemberController extends HttpServlet {
	MemberBean member;
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서블릿 내부------------------------------------");
		System.out.println("cmd값" + request.getParameter("cmd") + "/" + "dir 값" + request.getParameter("dir") + "/"
				+ "page 값" + request.getParameter("page"));
		HttpSession session = request.getSession();
		InitCommand init = new InitCommand(request);
		init.execute();
		System.out.println("액션값: " + InitCommand.cmd.getAction());
		switch (InitCommand.cmd.getAction())/*
											 * initcommand.cmd.getAction() cmd를 initcommand의 static변수로 만들어서 사용한다. 하지만 많이
											 * 만들면 안됨 전체에서 공통적으로 사용하는 것들만 사용한다
											 */ {
		case MOVE:
			System.out.println("========member : move IN======");
			move(request);
			System.out.println("DEST IS" + InitCommand.cmd.getView());
			System.out.println("===MEMBER-C: MOVE OUT==========");
			DispatcherSelvlet.send(request, response);
			break;
		case UPDATE_PASS:
			System.out.println("==========member-c : update passIn==========");
			member = new MemberBean();
			new ChangeCommand(request).execute();
			if (InitCommand.cmd.getData().equals(request.getParameter("change_pass_check"))) {

				member = (MemberBean) session.getAttribute("user");
				MemberServiceImpl.getInstance().updatePass(member);

				member.setPass(InitCommand.cmd.getData());
				session.setAttribute("user", member);

				move(request);
				System.out.println("DEST IS" + InitCommand.cmd.getView());
				DispatcherSelvlet.send(request, response);
				System.out.println("===========member-c : update pass out===========");
			} else {

			}

			break;
		case DELETE:
			System.out.println("================delete in==============");
			delete(request, response, session);
			System.out.println("============delete out=====================");
			break;
		case ADD:
			System.out.println("========member : ADD======");
			break;
		case LOGIN:
			System.out.println("========member-C : login======");
			new SearchCommand(request).execute();
			member = MemberServiceImpl.getInstance().login();
			System.out.println("memeberD 끝");
			 if(member == null) {
	                InitCommand.cmd.setDir("user");
	                InitCommand.cmd.setPage("login");
	            }else {
	                System.out.println("==== 로그인 성공 ====");
	                session.setAttribute("user", member);
	                myPage(request);
	                InitCommand.cmd.setDir("user");
	                InitCommand.cmd.setPage("mypage");
	            }
			move(request);
			System.out.println("DEST IS" + InitCommand.cmd.getView());
			DispatcherSelvlet.send(request, response);
			break;
		case LOGOUT:
			session.invalidate();
			move(request);
			DispatcherSelvlet.send(request, response);
			break;
		case JOIN:
			System.out.println("========member : join======");
			System.out.println("생년월일:" + request.getParameter("input_ssn" + "ssn2"));
			System.out.println("전화번호: " + request.getParameter("phone1" + "phone2" + "phone3"));
			new CreateCommand(request).execute();
			MemberServiceImpl.getInstance().newMember();
			move(request);
			DispatcherSelvlet.send(request, response);
			System.out.println("DEST IS" + InitCommand.cmd.getView());
		case MYPAGE:
			myPage(request);
			break;

		default:
			break;
		}

	}


	private void delete(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		new DeleteCommand(request).execute();
		MemberServiceImpl.getInstance().deleteMyId();
		System.out.println("DAOIMPL의 DeleteMyid?" + InitCommand.cmd.getData());
		System.out.println("DEST IS" + InitCommand.cmd.getView());
		session.invalidate();
		move(request);
		DispatcherSelvlet.send(request, response);
	}

	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
		
	}
	private void myPage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		member = (MemberBean) session.getAttribute("user");
		AccountBean a = AccountServiceImpl.getInstance().findAccountById(member.getId());
		MobileBean m = MobileServiceImpl.getInstance().findMobileById(member.getId());
        LottoBean l = LottoServiceImpl.getIstance().selectLottoById(member.getId());
        FoodBean f = FoodServiceImpl.getIstance().selectFoodById(member.getId());
        if(a!=null) {member.setAccount(a); }  
        if(m!=null) {member.setMobile(m); }  
        if(l!=null) {member.setLotto(l); }  
        if(f!=null) {member.setFood(f); }  
        session.setAttribute("user", member);           
	}

}
