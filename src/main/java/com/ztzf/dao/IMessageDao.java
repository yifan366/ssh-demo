package com.ztzf.dao;

import java.util.List;

import com.ztzf.basedao.IBaseDao;
import com.ztzf.model.Message;

public interface IMessageDao extends IBaseDao<Message>{

	public List<Message> list();
}
