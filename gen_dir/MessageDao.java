package com.mountain.dao;

import org.springframework.stereotype.Repository;
import com.mountain.springboot.common.BaseDao;
import com.mountain.po.Message;

@Repository
public interface MessageDao extends BaseDao<Message> {
	
	
}
