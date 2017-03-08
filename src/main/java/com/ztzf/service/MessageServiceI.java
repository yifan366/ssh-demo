package com.ztzf.service;

import java.util.List;

import com.ztzf.model.Message;

public interface MessageServiceI {

	public void msgSub(Message rmessage);
	
	public List<Message> list();

}
