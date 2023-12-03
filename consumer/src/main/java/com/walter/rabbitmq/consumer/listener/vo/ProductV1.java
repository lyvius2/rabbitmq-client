package com.walter.rabbitmq.consumer.listener.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductV1 implements Serializable {
	@Schema(description = "일련번호", example = "1")
	private long seq;

	@Schema(description = "콘솔", example = "Play Station 4")
	private String consoleName;

	@Schema(description = "제조사", example = "SONY")
	private String manufacturer;
}
