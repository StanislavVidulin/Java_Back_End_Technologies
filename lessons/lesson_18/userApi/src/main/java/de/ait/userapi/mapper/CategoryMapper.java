package de.ait.userapi.mapper;

import de.ait.userapi.dto.CategoryRequestDto;
import de.ait.userapi.dto.CategoryResponseDto;
import de.ait.userapi.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category fromDto(CategoryRequestDto dto);
    CategoryResponseDto toDto (Category category);
    List<CategoryResponseDto> toDtoList (List<Category> categories);
}
