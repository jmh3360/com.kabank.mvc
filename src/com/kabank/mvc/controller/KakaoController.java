package com.kabank.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kabank.mvc.command.CreateCommand;
import com.kabank.mvc.command.InitCommand;
import com.kabank.mvc.command.MoveCommand;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.serviceimpl.AccountServiceImpl;
import com.kabank.mvc.util.DispatcherSelvlet;

@WebServlet("/kakao.do")
public class KakaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private int i;
       
       public KakaoController() {
		i = 1001;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("===========서블렛 내부 진입 for kakao==========="+request.getServletPath());
		HttpSession session = request.getSession();
		InitCommand init = new InitCommand(request);
		init.execute();
		switch (InitCommand.cmd.getAction()) {
		case BANK_BOOK:
			
			System.out.println("======kakaoController BANK_BOOK IN=======");
			new CreateCommand(request).execute();
			InitCommand.cmd.setData(((MemberBean)request.getAttribute("user")).getId());
			/*위의 방식을 사용하면 command patten을 사용할 필요가 없다.*/
			AccountServiceImpl.getInstance().createBankBook(String.valueOf(i++));
			
			new MoveCommand(request).execute();
			DispatcherSelvlet.send(request, response);
			
			break;

		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
