package com.mountain.service.impl;

import org.springframework.stereotype.Repository;
import com.mountain.springboot.common.BaseDao;
import com.mountain.po.Message;

@Repository
public class MessageService extends AbstractService<Message, Long> implements
		IMessageService<Message, Long> {
	
	@Autowired
	private MessageDao messageDao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(messageDao);
	}
}
