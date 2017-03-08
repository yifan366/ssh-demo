package com.ztzf.controller.base;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ztzf.utils.internationalization.ResourcesUtil;
import com.ztzf.controller.base.BaseControllerSupport;

/**
 * 这个是在Controller层，也就是action请求时，做一个国际化的语言判断并获取相应的语言文件。
 * modified by：Rain  2014-3-5
 */
public class I18N extends BaseControllerSupport{

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	//这个的map用于存放，不同语言环境，相对应properties语言国际化文件
	protected Map<String,String> L;
	
	/**
	 * 用于检测语言环境，并提供相对应语言properties，的国际化文件。 默认情况下 是中文，在都探测不到的情况下会到初始化配置文件systemInitail中取。
	 * 语言检查的顺序是：参数中语言变量 > Session中的 > Cookies中的 > 浏览器的语言环境 > 默认中文
	 * 在每次action请求过filter时会检查一次；显示调用LanguageController中改变语言环境的方法时会调用。
	 * modified by：Rain  2014-3-6
	 */
	protected void checkAndGetLanguage(HttpServletRequest request,HttpServletResponse response) {
		this.request = request;
		this.response = response;
		//这个变量，是用来记录当前系统的语言环境。下边这句是指用户传送过来的，在切换语言的action时会用到
		String languageStatus = request.getParameter("request_locale");
		//如果页面中未携带语言参数，则在Session寻找语言参数
		if (languageStatus == null) {
			languageStatus =  (String) request.getSession().getAttribute("request_locale");	
		}
		//如果Session中未携带语言参数，则在Cookie中寻找，此判断是为了避免因网络环境导致SessionID的丢失。
		if(languageStatus == null){
			languageStatus = this.getCookieValue("request_locale", null, null,request);
		}
		//如果cookie中未携带语言参数或者用户禁用Cookie，则在浏览器的语言环境中获取语言参数。
		if(languageStatus == null){
			languageStatus = request.getLocale().toString();
		}
		//如果还没有找到，赋给一个默认值，这个默认值可以从初始化资源文件中取得。
		if(languageStatus == null){
			languageStatus = ResourcesUtil.systemInitial.get("defaul_language");
		}
		
		//将语言环境存同时放着Session和Cookie中
		request.getSession().setAttribute("request_locale", languageStatus);
		this.addCookie("request_locale", null, null, null, languageStatus,response);
		//将此线程局部变量的当前线程副本中的request设置为我们指定的值。
		RequestThread4Language.threadLocal.set(request);
		
		//如果当前由用户的环境或者用户发出的请求，获取到的语言值与开关值不一致，就变换语言的资源文件。否则不更新资源文件的Map L。
		this.getLanguageResource(languageStatus);
		
		//将语言环境存同时放着Session和Cookie中
		request.getSession().setAttribute("L", this.L);
	}

	/**
	 * 根据当前语言值，给语言Map L设置对应的语言内容信息。
	 * modified by：Rain  2014-3-6
	 */
	protected void getLanguageResource(String languageStatus) {	
		//这里先只有两种语言中文和英文，以后可能有更多，如果以后真的可能有...God Bless...
		if (languageStatus.startsWith("zh")) {
			this.L = ResourcesUtil.ZH_CN;
		} else {
			this.L = ResourcesUtil.EN_US;
		}
	}
}
