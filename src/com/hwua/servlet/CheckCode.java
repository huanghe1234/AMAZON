package com.hwua.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/doCheckCode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String veryCode = request.getParameter("veryCode");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("validateCode");
		
		
		if(!veryCode.equals(obj)){
			//验证码错误
			response.getWriter().write("0");
		}else{
			//验证码正确
			response.getWriter().write("1");
			
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
