package com.ztzf.dao;

import java.util.List;

import com.ztzf.basedao.IBaseDao;
import com.ztzf.model.Orders;
import com.ztzf.utils.Pager;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：订单数据访问接口
 * 作者：zhangfan
 * 时间：2017年3月7日
 * 版本：V0.0.1
 */
public interface IOrdersDao extends IBaseDao<Orders> {

	/**
	 * 查询用户所有订单列表
	 * @param userid
	 * @return
	 */
	public List<Orders> listByUserid(Integer userid);
	
	/**
	 * 分页查询订单列表 查询所有userid传null
	 * @param userid
	 * @return
	 */
	public Pager<Orders> find(Integer userid);
}
