package com.hwua.servlet;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.entity.User;
import com.hwua.service.IUserService;
import com.hwua.service.impl.UserServiceImpl;

@WebServlet("/doAction")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		// 注册登录的表现层
		IUserService iub = new UserServiceImpl();
		switch (action) {

		case "register":
			// 获取表单中携带的数据

			String name = request.getParameter("userName");
			String pwd = request.getParameter("passWord");
			String rePwd = request.getParameter("rePassWord");
			String sex = request.getParameter("sex");
			String data = request.getParameter("birthday");

			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date birthday = null;
			try {
				birthday = sd.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			java.sql.Date birthday2 = new java.sql.Date(birthday.getTime());

			String identity = request.getParameter("identity");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			String veryCode = request.getParameter("veryCode");
			HttpSession session = request.getSession();
			Object reg = session.getAttribute("validateCode");
			if ("".equals(name) || "".equals(pwd) || "".equals(rePwd) || "".equals(sex) || "".equals(data)
					|| "".equals(identity) || "".equals(email) || "".equals(address) || "".equals(veryCode)) {
				response.getWriter().write("-1");
			} else {
				// 将数据封装为对象传入逻辑层进行判断
				User u = new User(name, pwd, sex, birthday2, identity, email, mobile, address);

				if (pwd.equals(rePwd) && veryCode.equals(reg)) {
					int result = iub.insertUser(u);
					if (result == 1) {
						// 说明注册成功
						response.getWriter().write("1");
						System.out.println("注册成功");
					} else {
						// 注册失败
						response.getWriter().write("0");
					}
				} else if (!veryCode.equals(reg)) {
					System.out.println("验证码不正确");
					response.getWriter().write("0");
				} else if (!pwd.equals(rePwd)) {
					System.out.println("两次输入的密码不一致");
					response.getWriter().write("0");
				}
				session.invalidate();
			}
			break;

		case "login":
			// 获取表单中携带的数据
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			String inputCode = request.getParameter("veryCode");
			HttpSession session2 = request.getSession();
			Object loginCode = session2.getAttribute("validateCode");

			// 将数据封装为对象,传入逻辑层进行判断
			User uLogin = new User(userName, passWord);
			if (inputCode.equals(loginCode)) {
				User loginResult = iub.loginUser(uLogin);
				if (loginResult != null) {
					// 登录成功
					System.out.println("登录成功!");
					HttpSession session3 = request.getSession();
					// 存入域中用户名和密码
					session3.setAttribute("user", loginResult);
					response.getWriter().write("1");
					// request.getRequestDispatcher("index.jsp").forward(request,
					// response);
				} else {
					// 登录失败
					response.getWriter().write("0");
				}

			} else {
				// -1验证码错误
				response.getWriter().write("-1");
			}

			break;
		case "checkOut":
			HttpSession session3 = request.getSession();
			session3.invalidate();
			System.out.println("退出成功!");
			request.getRequestDispatcher("doQuery").forward(request, response);
			break;

		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
