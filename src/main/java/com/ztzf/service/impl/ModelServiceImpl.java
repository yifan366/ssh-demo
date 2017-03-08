package com.ztzf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztzf.dao.IModelDao;
import com.ztzf.model.Model;
import com.ztzf.service.IModelService;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品类型业务处理实现类
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
@Transactional
@Service("modelService")
public class ModelServiceImpl implements IModelService {

	@Autowired
	private IModelDao modelDao;
	
	@Override
	public List<Model> list() {
		// TODO Auto-generated method stub
		return modelDao.list();
	}

}
