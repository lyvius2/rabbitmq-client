package com.walter.rabbitmq.producer.controller;

import com.walter.rabbitmq.producer.controller.vo.Product;
import com.walter.rabbitmq.producer.service.ProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push")
@Tag(name = "메시지 발행")
public class ProducerController {
	private final ProducerService producerService;

	public ProducerController(ProducerService producerService) {
		this.producerService = producerService;
	}

	@Operation(summary = "Push Message API", description = "RabbitMQ로 메시지를 Producing")
	@PostMapping("/message")
	public void publishing(@RequestBody Product product) throws Exception {
		producerService.push(product);
	}
}
