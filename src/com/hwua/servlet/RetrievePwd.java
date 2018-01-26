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

@WebServlet("/doRetrieve")
public class RetrievePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uName = request.getParameter("userName");
		String identity = request.getParameter("identity");
		String email = request.getParameter("email");
		
		User u = new User(uName,identity,email);
		//传入数据库中进行数据检查
		IUserService ius = new UserServiceImpl();
		User user = ius.queryUser(u);
		if(user == null){
			System.out.println("暂没有该用户");
			response.getWriter().write("0");
		}else{
			String pwd = user.getHu_password();
			response.getWriter().write(pwd);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
