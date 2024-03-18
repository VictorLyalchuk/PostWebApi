package org.example.mapper;

import org.example.DTO.post.PostCreateDTO;
import org.example.DTO.tag.TagCreateDTO;
import org.example.DTO.tag.TagItemDTO;
import org.example.entities.PostEntity;
import org.example.entities.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagItemDTO tagItemDTO(TagEntity tag);
    List<TagItemDTO> tagListItemDTO (List<TagEntity> list);
    TagEntity tagCreateDTO(TagCreateDTO tag);
}
