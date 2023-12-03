package com.walter.rabbitmq.consumer.controller;

import com.walter.rabbitmq.consumer.listener.vo.ProductV1;
import com.walter.rabbitmq.consumer.service.ConsumeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/read")
@Tag(name = "저장된 메시지 조회")
public class ConsumeController {
	private final ConsumeService consumeService;

	public ConsumeController(ConsumeService consumeService) {
		this.consumeService = consumeService;
	}

	@Operation(summary = "Read API", description = "DB에 적재된 메시지를 조회")
	@GetMapping("/consoles")
	public List<ProductV1> getConsoles() {
		return consumeService.getProducts();
	}
}
