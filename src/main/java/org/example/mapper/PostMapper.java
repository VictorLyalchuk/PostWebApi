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


//    default List<String> mapTags(List<TagEntity> tags) {
//        return tags.stream()
//                .map(TagEntity::getName)
//                .collect(Collectors.toList());
//    }
//    default CategoryEntity map(String value) {
//        CategoryEntity categoryEntity = new CategoryEntity();
//        categoryEntity.setName(value);
//        return categoryEntity;
//    }

//    default List<TagEntity> map(List<String> tags) {
//        return tags.stream()
//                .map(tagName -> {
//                    TagEntity tagEntity = new TagEntity();
//                    tagEntity.setName(tagName);
//                    return tagEntity;
//                })
//                .collect(Collectors.toList());
//    }

}
