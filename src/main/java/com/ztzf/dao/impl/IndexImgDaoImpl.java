package com.ztzf.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ztzf.basedao.BaseDao;
import com.ztzf.dao.IIndexImgDao;
import com.ztzf.model.IndexImg;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：首页图片数据访问实现类
 * 作者：zhangfan
 * 时间：2017年3月7日
 * 版本：V0.0.1
 */
@Repository("indexImgDao")
public class IndexImgDaoImpl extends BaseDao<IndexImg> implements IIndexImgDao {

	@Override
	public List<IndexImg> list() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
