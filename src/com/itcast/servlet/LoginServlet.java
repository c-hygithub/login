package com.itcast.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.entity.User;
import com.itcast.service.ServiceImp;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */


	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int age =Integer.parseInt( request.getParameter("age"));
		// 存入javabean
		User user = new User();
		user.setName(name);
		user.setAge(age);
		

		ServiceImp userImp = new ServiceImp();
		User existuser = userImp.login(user);
		if (existuser == null) {
			request.setAttribute("message", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		} else {

			/*request.getSession().setAttribute("user", existuser);*/
			response.setCharacterEncoding("utf-8");
			response.sendRedirect(request.getContextPath() + "/success.jsp");
			return;
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
