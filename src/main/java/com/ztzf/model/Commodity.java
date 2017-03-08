package com.ztzf.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品实体类
 * 作者：zhangfan
 * 时间：2017年3月2日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "commodity", catalog = "ztzf_shop")
public class Commodity {

	private int commodityId;
	
	private String commodityName;
	
	private String commodityContext;
	
	private Double commodityPrice;
	
	private String commodityDesc;
	
	private Date commodityCreateTime;
	
	private Date commodityUpdateTime;
	
	private int commodityCount;
	
	@OneToMany(mappedBy = "commodity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Color> colors = new HashSet<Color>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "commodity_id", unique = true, nullable = false)
	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	@Column(name = "commodity_name", nullable = false, length = 32)
	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	
	@Column(name = "commodity_context", length = 100)
	public String getCommodityContext() {
		return commodityContext;
	}

	public void setCommodityContext(String commodityContext) {
		this.commodityContext = commodityContext;
	}

	@Column(name = "commodity_private")
	public Double getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(Double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	@Lob
	@Column(name = "commodity_desc")
	public String getCommodityDesc() {
		return commodityDesc;
	}

	public void setCommodityDesc(String commodityDesc) {
		this.commodityDesc = commodityDesc;
	}

	@Column(name = "commodity_createtime")
	public Date getCommodityCreateTime() {
		return commodityCreateTime;
	}

	public void setCommodityCreateTime(Date commodityCreateTime) {
		this.commodityCreateTime = commodityCreateTime;
	}

	@Column(name = "commodity_updatetime")
	public Date getCommodityUpdateTime() {
		return commodityUpdateTime;
	}

	public void setCommodityUpdateTime(Date commodityUpdateTime) {
		this.commodityUpdateTime = commodityUpdateTime;
	}

	@Column(name = "commodity_count")
	public int getCommodityCount() {
		return commodityCount;
	}

	public void setCommodityCount(int commodityCount) {
		this.commodityCount = commodityCount;
	}

	
}
