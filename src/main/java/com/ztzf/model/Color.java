package com.ztzf.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品颜色实体
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "color", catalog = "ztzf_shop")
public class Color {

	private int colorid;
	
	private String colorName;
	
	private String colorDesc;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "color_id", unique = true, nullable = false)
	public int getColorid() {
		return colorid;
	}

	public void setColorid(int colorid) {
		this.colorid = colorid;
	}

	@Column(name = "color_name", nullable = false, length = 32)
	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	@Lob
	@Column(name = "color_desc")	
	public String getColorDesc() {
		return colorDesc;
	}

	public void setColorDesc(String colorDesc) {
		this.colorDesc = colorDesc;
	}
	
	
}
