package com.ztzf.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "ztzf_shop")
public class Message implements java.io.Serializable {

	// Fields

	private String msgId;
	private String msgName;
	private String msgPhone;
	private String msgContent;
	private String msgIp;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(String msgId, String msgName, String msgPhone, String msgContent,  String msgIp) {
		this.msgId = msgId;
		this.msgName = msgName;
		this.msgPhone = msgPhone;
		this.msgContent = msgContent;
		this.msgIp = msgIp;
	}

	// Property accessors
	@Id
	@Column(name = "msgId", unique = true, nullable = false, length = 64)
	public String getMsgId() {
		return this.msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@Column(name = "msgName", nullable = false, length = 32)
	public String getMsgName() {
		return this.msgName;
	}

	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	@Column(name = "msgPhone", nullable = false, length = 16)
	public String getMsgPhone() {
		return this.msgPhone;
	}

	public void setMsgPhone(String msgPhone) {
		this.msgPhone = msgPhone;
	}

	@Column(name = "msgContent", nullable = false, length = 2048)
	public String getMsgContent() {
		return this.msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}


	@Column(name = "msgIp", nullable = false, length = 32)
	public String getMsgIp() {
		return this.msgIp;
	}

	public void setMsgIp(String msgIp) {
		this.msgIp = msgIp;
	}

	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", msgName=" + msgName + ", msgPhone=" + msgPhone + ", msgContent="
				+ msgContent + ", msgIp=" + msgIp + "]";
	}

	
}