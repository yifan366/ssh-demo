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
 * 简述：用户订单中间表
 * 作者：zhangfan
 * 时间：2017年3月2日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "user_orders", catalog = "ztzf_shop")
public class UserOrders {

	private int userOrderId;
	
	private User user;
	
	private Orders orders;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_order_id", unique = true, nullable = false)
	public int getUserOrderId() {
		return userOrderId;
	}

	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}

	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
