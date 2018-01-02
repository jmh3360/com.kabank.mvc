package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/member/login.do","/member/join.do"})//, urlPatterns = { "/MemberController" })
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서블릿 내부------------------------------------");
		String path = request.getServletPath(); //webservlet의 값을 가져온다 
		String dest = "";
		System.out.println("리퀘스트가 걸어온 길 :" + path);
		switch(path) {
		case "/member/login.do" :
			dest ="/WEB-INF/view/user/login.jsp";
			break;
		case "/member/join.do" :
			dest = "/WEB-INF/view/user/join_form2.jsp";
			break;
		}
		RequestDispatcher rd1 = request.getRequestDispatcher(dest);
		rd1.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
