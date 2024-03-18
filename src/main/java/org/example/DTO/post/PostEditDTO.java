package org.example.DTO.post;

import lombok.Data;
import org.example.DTO.PostImageDTO.PostImageDTO;
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
    private List<PostImageDTO> files = new ArrayList<>();
    private List<TagItemDTO> tags = new ArrayList<>();
}
