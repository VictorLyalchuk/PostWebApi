package org.example.Services;


import lombok.AllArgsConstructor;
import org.example.DTO.post.PostCreateDTO;
import org.example.DTO.post.PostEditDTO;
import org.example.DTO.post.PostItemDTO;
import org.example.DTO.post.PostSearchDTO;
import org.example.entities.CategoryEntity;
import org.example.entities.PostEntity;
import org.example.entities.PostImageEntity;
import org.example.mapper.PostMapper;
import org.example.repositories.PostImageRepository;
import org.example.repositories.PostRepository;
import org.example.storage.StorageService;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostImageRepository postImageRepository;
    private final StorageService storageService;
    private final CategoryService categoryService;
    private final PostMapper postMapper;
    @Override
    public PostItemDTO getById(int id) {
        var postEntity =  postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        PostItemDTO postItemDTO = postMapper.productItemDTO(postEntity);

        var items = new ArrayList<String>();
        for (var img : postEntity.getPostImages()) {
            items.add(img.getName());
        }
        postItemDTO.setFiles(items);

        return postItemDTO;
    }

    @Override
    public PostSearchDTO searchGetAllPost(int categoryId, String tag, int page, int size) {
        return null;
    }

    @Override
    public PostItemDTO create(PostCreateDTO model) {
        var post = postMapper.postCreateDTO(model);
        postRepository.save(post);

        for (var img : model.getFiles()) {
            try {
                var imageResult = postImageRepository.findById(img.getId());
                PostImageEntity imageEntity = new PostImageEntity();
                imageEntity.setPost(post);
                imageEntity.setName(img.getName());
                postImageRepository.save(imageEntity);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public PostItemDTO editPost(PostEditDTO dto) throws IOException {
        return null;
    }

    @Override
    public void deletePost(int id) throws IOException {
        var entity = postRepository.findById(id).orElse(null);
        if (postRepository.existsById(id)) {
            postRepository.save(entity);
            postRepository.deleteById(id);
        }
    }
}