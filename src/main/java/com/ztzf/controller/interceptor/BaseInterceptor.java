package com.ztzf.controller.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 面向切面编程。
 * 
 * @author li
 * 
 */
@Aspect
@Component
public class BaseInterceptor {

	@Pointcut("execution (* com.ztzf..service..*.*(..))")
	private void anyMethod() {
	}// 声明一个切入点

	/**
	 * 在方法运行之前执行,存入当前方法操作人，ip地址
	 * 
	 * @param joinpoint
	 */
	@Before("anyMethod()")
	public void doAccessCheck(JoinPoint joinpoint) {
		String operType = joinpoint.getSignature().getName();
		// 操作所在实体类
		// String entity = joinpoint.getTarget().getClass().getName();
		if(operType.equals("saveInstantMessag")){
			
		}else{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String staffid = "";
		//操作人id
		if (request.getSession().getAttribute("id") != null) {
			staffid = request.getSession().getAttribute("id").toString();
		}
		// 操作ip
//		String ip = TcpIpHelper.getIpAddress(request);
//		// 操作时间
//		Map<String, String> val = new HashMap<String, String>();
//		val.put("fromAddress", ip);
//		val.put("staffId", staffid);
//		LogContext.setContext(val);
		}
	}

	/**
	 * 在方法运行之后执行
	 * 
	 * @param joinpoint
	 *            获取该方法的作用
	 */
	@After("anyMethod()")
	public void doAfter(JoinPoint joinpoint) {
		// System.out.println("********  方法运行结束！");
	}

	/**
	 * 在方法执行成功之后运行
	 * 
	 * @param joinpoint
	 *            获取该方法的作用
	 */
	@AfterReturning("anyMethod()")
	public void afterRunning(JoinPoint joinpoint) {


	}

	/**
	 * 在方法运行中出现异常是运行
	 * 
	 * @param joinpoint
	 *            获取该方法的作用
	 */
	@AfterThrowing(pointcut = "anyMethod()", throwing = "ex")
	public void afterThorwing(JoinPoint joinpoint, RuntimeException ex) {
		System.out.println("********错误:" + ex.toString());

		Object[] objs = joinpoint.getArgs();
		// 获取类名（包名 + 类名）
		String className = joinpoint.getTarget().getClass().toString();
		className = className.substring(className.indexOf("com"));
		// 获取方法(只获取方法的名称)
		String methodName = joinpoint.getSignature().toString();
		methodName = methodName.substring(methodName.lastIndexOf(".") + 1);
		// 打印出运行的方法的类名+方法名
		System.out.println("********className:" + className + "." + methodName);
		System.out.println("********  方法运行异常");
		// 打印出所有的参数的值 （按照参数的输入顺序）
		for (int i = 0; i < objs.length; i++) {
			System.out.print(objs[i]+",");
		}
	}
}
