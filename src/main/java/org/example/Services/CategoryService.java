package org.example.Services;

import org.example.DTO.category.CategoryCreateDTO;
import org.example.DTO.category.CategoryEditDTO;
import org.example.DTO.category.CategoryItemDTO;
import org.example.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    CategoryItemDTO getById(int id);
    Page<CategoryItemDTO> getAllByName(String name, Pageable pageable);
    CategoryItemDTO create(CategoryCreateDTO dto) throws IOException;
    CategoryItemDTO editCategory(CategoryEditDTO dto) throws IOException;
    void deleteCategory(int id) throws IOException;
}
