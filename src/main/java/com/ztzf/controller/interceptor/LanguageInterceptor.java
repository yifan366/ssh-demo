package com.ztzf.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ztzf.controller.base.I18N;

/**
 * 国际化的拦截器，所有action请求过来后，都要先走这个国际化的拦截器
 * modified by：Rain  2014-3-5
 */
public  class LanguageInterceptor extends I18N implements HandlerInterceptor  {

	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		
		//检查语言环境，有变化就改变语言的资源文件。
		checkAndGetLanguage(req,resp);
		
		return true;
	}
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}


	
}
