package de.ait.userapi.mapper;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromDto(ProductRequestDto dto);
    ProductResponseDto toDto (Product product);
    List<ProductResponseDto> toDtoList (List<Product> product);
}
