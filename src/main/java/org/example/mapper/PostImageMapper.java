package org.example.mapper;

import org.example.DTO.postImage.PostImageItemDTO;
import org.example.entities.PostImageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface PostImageMapper {
    @Mapping(source = "post.id", target = "post_id")
    @Mapping(source = "post.title", target = "post_title")
    PostImageItemDTO postImageItemDTO(PostImageEntity postImageEntity);
}