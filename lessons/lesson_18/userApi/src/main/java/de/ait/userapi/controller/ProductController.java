package de.ait.userapi.controller;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.model.Product;
import de.ait.userapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getProducts(){
        return ResponseEntity.ok().body(service.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProducts(@PathVariable("id") Long id){
        // ofNullable вернёт 404 ошибку, если id нету
        return ResponseEntity.ofNullable(service.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto dto){
        ProductResponseDto saved = service.save(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);

    }
}
