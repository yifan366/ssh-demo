package com.ztzf.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 公司：深圳市中泰智丰物联网科技有限公司
 * 项目：智能家居商城
 * 简述：商品分类实体
 * 作者：zhangfan
 * 时间：2017年2月28日
 * 版本：V0.0.1
 */
@Entity
@Table(name = "type", catalog = "ztzf_shop")
public class Type {

	private int typeId;
	
	private String typeName;
	
	private String typeDesc;
	
	private Type fartherType;
	
	private Set<Model> models = new HashSet<>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "type_id", unique = true, nullable = false)
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Column(name = "type_name", nullable = false, length = 32)
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Lob
	@Column(name = "type_desc")
	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	@ManyToOne
	@JoinColumn(name="type_farther_id")
	public Type getFartherType() {
		return fartherType;
	}

	public void setFartherType(Type fartherType) {
		this.fartherType = fartherType;
	}

	@OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Model> getModels() {
		return models;
	}

	public void setModels(Set<Model> models) {
		this.models = models;
	}
	
	
}
