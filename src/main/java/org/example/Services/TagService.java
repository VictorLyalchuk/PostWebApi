package org.example.Services;

import org.example.DTO.category.CategoryCreateDTO;
import org.example.DTO.category.CategoryEditDTO;
import org.example.DTO.category.CategoryItemDTO;
import org.example.DTO.tag.TagCreateDTO;
import org.example.DTO.tag.TagEditDTO;
import org.example.DTO.tag.TagItemDTO;


import java.io.IOException;
import java.util.List;

public interface TagService {
    TagItemDTO getById(int id);
    List<TagItemDTO> getAll();
    TagItemDTO create(TagCreateDTO dto) throws IOException;
    TagItemDTO editTag(TagEditDTO dto) throws IOException;
    void deleteTag(int id) throws IOException;
}
