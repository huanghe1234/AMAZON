package com.hwua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.News;
import com.hwua.service.INewsService;
import com.hwua.service.impl.NewsServiceImpl;

@WebServlet("/doNewsQuery")
public class NewsQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		INewsService ins = new NewsServiceImpl();
		List<News> listNews = ins.getNewsList();

		if(listNews!=null){
			request.setAttribute("news", listNews);
			request.getRequestDispatcher("doHot").include(request, response);
		}else{
			response.getWriter().write("error");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
