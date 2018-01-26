package com.hwua.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.entity.Comment;
import com.hwua.service.ICommentService;
import com.hwua.service.impl.CommentServiceImpl;
import com.hwua.tools.Pager;

@WebServlet("/doShowComment")
public class ShowComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ICommentService ics = new CommentServiceImpl();
		
		// 获得当前下标页
		int pageNum = 1;
		String page = request.getParameter("page");
		if (page != null && !"".equals(page)) {
			pageNum = Integer.parseInt(page);
		}
		Pager pager = new Pager(pageNum);
		//获得评论列表
		List<Comment> list = ics.showComment(pager);
		
		request.setAttribute("allComments", list);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("guestbook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
