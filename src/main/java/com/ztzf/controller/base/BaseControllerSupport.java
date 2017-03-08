package com.ztzf.controller.base;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ztzf.utils.internationalization.ResourcesUtil;

/**
 * 这个是在Controller层，也就是action请求和相应时，需要调用的一个公用类，里边有很多公用方法。
 * modified by：Rain  2014-3-5
 */
public class BaseControllerSupport {

	/**
	 * 跟据Key获取Cookie，key 必须
	 * modified by：Rain  2014-3-6
	 * @param request 
	 */
	protected Cookie getCookie(String key,String domain,String path, HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if (null != cookies){
			for (Cookie c:cookies){
				if (c.getName().equalsIgnoreCase(key)){
					if (null != domain && !c.getDomain().equalsIgnoreCase(domain)){
						continue;
					}else if (null != path && !c.getPath().equalsIgnoreCase(path)){
						continue;
					}
					return c;
				}
			}
		}
		return null;
	}	
	
	/**
	 * 跟据Key获取Cookie的Value ，key 必须
	 * modified by：Rain  2014-3-6
	 */
	protected String getCookieValue(String key,String domain,String path, HttpServletRequest request){
		Cookie c = this.getCookie(key, domain, path,request);
		if (null != c){
			try {
				return new String(URLDecoder.decode(c.getValue(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 增加Cookie ， key、value必须
	 * modified by：Rain  2014-3-6
	 * @param response 
	 */
	protected boolean addCookie(String key,String domain,String path,Integer maxAge,String value, HttpServletResponse response){
		Cookie cookie = null;
		try {
			cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
		if (null != domain){
				cookie.setDomain(domain);
			}
			if (null != path){
				cookie.setPath(path);
			}
			if (null != maxAge){
				cookie.setMaxAge(maxAge);
			}
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			return false;
		}
		return true;
	}	
	
	/**
	 * 根据Key删除Cookie
	 * modified by：Rain  2014-3-6
	 * @param response 
	 * @param request 
	 */
	protected void removeCookie(String key,String domain,String path, HttpServletRequest request, HttpServletResponse response){
		Cookie c = this.getCookie(key, domain, path, request);
		if (null != c){
			c.setValue("");
			c.setMaxAge(0);
			response.addCookie(c);
		}
	}

}
