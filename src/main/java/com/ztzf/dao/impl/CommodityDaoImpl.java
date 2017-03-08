package com.ztzf.dao.impl;

import org.springframework.stereotype.Repository;

import com.ztzf.basedao.BaseDao;
import com.ztzf.dao.ICommodityDao;
import com.ztzf.model.Commodity;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品数据访问实现类
 * 作者：zhangfan
 * 时间：2017年3月7日
 * 版本：V0.0.1
 */
@Repository("commodityDao")
public class CommodityDaoImpl  extends BaseDao<Commodity> implements ICommodityDao{

}
