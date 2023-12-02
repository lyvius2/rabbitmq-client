package com.walter.rabbitmq.consumer.listener;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener implements ChannelAwareMessageListener {
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		log.info("Message : {}", new String(message.getBody()));
	}
}
