package com.walter.rabbitmq.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	private final RabbitTemplate rabbitTemplate;
	private final ObjectMapper objectMapper;
	private static final String EXCHANGE_NAME = "amq.topic";
	private static final String ROUTING_KEY = "product.equip.info";

	public ProducerService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
		this.rabbitTemplate = rabbitTemplate;
		this.objectMapper = objectMapper;
	}

	public void push(Object object) throws JsonProcessingException {
		rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, objectMapper.writeValueAsString(object));
	}
}
