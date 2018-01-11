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
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.Action;
import com.kabank.mvc.factory.ActionFactory;
import com.kabank.mvc.factory.CommandFactory;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceimpl.MemberServiceImpl;
import com.kabank.mvc.util.DispatcherSelvlet;

@WebServlet({"/user.do"})//, urlPatterns = { "/MemberController" })
public class MemberController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서블릿 내부------------------------------------");
		
		MemberBean m = new MemberBean();
		InitCommand.init(request, response);
		HttpSession session = request.getSession();
		MemberService service = MemberServiceImpl.getInstance();
		
		String dest = "";
		switch (InitCommand.cmd.getAction()) {
		case MOVE: 
			System.out.println("========member : move======");
			DispatcherSelvlet.send(request, response);
			 
			m.setId(request.getParameter("index_input_id"));
			m.setPass(request.getParameter("index_input_pass"));
			MemberBean member =  service.findById(m);
			
		/*	System.out.println("누구냐넌"+member);
			if(member != null) {
				dir = "bitcamp";
				dest ="main";
				session.setAttribute("user", member);
			}else {
				dir = "user";
				dest = "login";		
			}*/
			break;
		case ADD:
			System.out.println("========member : ADD======");
			break;
		case LOGIN:
			System.out.println("========member : login======");
			String dir = request.getParameter("dir");
			String page = request.getParameter("page");
			member = new MemberBean();
			member.setId(request.getParameter("index_input_id"));
			member.setPass(request.getParameter("index_input_pass"));
			MemberBean result = null;
			result = MemberServiceImpl.getInstance().findById(member);
			if(result == null) {
				DispatcherSelvlet.send(request, response);
				
			}else {
				
			}
			
			System.out.println("========member : logout======");
			break;
		case JOIN :
			System.out.println("========member : join======");
			
			/*dir = "user";
			dest = "login";*/
			System.out.println("생년월일:" + request.getParameter("input_ssn" + "ssn2"));
			System.out.println("전화번호: " + request.getParameter("phone1" + "phone2" + "phone3"));
			m.setId(request.getParameter("input_id"));
			m.setPass(request.getParameter("input_pass"));
			m.setName(request.getParameter("input_name"));
			m.setSsn(request.getParameter("input_ssn" + "ssn2"));
			m.setEmail(request.getParameter("input_email"));
			m.setAddr(request.getParameter("input_addr"));
			m.setPhone(request.getParameter("phone1" + "phone2" + "phone3"));
			service.join(m);
			System.out.println
			((Action.VIEW.toString()+/*dir*/""+Action.SEPARATOR.toString()+dest+Action.EXTENSION));
			break;
		default:
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
