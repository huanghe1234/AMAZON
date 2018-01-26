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

@WebServlet("/doCheckName")
public class CheckName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserService iub = new UserServiceImpl();
		String name = request.getParameter("userName");
	
		if(name==null||"".equals(name)){
			response.getWriter().write("-1");
		}else{
			//用户注册时   用户名唯一性约束			
			User u = iub.checkName(name);
			if(u !=null){
				//如果不为空说明用户名已经注册
				response.getWriter().write("1");
			}else{
				//如果为空说明用户名可以注册
				response.getWriter().write("0");
			}
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
