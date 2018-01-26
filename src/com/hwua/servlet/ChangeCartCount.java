package com.hwua.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.service.ICartService;
import com.hwua.service.impl.CartServiceImpl;

@WebServlet("/doChangeCount")
public class ChangeCartCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = 1;
		int count = 1;
		//一个购物车的id,里面包含(商品对象,商品id,商品数量,用户id)
		String scid = request.getParameter("cid");
		String scount = request.getParameter("count");
		if(scid!=null && !"".equals(scid)){
			cid = Integer.parseInt(scid);
		}
		if(scount!=null&&!"".equals(scount)){
			count = Integer.parseInt(scount);
		}
		ICartService ics = new CartServiceImpl();
		//根据购物里面的购物id修改 商品的数量
		int result = ics.changeCount(cid,count);
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
