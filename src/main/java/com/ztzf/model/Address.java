package com.ztzf.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：收货地址实体
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "address", catalog = "ztzf_shop")
public class Address {

	private int addressId;
	
	private int userId; 
	
	private String receverName; 
	
	private String receverPhone;
	
	private String receverArea; 
	
	private String receverStreet;
	
	private String receverPostalCode; 
	
	private boolean isDefault; 

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "address_id", unique = true, nullable = false)
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Column(name = "recever_name", nullable = false, length = 32)
	public String getReceverName() {
		return receverName;
	}

	public void setReceverName(String receverName) {
		this.receverName = receverName;
	}

	@Column(name = "recever_phone", nullable = false)
	public String getReceverPhone() {
		return receverPhone;
	}

	public void setReceverPhone(String receverPhone) {
		this.receverPhone = receverPhone;
	}

	@Column(name = "recever_area", nullable = false, length = 32)
	public String getReceverArea() {
		return receverArea;
	}

	public void setReceverArea(String receverArea) {
		this.receverArea = receverArea;
	}

	@Column(name = "recever_street", nullable = false, length = 100)
	public String getReceverStreet() {
		return receverStreet;
	}

	public void setReceverStreet(String receverStreet) {
		this.receverStreet = receverStreet;
	}

	@Column(name = "recever_postalCode", nullable = false, length = 100)
	public String getReceverPostalCode() {
		return receverPostalCode;
	}

	public void setReceverPostalCode(String receverPostalCode) {
		this.receverPostalCode = receverPostalCode;
	}

	@Column(name = "is_default")
	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
