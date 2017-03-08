package com.ztzf.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ztzf.basedao.BaseDao;
import com.ztzf.dao.IOrdersDao;
import com.ztzf.model.Orders;
import com.ztzf.utils.Pager;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：订单数据访问实现类
 * 作者：zhangfan
 * 时间：2017年3月7日
 * 版本：V0.0.1
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDao<Orders> implements IOrdersDao {

	@Override
	public List<Orders> listByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager<Orders> find(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
