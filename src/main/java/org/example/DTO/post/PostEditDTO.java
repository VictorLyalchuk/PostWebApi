package org.example.DTO.post;

import lombok.Data;
import org.example.DTO.postImage.PostImageDTO;
import org.example.DTO.tag.TagItemDTO;

import java.util.ArrayList;
import java.util.List;
@Data
public class PostEditDTO {
    private int id;
    private String title;
    private String shortDescription;
    private String description;
    private String category;
    private int category_id;
    private List<PostImageDTO> oldPhotos;
    private List<PostImageDTO> newPhotos;
    private List<Integer> tags = new ArrayList<>();
}
