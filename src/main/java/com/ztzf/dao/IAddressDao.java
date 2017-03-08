package com.ztzf.dao;

import java.util.List;

import com.ztzf.basedao.IBaseDao;
import com.ztzf.model.Address;
import com.ztzf.utils.Pager;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：收货地址数据库访问接口类
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
public interface IAddressDao extends IBaseDao<Address> {

	/**
	 * 查询用户的所有收货地址
	 * @param userId
	 * @param isDefault
	 * @return
	 */
	public List<Address> listByUser(Integer userId,Boolean isDefault);
	
	/**
	 * 分页查询用户的收货地址
	 * @param userId
	 * @return
	 */
	public Pager<Address> find(Integer userId);
	
}
