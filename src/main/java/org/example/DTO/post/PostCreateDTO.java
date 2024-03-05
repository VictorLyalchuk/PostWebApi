package org.example.DTO.post;

import java.util.ArrayList;
import java.util.List;

public class PostCreateDTO {
    private String title;
    private String shortDescription;
    private String description;
    private String category;
    private int category_id;
    private List<String> files = new ArrayList<>();
}
