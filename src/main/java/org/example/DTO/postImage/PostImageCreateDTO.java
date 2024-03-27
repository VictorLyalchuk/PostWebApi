package org.example.DTO.postImage;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class PostImageCreateDTO {
    private MultipartFile file;

}
