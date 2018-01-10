package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.enums.PathEnum;
import com.kabank.mvc.service.MemberService;
import com.kabank.mvc.serviceimpl.MemberServiceImpl;

@WebServlet({"/user/login.do","/user/join.do","/user/auth.do","/user/memberjoin.do"})//, urlPatterns = { "/MemberController" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서블릿 내부------------------------------------");
		/*String path = request.getServletPath(); //webservlet의 값을 가져온다 
		String[] action = path.split("/");
		System.out.println("/로 쪼갬 :" + action[2]);
		String[] res = action[2].split("\\.");
		System.out.println(".으로 쪼개버려 :" + res[0]);*/
		/*
		 * String dest = "";
		 * switch(request.getServletPath().split("/")[2].split("\\.")[0]) {
		case "login" :
			dest ="/WEB-INF/view/user/login.jsp";
			break;
		case "join" :
			dest = "/WEB-INF/view/user/join_form.jsp";
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(dest);
		rd.forward(request, response);
		*/  /*간소화*/
		
		String dir = request.getServletPath().split(PathEnum.SEPARATOR.toString())[1];
		System.out.println(dir);
		String dest = request.getServletPath().split(PathEnum.SEPARATOR.toString())[2].split(PathEnum.DOT.toString())[0];
		System.out.println(dest);
		MemberBean m = new MemberBean();
		HttpSession session = request.getSession();
		MemberService service = MemberServiceImpl.getInstance();
		
		switch (dest) {
		case "auth": 
			m.setId(request.getParameter("index_input_id"));
			m.setPass(request.getParameter("index_input_pass"));
			MemberBean member =  service.findById(m);
			
			System.out.println("누구냐넌"+member);
			if(member != null) {
				dir = "bitcamp";
				dest ="main";
				session.setAttribute("user", member);
			}else {
				dir = "user";
				dest = "login";		
			}
			break;
		case "memberjoin" :
			dir = "user";
			dest = "login";
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
			((PathEnum.VIEW.toString()+dir+PathEnum.SEPARATOR.toString()+dest+PathEnum.EXTENSION));
			break;
		default:
			break;
		}
		System.out.println
		(PathEnum.VIEW.toString()+dir+PathEnum.SEPARATOR.toString()+dest+PathEnum.EXTENSION.toString());
		request.getRequestDispatcher
		(PathEnum.VIEW.toString()+dir+PathEnum.SEPARATOR.toString()+dest+PathEnum.EXTENSION.toString()).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
