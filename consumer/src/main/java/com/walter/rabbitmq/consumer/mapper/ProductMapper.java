package com.walter.rabbitmq.consumer.mapper;

import com.walter.rabbitmq.consumer.entity.Product;
import com.walter.rabbitmq.consumer.listener.vo.ProductV1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	@Mappings({
			@Mapping(source = "seq", target = "id"),
			@Mapping(source = "consoleName", target = "name")
	})
	Product toEntity(ProductV1 productV1);

	@Mappings({
			@Mapping(source = "id", target = "seq"),
			@Mapping(source = "name", target = "consoleName")
	})
	ProductV1 toDto(Product product);
}
