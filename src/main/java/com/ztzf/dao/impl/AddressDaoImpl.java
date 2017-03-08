package com.ztzf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ztzf.basedao.BaseDao;
import com.ztzf.dao.IAddressDao;
import com.ztzf.model.Address;
import com.ztzf.utils.Pager;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：收货地址数据访问实现类
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
@Repository("addressDao")
public class AddressDaoImpl extends BaseDao<Address> implements IAddressDao {

	StringBuffer buf = new StringBuffer();
	List<Object> where = new ArrayList<Object>();
	
	@Override
	public List<Address> listByUser(Integer userId,Boolean isDefault) {

		buf.append("select a from Address a where 1=1");
		if(null!=userId){
			buf.append(" and a.userId=?");
			where.add(userId);
		}
		if(null!=isDefault){
			buf.append(" and a.isDefault=?");
			where.add(isDefault);
		}
		buf.append(" order by a.addressId desc");
		
		return this.list(buf.toString(),where.toArray());
		
	}

	@Override
	public Pager<Address> find(Integer userId) {
		
		buf.append("select a from Address a where 1=1");
		if(null!=userId){
			buf.append(" and a.userId=?");
			where.add(userId);
		}
		buf.append(" order by a.addressId desc");
		
		return this.find(buf.toString(),where.toArray());
	}


}
