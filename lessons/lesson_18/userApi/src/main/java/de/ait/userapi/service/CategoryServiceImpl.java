package de.ait.userapi.service;

import de.ait.userapi.dto.CategoryRequestDto;
import de.ait.userapi.dto.CategoryResponseDto;
import de.ait.userapi.mapper.CategoryMapper;
import de.ait.userapi.model.Category;
import de.ait.userapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository repository;
    private final CategoryMapper mapper;


    @Override
    public List<CategoryResponseDto> getCategories() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public CategoryResponseDto save(CategoryRequestDto dto) {
        Category category = mapper.fromDto(dto);
        Category saved = repository.save(category);
        return mapper.toDto(saved);
    }
}
