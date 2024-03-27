package org.example.mapper;

import org.example.DTO.post.PostCreateDTO;
import org.example.DTO.post.PostItemDTO;
import org.example.entities.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "category.name", target = "category_name")
    @Mapping(source = "category.id", target = "category_id")
    PostItemDTO postItemDTO(PostEntity post);
    PostEntity postCreateDTO(PostCreateDTO postCreateDTO);
}
