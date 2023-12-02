package com.walter.rabbitmq.producer.configure;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocConfigure {
	@Bean
	public OpenAPI openAPI() {
		final Info info = new Info().title("RabbitMQ Producer API")
									.version("0.1");
		return new OpenAPI().info(info);
	}
}
