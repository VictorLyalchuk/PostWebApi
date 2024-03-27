package org.example.Services;

import org.example.DTO.postImage.PostImageCreateDTO;
import org.example.DTO.postImage.PostImageItemDTO;
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
    PostSearchDTO searchGetAllPost(String category, String tag, Pageable pageable);
    PostItemDTO create(PostCreateDTO model);
    PostItemDTO editPost(PostEditDTO dto) throws IOException;
    void deletePost(int id) throws IOException;
}
