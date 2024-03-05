package org.example.DTO.post;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostItemDTO {
    private int id;
    private String title;
    private String shortDescription;
    private String description;
    private String category;
    private int category_id;
    private List<String> files = new ArrayList<>();
}
