package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.constant.Path;

@WebServlet({"/user/login.do","/user/join.do"})//, urlPatterns = { "/MemberController" })
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
		
		String dir = request.getServletPath().split(Path.SEPARATOR)[1];
		
		String dest = request.getServletPath().split(Path.SEPARATOR)[2].split(Path.DOT)[0];
		
		
		request.
		getRequestDispatcher(Path.VIEW+dir+Path.SEPARATOR+dest+Path.EXTENSION).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
