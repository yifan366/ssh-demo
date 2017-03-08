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
 * 简述：购物车商品中间表
 * 作者：zhangfan
 * 时间：2017年3月2日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "scart_commodity", catalog = "ztzf_shop")
public class ScartCommodity {

	private int scartCommodityId;
	
	private Commodity commodity;
	
	private ShoppingCart shoppingCart;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "scart_commodity_id", unique = true, nullable = false)
	public int getScartCommodityId() {
		return scartCommodityId;
	}

	public void setScartCommodityId(int scartCommodityId) {
		this.scartCommodityId = scartCommodityId;
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
	@JoinColumn(name="shopping_cart_id")
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	
}
