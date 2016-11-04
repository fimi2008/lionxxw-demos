package com.lionxxw.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirsetServlet extends HttpServlet{

	private static final long serialVersionUID = -483790212754871196L;
	
	@Override
	public void init() throws ServletException {
		System.out.println(this.getClass().getSimpleName()+"init()调用~~~~~~~~~~~~~~~~");
		//super.init();
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println(this.getClass().getSimpleName()+"service()调用~~~~~~~~~~~~~~~~");
		//super.service(arg0, arg1);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(this.getClass().getSimpleName()+"doGet()调用~~~~~~~~~~~~~~~~");
		//super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(this.getClass().getSimpleName()+"doPost()调用~~~~~~~~~~~~~~~~");
		//super.doPost(req, resp);
	}
	
	@Override
	public void destroy() {
		System.out.println(this.getClass().getSimpleName()+"destroy()调用~~~~~~~~~~~~~~~~");
		//super.destroy();
	}
}