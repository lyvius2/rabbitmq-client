package com.walter.rabbitmq.consumer.service;

import com.walter.rabbitmq.consumer.entity.Product;
import com.walter.rabbitmq.consumer.listener.vo.ProductV1;
import com.walter.rabbitmq.consumer.mapper.ProductMapper;
import com.walter.rabbitmq.consumer.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ConsumeService {
	private final ProductRepository productRepository;

	public ConsumeService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void accept(ProductV1 productV1) {
		final Product product = ProductMapper.INSTANCE.toEntity(productV1);
		productRepository.save(product);
	}

	public List<ProductV1> getProducts() {
		final List<Product> products = productRepository.findAll();
		return products.stream().map(ProductMapper.INSTANCE::toDto)
								.collect(toList());
	}
}
