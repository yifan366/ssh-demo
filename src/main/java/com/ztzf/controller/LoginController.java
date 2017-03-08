package com.ztzf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ztzf.model.Message;
import com.ztzf.model.Model;
import com.ztzf.model.Type;
import com.ztzf.service.IModelService;
import com.ztzf.service.ITypeService;
import com.ztzf.service.MessageServiceI;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：登录控制器
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private MessageServiceI messageService;
	
	@Autowired
	private IModelService commodityModelService;
	
	@Autowired
	private ITypeService commodityTypeService;
	
	@RequestMapping("index")
	public String index(){
		
		List<Type> listm = commodityTypeService.list();
		
		for (Type m : listm) {
			System.out.println(m.getModels().size());
		}
		
		return "index";
		
	}
}
