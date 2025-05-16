package de.ait.userapi.controller;

import de.ait.userapi.dto.CategoryRequestDto;
import de.ait.userapi.dto.CategoryResponseDto;
import de.ait.userapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getCategories(){
        return ResponseEntity.ok().body(service.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable("id") Long id){
        // ofNullable вернёт 404 ошибку, если id нету
        return ResponseEntity.ofNullable(service.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody CategoryRequestDto dto){
        CategoryResponseDto saved = service.save(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);

    }
}
