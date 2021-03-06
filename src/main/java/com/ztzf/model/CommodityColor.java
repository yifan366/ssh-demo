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
 * 简述：商品颜色中间表实体
 * 作者：zhangfan
 * 时间：2017年3月2日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "commodity_color", catalog = "ztzf_shop")
public class CommodityColor {

	private int commodityColorId;
	
	private Commodity commodity;
	
	private Color color;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "commodity_color_id", unique = true, nullable = false)
	public int getCommodityColorId() {
		return commodityColorId;
	}

	public void setCommodityColorId(int commodityColorId) {
		this.commodityColorId = commodityColorId;
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
	@JoinColumn(name="color_id")
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
