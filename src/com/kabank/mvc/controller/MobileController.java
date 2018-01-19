package com.kabank.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kabank.mvc.command.CreateCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.serviceimpl.MobileServiceImpl;
import com.kabank.mvc.util.DispatcherSelvlet;

@WebServlet("/telecom.do")
public class MobileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		InitCommand init = new InitCommand(request);
		init.execute();
		switch (InitCommand.cmd.getAction()) {
		case OPEN_PHONE:
			
			System.out.println("====TelecomController OPEN_PHONE=========");
			new CreateCommand(request).execute();
			MobileServiceImpl.getInstance().openPhone();
			new MoveCommand(request).execute();
			DispatcherSelvlet.send(request, response);
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
