package org.example.Services;

import org.example.DTO.tag.TagCreateDTO;
import org.example.DTO.tag.TagEditDTO;
import org.example.DTO.tag.TagItemDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.IOException;
import java.util.List;

public interface TagService {
    TagItemDTO getById(int id);
    List<TagItemDTO> getAll(Sort sort);
    Page<TagItemDTO> getAllByPage(Pageable pageable);
    TagItemDTO create(TagCreateDTO dto) throws IOException;
    TagItemDTO editTag(TagEditDTO dto) throws IOException;
    void deleteTag(int id) throws IOException;
}
