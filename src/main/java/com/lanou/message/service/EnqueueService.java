package com.lanou.message.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service("service")
public class EnqueueService {

	@Autowired
	public JmsTemplate jmsTemplate;// 自动装载在jms.xml中配置的jmsTemplate

	@Autowired
	public Destination userMQ;// 自动装载userMQ

	public void sendMessage(final String msg) {
		// send消息队列的名字
		jmsTemplate.send(userMQ, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				return session.createTextMessage(msg);
			}
		});
	}

}
