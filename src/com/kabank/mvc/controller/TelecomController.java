package com.kabank.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.daoImpl.TelecomDAOImpl;
import com.kabank.mvc.serviceimpl.TelecomServiceImpl;
import com.kabank.mvc.util.DispatcherSelvlet;

@WebServlet("/telecom.do")
public class TelecomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		new InitCommand(request).execute();
		switch (InitCommand.cmd.getAction()) {
		case OPEN_PHONE:
			System.out.println("갤럭시산다");
			TelecomServiceImpl.getInstance().openPhone();
			new MoveCommand(request);
			DispatcherSelvlet.send(request, response);
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
