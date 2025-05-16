package de.ait.userapi.controller;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/products")
    public List<ProductResponseDto> getProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getById(@PathVariable("id") Long idProduct) {
        return service.getProductById(idProduct);
    }

    @PostMapping("/products")
    public ProductResponseDto saveProduct(@RequestBody ProductRequestDto dto) {
        return service.addProduct(dto);
    }
}
