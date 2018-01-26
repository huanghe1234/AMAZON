package com.hwua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.Goods;
import com.hwua.service.IGoodsService;
import com.hwua.service.impl.GoodsServiceImpl;

@WebServlet("/doHot")
public class GoodsHot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得商品热度排行,根据库存进行排序,库存越少越收欢迎
		IGoodsService igs = new GoodsServiceImpl();
		List<Goods> hotGoods = igs.getGoodsHot();
		
		//将获得的商品集合传入到前段进行显示
		request.setAttribute("hotProducts", hotGoods);
		request.getRequestDispatcher("doShowHistory").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
