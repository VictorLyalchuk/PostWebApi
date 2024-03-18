package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.DTO.tag.TagCreateDTO;
import org.example.DTO.tag.TagEditDTO;
import org.example.DTO.tag.TagItemDTO;
import org.example.entities.TagEntity;
import org.example.mapper.TagMapper;
import org.example.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService{
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;
    @Override
    public TagItemDTO getById(int id) {
        var result =  tagMapper.tagItemDTO(tagRepository.findById(id).orElse(null));
        return result;
    }

    @Override
    public List<TagItemDTO> getAll() {
        List<TagEntity> tags = tagRepository.findAll();
        return tagMapper.tagListItemDTO(tags);
    }

    @Override
    public TagItemDTO create(TagCreateDTO dto) throws IOException {
        var entity = tagMapper.tagCreateDTO(dto);
        tagRepository.save(entity);
        return tagMapper.tagItemDTO(entity);
    }

    @Override
    public TagItemDTO editTag(TagEditDTO dto) throws IOException {
        TagEntity entity = new TagEntity();
        entity.setName(dto.getName());
        tagRepository.save(entity);
        return tagMapper.tagItemDTO(entity);
    }

    @Override
    public void deleteTag(int id) throws IOException {
        var entity = tagRepository.findById(id).orElse(null);
        if (tagRepository.existsById(id)) {
            tagRepository.save(entity);
            tagRepository.deleteById(id);
        }
    }
}
