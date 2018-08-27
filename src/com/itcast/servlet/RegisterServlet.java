package com.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itcast.entity.User;
import com.itcast.service.ServiceImp;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取数据
		String name=request.getParameter("name");
		
		int age = Integer.parseInt(request.getParameter("age"));
	
		long phone = Long.parseLong(request.getParameter("phone"));
		
		int id = Integer.parseInt(request.getParameter("id"));
		//存入javabean
		User user = new User();
		user.setAge(age);
		user.setId(id);
		user.setName(name);
		user.setPhone(phone);
		System.out.println(user.getAge());
		
		ServiceImp si=new ServiceImp();
		
		try {
			if(si.login(user)==null){
			si.add(user);
			
			
				response.setCharacterEncoding("utf-8");
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}else{
			
				request.setAttribute("register.message","注册失败用户已存在");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	
	}

}
