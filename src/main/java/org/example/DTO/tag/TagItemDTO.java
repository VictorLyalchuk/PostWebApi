package org.example.DTO.tag;


import lombok.Data;
import org.example.DTO.post.PostItemDTO;
import java.util.List;

@Data
public class TagItemDTO {
    private int id;
    private String name;
    private List<PostItemDTO> posts;
}
