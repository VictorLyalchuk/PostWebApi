package org.example.DTO.post;

import lombok.Data;
import org.example.DTO.postImage.PostImageDTO;
import org.example.DTO.tag.TagItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Data
public class PostCreateDTO {
    private String title;
    private String shortDescription;
    private String description;
    private String category_name;
    private int category_id;
    private List<MultipartFile> files = new ArrayList<>();
    private List<Integer> tags = new ArrayList<>();
}
