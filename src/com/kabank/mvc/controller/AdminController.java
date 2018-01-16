package com.kabank.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.dao.AdminDAO;
import com.kabank.mvc.daoImpl.AdminDAOImpl;
import com.kabank.mvc.enums.PathEnum;
import com.kabank.mvc.service.AdminService;
import com.kabank.mvc.serviceimpl.AdminServiceImpl;

@WebServlet({"/admin/main.do","/admin/member_list.do","/admin/create_table.do"})
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dir = request.getServletPath().split(PathEnum.SEPARATOR.toString())[1];
		String dest = request.getServletPath().split(PathEnum.SEPARATOR.toString())[2].split(PathEnum.DOT.toString())[0];
		switch (dest) {
		case "create_table":
				dir = "admin";
				dest = "main";
				AdminService service = new AdminServiceImpl();
				System.out.println("controller" + request.getParameter("table_name"));
				service.createTable(request.getParameter("table_name"));
			break;
		case  "member_list" :
			dir = "admin";
			dest = "member_list";
			break;
		case "main" :
			dir ="admin";
			dest ="main";
			break;
		default:
			break;
		}
		request.getRequestDispatcher(PathEnum.VIEW.toString() + dir + PathEnum.SEPARATOR.toString() + dest + PathEnum.EXTENSION.toString()).
		forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
