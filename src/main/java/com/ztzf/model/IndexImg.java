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
 * 简述：首页图片实体
 * 作者：zhangfan
 * 时间：2017年3月2日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "index_img", catalog = "ztzf_shop")
public class IndexImg {

	private int indexImgId;
	
	private Commodity commodity;
	
	private String imgSrc;
	
	private int isUrl;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "index_img_id", unique = true, nullable = false)
	public int getIndexImgId() {
		return indexImgId;
	}

	public void setIndexImgId(int indexImgId) {
		this.indexImgId = indexImgId;
	}

	@ManyToOne
	@JoinColumn(name="commodity_id")
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Column(name = "img_src")
	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	@Column(name = "is_url")
	public int getIsUrl() {
		return isUrl;
	}

	public void setIsUrl(int isUrl) {
		this.isUrl = isUrl;
	}
	
	
}
