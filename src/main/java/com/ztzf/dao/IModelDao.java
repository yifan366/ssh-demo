package com.ztzf.dao;

import java.util.List;

import com.ztzf.basedao.IBaseDao;
import com.ztzf.model.Color;
import com.ztzf.model.Model;
import com.ztzf.utils.Pager;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品类型数据访问接口
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
public interface IModelDao extends IBaseDao<Model> {

	public Pager<Model> find();
	
	public List<Model> list();
}
