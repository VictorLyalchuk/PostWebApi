package org.example.mapper;

import org.example.DTO.category.CategoryCreateDTO;
import org.example.DTO.category.CategoryItemDTO;
import org.example.entities.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryItemDTO categoryItemDTO(CategoryEntity category);
    List<CategoryItemDTO> categoriesListItemDTO (List<CategoryEntity> list);
    CategoryEntity categoryCreateDTO(CategoryCreateDTO category);
}
