package com.hwua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.Goods;
import com.hwua.entity.History;
import com.hwua.entity.User;
import com.hwua.service.IGoodsService;
import com.hwua.service.impl.GoodsServiceImpl;

@WebServlet("/doShowHistory")
public class ShowHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object obj = request.getSession().getAttribute("user");
		IGoodsService igs = new GoodsServiceImpl();
		
		if(obj !=null ) {
			User user = (User)obj;
			int uid  = user.getHu_user_id();
			List<History> list = igs.showHistory(uid);
			
			request.setAttribute("history", list);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
