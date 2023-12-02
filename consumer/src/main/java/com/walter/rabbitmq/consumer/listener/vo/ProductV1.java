package com.walter.rabbitmq.consumer.listener.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductV1 {
	private long seq;
	private String consoleName;
	private String manufacturer;
}
