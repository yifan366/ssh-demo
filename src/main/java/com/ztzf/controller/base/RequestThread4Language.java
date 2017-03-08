package com.ztzf.controller.base;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取当前线程的副本,ThreadLocal是线程的一个副本--用于国际化
 * modified by：Rain  2014-3-6
 */
public class RequestThread4Language {
	public static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<HttpServletRequest>();
	// 用于在发生一次请求时，记录上下文LogId
	public static ThreadLocal<String> logIdLocal = new ThreadLocal<String>();
}
