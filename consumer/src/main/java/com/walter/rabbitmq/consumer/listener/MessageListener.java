package com.walter.rabbitmq.consumer.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.walter.rabbitmq.consumer.controller.vo.ProductV1;
import com.walter.rabbitmq.consumer.service.ConsumeService;
import com.walter.rabbitmq.consumer.utils.JsonEscapeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener implements ChannelAwareMessageListener {
	private final ConsumeService consumeService;
	private final ObjectMapper objectMapper;

	public MessageListener(ConsumeService consumeService, ObjectMapper objectMapper) {
		this.consumeService = consumeService;
		this.objectMapper = objectMapper;
	}

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		final String messageBody = new String(message.getBody());
		final ProductV1 product = objectMapper.readValue(JsonEscapeUtil.unescape(messageBody), ProductV1.class);
		consumeService.accept(product);
		log.info("Message : {}", messageBody);
	}
}
