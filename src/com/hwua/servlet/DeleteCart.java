package com.hwua.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.service.ICartService;
import com.hwua.service.impl.CartServiceImpl;

@WebServlet("/doDeleteCart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scid = request.getParameter("cid");
		int cid = 1;
		if(scid!=null&&!"".equals(scid)){
			cid = Integer.parseInt(scid);
		}
		ICartService ics = new CartServiceImpl();
		int result = ics.deleteCart(cid);
		
		if (result==1){
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
