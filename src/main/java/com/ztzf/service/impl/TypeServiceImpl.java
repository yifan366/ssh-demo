package com.ztzf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztzf.dao.ITypeDao;
import com.ztzf.model.Type;
import com.ztzf.service.ITypeService;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品分类业务处理实现类
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
@Transactional
@Service("typeService")
public class TypeServiceImpl implements ITypeService{

	@Autowired
	private ITypeDao typeDao;
	
	
	@Override
	public List<Type> list() {
		// TODO Auto-generated method stub
		return typeDao.list();
	}

}
