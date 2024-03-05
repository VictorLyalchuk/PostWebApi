package org.example.Services;


import lombok.AllArgsConstructor;
import org.example.DTO.post.PostCreateDTO;
import org.example.DTO.post.PostEditDTO;
import org.example.DTO.post.PostItemDTO;
import org.example.DTO.post.PostSearchDTO;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    @Override
    public PostItemDTO getById(int id) {
        return null;
    }

    @Override
    public PostSearchDTO searchGetAllPost(int categoryId, String tag, int page, int size) {
        return null;
    }

    @Override
    public PostItemDTO create(PostCreateDTO model) {
        return null;
    }

    @Override
    public PostItemDTO editProduct(PostEditDTO dto) throws IOException {
        return null;
    }

    @Override
    public void deleteProduct(int id) throws IOException {

    }
}