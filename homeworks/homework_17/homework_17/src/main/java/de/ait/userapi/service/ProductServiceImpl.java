package de.ait.userapi.service;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.mappers.ProductMapper;
import de.ait.userapi.model.Product;
import de.ait.userapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                // orElseThrow извлекает из Optional - продукт
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public ProductResponseDto addProduct(ProductRequestDto dto) {
        Product product = mapper.toProduct(dto);
        Product savedProduct = repository.save(product);
        return mapper.toResponseDto(savedProduct);
    }
}
