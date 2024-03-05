package org.example.Services;

import org.example.DTO.post.PostCreateDTO;
import org.example.DTO.post.PostEditDTO;
import org.example.DTO.post.PostItemDTO;
import org.example.DTO.post.PostSearchDTO;

import java.io.IOException;
import java.util.List;

public interface PostService {
    PostItemDTO getById(int id);
    PostSearchDTO searchGetAllPost(int categoryId, String tag, int page, int size);
    PostItemDTO create(PostCreateDTO model);
    PostItemDTO editProduct(PostEditDTO dto) throws IOException;
    void deleteProduct(int id) throws IOException;
}