package com.ztzf.dao;

import java.util.List;

import com.ztzf.basedao.IBaseDao;
import com.ztzf.model.Collection;
import com.ztzf.utils.Pager;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品收藏数据访问接口
 * 作者：zhangfan
 * 时间：2017年3月7日
 * 版本：V0.0.1
 */
public interface ICollectionDao  extends IBaseDao<Collection>{

	/**
	 * 分页查询所有商品收藏
	 * @return
	 */
	public Pager<Collection> find(Integer userid);
	
	/**
	 * 查询所有商品收藏
	 * @return
	 */
	public List<Collection> list(Integer userid);
}
