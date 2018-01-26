package com.hwua.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.entity.Cart;
import com.hwua.entity.User;
import com.hwua.service.ICartService;
import com.hwua.service.impl.CartServiceImpl;

@WebServlet("/doAddCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spid = request.getParameter("pid");
		String scount = request.getParameter("count");
		Object obj = request.getSession().getAttribute("user");
		User user = (User)obj;
		int uid  = user.getHu_user_id();
		//将数据封装为对象进行数据传输
		int pid = 1;
		int count = 1;
		if(spid!=null && !"".equals(spid)){
			pid = Integer.parseInt(spid);
		}
		if(scount!=null && !"".equals(scount)){
			count = Integer.parseInt(scount);
		}
		System.out.println("商品id:"+ pid);
		System.out.println("商品数量:"+ count);
		System.out.println("用户id:"+uid);
		Cart cart = new Cart(pid,count,uid);
		ICartService ics = new CartServiceImpl();
		int result = ics.addCart(cart);
		
		if(result == 1 ){
			System.out.println("添加成功");
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
