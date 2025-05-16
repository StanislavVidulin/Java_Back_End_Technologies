package de.ait.userapi.service;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;


import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getProducts();
    ProductResponseDto getProductById(Long id);
    ProductResponseDto save(ProductRequestDto dto);
}
