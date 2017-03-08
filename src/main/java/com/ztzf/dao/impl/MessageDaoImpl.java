package com.ztzf.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ztzf.basedao.BaseDao;
import com.ztzf.dao.IMessageDao;
import com.ztzf.model.Message;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDao<Message> implements IMessageDao{

	@Override
	public List<Message> list() {
		
		String hql="select msg from Message msg";
		return this.list(hql);
	}


}
