package com.ztzf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ztzf.basedao.BaseDao;
import com.ztzf.dao.IColorDao;
import com.ztzf.model.Color;
import com.ztzf.utils.Pager;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品颜色数据访问实现类
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
@Repository("colorDao")
public class ColorDaoImpl  extends BaseDao<Color> implements IColorDao{

	StringBuffer buf = new StringBuffer();
	List<Object> where = new ArrayList<Object>();
	
	@Override
	public Pager<Color> find() {
		
		buf.append("select cc from Color cc");
		return this.find(buf.toString(),where.toArray());
	}

	@Override
	public List<Color> list() {
		
		buf.append("select cc from Color cc");
		return this.list(buf.toString(),where.toArray());
	}


}
