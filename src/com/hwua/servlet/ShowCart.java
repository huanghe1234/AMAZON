package com.hwua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.Cart;
import com.hwua.entity.User;
import com.hwua.service.ICartService;
import com.hwua.service.impl.CartServiceImpl;

@WebServlet("/doShowCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得当前用户的id,根据用户id查询所有的购物车
		Object obj = request.getSession().getAttribute("user");
		User user = (User)obj;
		int uid  = user.getHu_user_id();
		//传入逻辑层进行判断得到商品
		ICartService ics = new CartServiceImpl();
		List<Cart> result = ics.showCart(uid);
		
		request.setAttribute("cart", result);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
