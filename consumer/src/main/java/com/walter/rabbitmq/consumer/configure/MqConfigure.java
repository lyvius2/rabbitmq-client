package com.walter.rabbitmq.consumer.configure;

import com.walter.rabbitmq.consumer.listener.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfigure {
	private static final String[] QUEUE_NAMES = {"console-info"};

	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory, MessageListener messageListener) {
		final SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
		listenerContainer.setConnectionFactory(connectionFactory);
		listenerContainer.setQueueNames(QUEUE_NAMES);
		listenerContainer.setConcurrentConsumers(10);
		listenerContainer.setMessageListener(messageListener);
		return listenerContainer;
	}
}
