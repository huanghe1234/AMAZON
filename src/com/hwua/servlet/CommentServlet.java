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

@WebServlet("/addComment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICommentService ics = new CommentServiceImpl();
		String gName = request.getParameter("guestName");
		String gTitle = request.getParameter("guestTitle");
		String gContent = request.getParameter("guestContent");
		Comment com = new Comment(gTitle,gContent,gName);
		
		if(gName==null||"".equals(gName)||gTitle==null || "".equals(gTitle) || gContent==null || "".equals(gContent)){
			response.getWriter().write("0");
		}else{
			//传入至逻辑判断层
			int result = ics.addComment(com);
			if (result == 1){
				response.getWriter().write("1");
			}else{
				response.getWriter().write("0");
			}
		}
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
