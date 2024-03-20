package org.example.DTO.PostImageDTO;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PostImageItemDTO {
    private int id;
    private String name;
    private LocalDateTime dateCreated;
    private String post_title;
    private int post_id;
}
