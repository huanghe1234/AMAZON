package com.hwua.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;

@WebServlet("/doCheckEmail")
public class CheckEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService iub = new UserServiceImpl();
		String email = request.getParameter("email");
		if(email==null||"".equals(email)){
			response.getWriter().write("-1");
		}else{
			//用户注册时    邮箱唯一性约束
			User email2 = iub.checkEmail(email);
			if(email2 != null){
				//该邮箱已经注册
				response.getWriter().write("1");
			}else {
				//可以注册
				response.getWriter().write("0");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
