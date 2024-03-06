package org.example.mapper;

import org.example.DTO.PostImageDTO.PostImageItemDTO;
import org.example.entities.PostImageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostImageMapper {
    PostImageItemDTO postImageItemDTO(PostImageEntity image);
}
