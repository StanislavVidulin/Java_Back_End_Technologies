package de.ait.userapi.service;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.mapper.ProductMapper;
import de.ait.userapi.model.Category;
import de.ait.userapi.model.Product;
import de.ait.userapi.repository.CategoryRepository;
import de.ait.userapi.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final CategoryRepository categoryRepository;


    @Override
    public List<ProductResponseDto> getProducts() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public ProductResponseDto save(ProductRequestDto dto) {
        Product product = mapper.fromDto(dto);
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        Product saved = repository.save(product);
        return mapper.toDto(saved);
    }
}
