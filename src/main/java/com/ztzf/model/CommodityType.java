package com.ztzf.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品分类中间表
 * 作者：zhangfan
 * 时间：2017年3月2日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "commodity_type", catalog = "ztzf_shop")
public class CommodityType {

	private int commodityTypeId;
	
	private Commodity commodity;
	
	private Type type;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "commodity_type_id", unique = true, nullable = false)
	public int getCommodityTypeId() {
		return commodityTypeId;
	}

	public void setCommodityTypeId(int commodityTypeId) {
		this.commodityTypeId = commodityTypeId;
	}

	@ManyToOne
	@JoinColumn(name="commodity_id")
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@ManyToOne
	@JoinColumn(name="type_id")
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	
	

	
	
	
}
