package com.ztzf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztzf.dao.IMessageDao;
import com.ztzf.model.Message;
import com.ztzf.service.MessageServiceI;

@Transactional
@Service("messageService")
public class MessageServiceImpl implements MessageServiceI {

	@Resource
	private IMessageDao messageDao;

	@Override
	public void msgSub(Message message) {
		messageDao.add(message);
	}

	@Override
	public List<Message> list() {
		// TODO Auto-generated method stub
		return messageDao.list();
	}

}
