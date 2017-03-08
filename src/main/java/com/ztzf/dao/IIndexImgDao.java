package com.ztzf.dao;

import java.util.List;

import com.ztzf.basedao.IBaseDao;
import com.ztzf.model.IndexImg;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：首页图片数据访问接口
 * 作者：zhangfan
 * 时间：2017年3月7日
 * 版本：V0.0.1
 */
public interface IIndexImgDao extends IBaseDao<IndexImg> {

	/**
	 * 查询所有的首页图片列表
	 * @return
	 */
	public List<IndexImg> list();
}
