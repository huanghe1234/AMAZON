package com.hwua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.Cart;
import com.hwua.entity.Order;
import com.hwua.entity.Orderdetail;
import com.hwua.entity.User;
import com.hwua.service.ICartService;
import com.hwua.service.IOrderService;
import com.hwua.service.impl.CartServiceImpl;
import com.hwua.service.impl.OrderServiceImpl;

@WebServlet("/doBuy")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取当前用户的购物车集合,查询里面的库存
		Object obj = request.getSession().getAttribute("user");
		User user = (User) obj;
		ICartService ics = new CartServiceImpl();
		boolean isOverStock = ics.getCart(user.getHu_user_id());
		
		// 1.获得从form表单中提取的内容
		int sum = 0;
		if(isOverStock){
		String[] sprice = request.getParameterValues("price");
		String[] scount = request.getParameterValues("number");
		String[] spid = request.getParameterValues("pId");
		String[] shpStock = request.getParameterValues("hpStock");
		String[] ssumPrice = request.getParameterValues("sumPrice");
		if (null != sprice && 0 != sprice.length && null != scount && 0 != scount.length && 0 != spid.length
				&& null != spid && null != shpStock && 0 != shpStock.length && null != ssumPrice
				&& 0 != ssumPrice.length) {
			int[] price = new int[sprice.length];
			int[] count = new int[scount.length];
			int[] pid = new int[spid.length];
			int[] hpStock = new int[shpStock.length];
			int[] sumPrice = new int[ssumPrice.length];

			// 把String类型的数字转换为int类型的数组
			for (int i = 0; i < sprice.length; i++) {
				price[i] = Integer.parseInt(sprice[i]);
			}

			for (int i = 0; i < scount.length; i++) {
				count[i] = Integer.parseInt(scount[i]);
			}

			for (int i = 0; i < price.length; i++) {
				sum = price[i] * count[i] + sum;
			}
			System.out.println("总和为:" + sum);

			for (int i = 0; i < spid.length; i++) {
				pid[i] = Integer.parseInt(spid[i]);
				
			}

			for (int i = 0; i < shpStock.length; i++) {
				hpStock[i] = Integer.parseInt(shpStock[i]);
			}

			for (int i = 0; i < ssumPrice.length; i++) {
				sumPrice[i] = Integer.parseInt(ssumPrice[i]);
			}

			// 2.获得当前用户的内容,生成一个订单
			IOrderService ios = new OrderServiceImpl();	
			int uid = user.getHu_user_id();
			String uname = user.getHu_user_name();
			String address = user.getHu_address();
			Order order = new Order(uid, uname, address);
			int result = ios.addOrder(order, pid, count, sum);
			System.out.println("订单的执行状态:"+result);
			if (result == 0){
				response.getWriter().write("0");
			}else{
				// 3.展示生成的订单
				Order ord = ios.showOrder(uid);
				// 4.生成订单详情
				int result2 = ios.insertOrderDetail(ord.getHo_id(), pid, count, sumPrice);
				// 5.显示订单详情
				List<Orderdetail> detailList = ios.showOrderDetail(ord.getHo_id());
				
				request.getSession().setAttribute("order", ord);
				request.getSession().setAttribute("olist", detailList);
				response.getWriter().write("1");
			}
		}	
		}else if(isOverStock==false){
			response.getWriter().write("-1");
		}else{
			response.getWriter().write("0");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
