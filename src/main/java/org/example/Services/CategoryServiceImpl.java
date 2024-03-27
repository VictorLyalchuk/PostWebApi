package org.example.Services;

import lombok.AllArgsConstructor;

import org.example.DTO.category.CategoryCreateDTO;
import org.example.DTO.category.CategoryEditDTO;
import org.example.DTO.category.CategoryItemDTO;
import org.example.DTO.tag.TagItemDTO;
import org.example.entities.CategoryEntity;
import org.example.entities.TagEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.example.repositories.CategoryRepository;
import org.example.mapper.CategoryMapper;

import java.io.IOException;
import java.util.List;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryItemDTO getById(int id){
        var result =  categoryMapper.categoryItemDTO(categoryRepository.findById(id).orElse(null));
        return result;
    }
    @Override
    public List<CategoryItemDTO> getAll(Sort sort) {
        List<CategoryEntity> categories = categoryRepository.findAll(sort);
        return categoryMapper.categoriesListItemDTO(categories);
    }
    @Override
    public Page<CategoryItemDTO> getAllByName(String name, Pageable pageable) {
        Page<CategoryEntity> categories = categoryRepository.findByNameContainingIgnoreCase(name, pageable);
        return categories.map(categoryMapper::categoryItemDTO);
    }
    @Override
    public CategoryItemDTO create(CategoryCreateDTO dto) throws IOException {
        var entity = categoryMapper.categoryCreateDTO(dto);
        categoryRepository.save(entity);
        return categoryMapper.categoryItemDTO(entity);
    }
    @Override
    public CategoryItemDTO editCategory(CategoryEditDTO dto) throws IOException {
        if (!categoryRepository.existsById(dto.getId())) {
            return null;
        }

        var entity = categoryRepository.findById(dto.getId()).orElse(null);
        if (entity == null) {
            return null;
        }

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        categoryRepository.save(entity);
        return categoryMapper.categoryItemDTO(entity);
    }
    @Override
    public void deleteCategory(int id) throws IOException {
        var entity = categoryRepository.findById(id).orElse(null);
        if (categoryRepository.existsById(id)) {
//            categoryRepository.save(entity);
            categoryRepository.deleteById(id);
        }
    }
}
