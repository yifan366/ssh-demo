package com.ztzf.controller.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SecurityServlet extends HttpServlet implements Filter {
	/**
	 * 登录拦截器
	 */
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession(true);
		String user_id = (String) session.getAttribute("id");// 登录人角色
		String url = request.getRequestURI();
		String path = request.getContextPath();      
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		if (user_id == null || "".equals(user_id)) {
				// 判断获取的路径不为空且不是访问登录页面或执行登录操作时跳转
				if (url != null && !url.equals("") && url.indexOf("login") < 0) {
					if(url.contains("action")){
						PrintWriter out = response.getWriter();
						StringBuilder builder = new StringBuilder();
						builder.append("sessionTimeOut");
						out.print(builder.toString());
						out.close();
					}else{
						String UrlParam = request.getParameter("t");
						if(UrlParam!=null){
							String allUrl = request.getRequestURL() + "?" + request.getQueryString();
							 PrintWriter out = response.getWriter();  
			                 StringBuilder builder = new StringBuilder();  
			                 builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");  
			                 builder.append("parent.showLoginWindow('"+allUrl+"');");  
			                 builder.append("</script>");  
			                 out.print(builder.toString());  
			                 out.close();  
						}else{
							response.sendRedirect(basePath
									+ "/login.jsp");
						}
					}
					return;
				}
			}
			arg2.doFilter(arg0, arg1);
			return;
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
