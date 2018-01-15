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
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.command.SearchCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.Action;
import com.kabank.mvc.factory.ActionFactory;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceimpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherSelvlet;

import javafx.scene.control.Alert;

@WebServlet({"/user.do"})//, urlPatterns = { "/MemberController" })
public class MemberController extends HttpServlet {
	MemberBean member;
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서블릿 내부------------------------------------");
		System.out.println("cmd값" +request.getParameter("cmd")+"/"+
		"dir 값"+request.getParameter("dir")+"/"+"page 값"+request.getParameter("page"));
		HttpSession session = request.getSession();
		InitCommand init = new InitCommand(request);
		init.execute();
		
		switch (InitCommand.cmd.getAction())/*initcommand.cmd.getAction() 
		cmd를 initcommand의 static변수로 만들어서 사용한다. 하지만 많이 만들면 안됨 전체에서 공통적으로 사용하는
		것들만 사용한다  */{
		case MOVE: 
			System.out.println("========member : move IN======");
			move(request);
			System.out.println("DEST IS" + InitCommand.cmd.getView());
			System.out.println("===MEMBER-C: MOVE OUT==========");
			DispatcherSelvlet.send(request, response);
			break;
		case UPDATE_PASS :
			System.out.println("==========member-c : update passIn==========");
			/*String id = ((MemberBean) session.getAttribute("user")).getId();*/
			member = new MemberBean(); 
			new ChangeCommand(request).execute();
			System.out.println("비번"+InitCommand.cmd.getData()+"비번확인"+request.getParameter("change_pass_check"));
			System.out.println("변경할 비번" + InitCommand.cmd.getData());
			if(InitCommand.cmd.getData().equals(request.getParameter("change_pass_check"))) {
				member = (MemberBean) session.getAttribute("user");
				/*member.setId(id);*/
				MemberServiceImpl.getInstance().updatePass(member);
				member.setPass(InitCommand.cmd.getData());
				session.setAttribute("user", member);
				System.out.println("변경확인");
				System.out.println(member.toString());
				move(request);
				/*memr.setPass(id);*/
				System.out.println("DEST IS" + InitCommand.cmd.getView());
				DispatcherSelvlet.send(request, response);
				System.out.println("===========member-c : update pass out===========");
			}else {
				
			}
			
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
			member = new MemberBean();
			member.setId(request.getParameter("input_id"));
			member.setPass(request.getParameter("input_pass"));
			member.setName(request.getParameter("input_name"));
			member.setSsn(request.getParameter("input_ssn")+request.getParameter("ssn2"));
			member.setEmail(request.getParameter("input_email"));
			member.setAddr(request.getParameter("input_addr"));
			member.setPhone
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
		System.out.println("memeberD 끝");
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
