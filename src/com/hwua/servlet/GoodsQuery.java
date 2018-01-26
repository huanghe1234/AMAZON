package com.hwua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.Goods;
import com.hwua.entity.Pager;
import com.hwua.service.IGoodsService;
import com.hwua.service.impl.GoodsServiceImpl;

@WebServlet("/doQueryGoods")
public class GoodsQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goodsName = request.getParameter("goodsName");
		
		//将用户输入的内容进行逻辑判断,在输入数据库模糊查询
		IGoodsService igs = new GoodsServiceImpl();
		List<Goods> result = igs.getQueryGoods(goodsName);
				
		if(result == null || result.isEmpty()){
			response.getWriter().write("0");
		}else{
			request.setAttribute("pList", result);
			request.getRequestDispatcher("showQueryGoods.jsp").include(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
