package org.example.DTO.PostImageDTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class PostImageCreateDTO {
    private MultipartFile file;

}
