package com.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.demo.service.LoginService;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId,password; 
		userId=request.getParameter("userId");
		 password=request.getParameter("password");
		LoginService loginService=new LoginService();
		boolean result=loginService.authenticateUserLogin(userId, password);
		HttpSession session=request.getSession(true);
		session.setAttribute("userName", userId);
		//if (userId.equalsIgnoreCase("naga") && password.equalsIgnoreCase("123")) {
		if (result) {
			//response.sendRedirect("success.jsp");
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			//response.sendRedirect("signIn.jsp");
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
	}

}
