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
 * 简述：订单商品中间表实体
 * 作者：zhangfan
 * 时间：2017年3月2日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "orders", catalog = "ztzf_shop")
public class OrderCommodity {

	private int orderCommodityId;
	
	private Commodity commodity;
	
	private Orders orders;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_commodity_id", unique = true, nullable = false)
	public int getOrderCommodityId() {
		return orderCommodityId;
	}

	public void setOrderCommodityId(int orderCommodityId) {
		this.orderCommodityId = orderCommodityId;
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
	@JoinColumn(name="orders_id")
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
}
