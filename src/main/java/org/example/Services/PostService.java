package org.example.Services;

import org.example.DTO.PostImageDTO.PostImageCreateDTO;
import org.example.DTO.PostImageDTO.PostImageItemDTO;
import org.example.DTO.post.PostCreateDTO;
import org.example.DTO.post.PostEditDTO;
import org.example.DTO.post.PostItemDTO;
import org.example.DTO.post.PostSearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface PostService {
    PostItemDTO getById(int id);
    PostSearchDTO searchGetAllPost(int categoryId, String tag, int page, int size);
    PostItemDTO create(PostCreateDTO model);
    PostItemDTO editPost(PostEditDTO dto) throws IOException;
    void deletePost(int id) throws IOException;
    PostImageItemDTO createImage(PostImageCreateDTO dto) throws IOException;
    void deleteImage(PostImageItemDTO dto) throws IOException;

}
