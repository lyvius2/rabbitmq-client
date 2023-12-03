package com.walter.rabbitmq.consumer.repository;

import com.walter.rabbitmq.consumer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
