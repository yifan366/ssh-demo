package com.ztzf.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ztzf.basedao.BaseDao;
import com.ztzf.dao.ICollectionDao;
import com.ztzf.model.Collection;
import com.ztzf.utils.Pager;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品收藏数据访问实现类
 * 作者：zhangfan
 * 时间：2017年3月7日
 * 版本：V0.0.1
 */
@Repository("collectionDao")
public class CollectionDaoImpl extends BaseDao<Collection> implements ICollectionDao{

	@Override
	public Pager<Collection> find(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collection> list(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
