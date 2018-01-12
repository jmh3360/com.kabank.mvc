package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.Command;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.command.SearchCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.Action;
import com.kabank.mvc.factory.ActionFactory;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceimpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherSelvlet;

@WebServlet({"/user.do"})//, urlPatterns = { "/MemberController" })
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서블릿 내부------------------------------------");
		
		HttpSession session = request.getSession();
		InitCommand init = new InitCommand(request);
		init.execute();
	
		switch (InitCommand.cmd.getAction()) {
		case MOVE: 
			System.out.println("========member : move IN======");
			move(request);
			System.out.println("DEST IS" + InitCommand.cmd.getView());
			System.out.println("===MEMBER-C: MOVE OUT==========");
			DispatcherSelvlet.send(request, response);
			break;
		case UPDATE_PASS :
			System.out.println("member-c : update passIn");
			
			String currentPass = request.getParameter("current_pass");
			String changePass = request.getParameter("change_pass");
			String changePassCheck = request.getParameter("change_pass_check");
			DispatcherSelvlet.send(request, response);
			break;
		case ADD:
			System.out.println("========member : ADD======");
			break;
		case LOGIN:
			System.out.println("========member-C : login======");
			login(request, session);
			System.out.println("DEST IS" + InitCommand.cmd.getView());
			DispatcherSelvlet.send(request, response);
			break;
		case JOIN :
			System.out.println("========member : join======");
			System.out.println("생년월일:" + request.getParameter("input_ssn" + "ssn2"));
			System.out.println("전화번호: " + request.getParameter("phone1" + "phone2" + "phone3"));
			MemberBean m = new MemberBean();
			m.setId(request.getParameter("input_id"));
			m.setPass(request.getParameter("input_pass"));
			m.setName(request.getParameter("input_name"));
			m.setSsn(request.getParameter("input_ssn")+request.getParameter("ssn2"));
			m.setEmail(request.getParameter("input_email"));
			m.setAddr(request.getParameter("input_addr"));
			m.setPhone
			(request.getParameter("phone1")+request.getParameter("phone2")+request.getParameter("phone3"));
			break;
		default:
			break;
		}
		
	}

	private void move(HttpServletRequest request) {
		new MoveCommand(request).execute();
	}

	private void login(HttpServletRequest request, HttpSession session) {
		new SearchCommand(request).execute();
		
		MemberBean member = MemberServiceImpl.getInstance().login();
		if(member==null) {
			InitCommand.cmd.setDir("user");
			InitCommand.cmd.setPage("login");
		}else {
			session.setAttribute("user", member);
			InitCommand.cmd.setDir("bitcamp");
			InitCommand.cmd.setPage("main");
		}
		move(request);
	}
}
