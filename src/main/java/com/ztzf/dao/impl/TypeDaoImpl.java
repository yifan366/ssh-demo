package com.ztzf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ztzf.basedao.BaseDao;
import com.ztzf.dao.ITypeDao;
import com.ztzf.model.Model;
import com.ztzf.model.Type;
import com.ztzf.utils.Pager;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品分类数据访问实现类
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
@Repository("typeDao")
public class TypeDaoImpl extends BaseDao<Type> implements ITypeDao {

	
	
	@Override
	public Pager<Type> find() {
		StringBuffer buf = new StringBuffer();
		List<Object> where = new ArrayList<Object>();
		buf.append("select ct from Type ct");
		return this.find(buf.toString(),where.toArray());
	}

	@Override
	public List<Type> list() {
		StringBuffer buf = new StringBuffer();
		List<Object> where = new ArrayList<Object>();
		buf.append("select ct from Type ct");
		return this.list(buf.toString(),where.toArray());
	}


}
