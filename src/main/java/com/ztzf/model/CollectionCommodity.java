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
 * 简述：用户收藏商品中间表
 * 作者：zhangfan
 * 时间：2017年3月2日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "collection_commodity", catalog = "ztzf_shop")
public class CollectionCommodity {

	private int collectionCommodityId;
	
	private Commodity commodity;
	
	private Collection collection;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "collection_commodity_id", unique = true, nullable = false)
	public int getCollectionCommodityId() {
		return collectionCommodityId;
	}

	public void setCollectionCommodityId(int collectionCommodityId) {
		this.collectionCommodityId = collectionCommodityId;
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
	@JoinColumn(name="collection_id")
	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	
	
}
