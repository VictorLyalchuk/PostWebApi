package org.example.DTO.post;

import lombok.Data;
import org.example.DTO.tag.TagItemDTO;
import org.example.entities.TagEntity;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostItemDTO {
    private int id;
    private String title;
    private String shortDescription;
    private String description;
    private String category_name;
    private int category_id;
    private List<String> files = new ArrayList<>();
    private List<TagItemDTO> tags = new ArrayList<>();

}
