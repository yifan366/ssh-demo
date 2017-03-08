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
 * 简述：商品属性图片实体
 * 作者：zhangfan
 * 时间：2017年3月2日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "commodity_parameters_img", catalog = "ztzf_shop")
public class CommodityParametersImg {

	private int commodityParametersImgId;
	
	private Commodity commodity;
	
	private String imgSrc;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "commodity_parameters_img_id", unique = true, nullable = false)
	public int getCommodityParametersImgId() {
		return commodityParametersImgId;
	}

	public void setCommodityParametersImgId(int commodityParametersImgId) {
		this.commodityParametersImgId = commodityParametersImgId;
	}

	@ManyToOne
	@JoinColumn(name="commodity_id")
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Column(name = "img_src", nullable = false)
	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	
}
