package org.example.Services;


import lombok.AllArgsConstructor;
import org.example.DTO.PostImageDTO.PostImageCreateDTO;
import org.example.DTO.PostImageDTO.PostImageItemDTO;
import org.example.DTO.post.PostCreateDTO;
import org.example.DTO.post.PostEditDTO;
import org.example.DTO.post.PostItemDTO;
import org.example.DTO.post.PostSearchDTO;
import org.example.entities.PostEntity;
import org.example.entities.PostImageEntity;
import org.example.entities.TagEntity;
import org.example.mapper.PostImageMapper;
import org.example.mapper.PostMapper;
import org.example.repositories.PostImageRepository;
import org.example.repositories.PostRepository;
import org.example.storage.FileSaveFormat;
import org.example.storage.StorageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.specifications.PostEntitySpecifications.findByCategoryId;
import static org.example.specifications.PostEntitySpecifications.findByTag;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostImageRepository postImageRepository;
    private final StorageService storageService;
    private final PostMapper postMapper;
    private final PostImageMapper postImageMapper;
    @Override
    public PostItemDTO getById(int id) {
        var postEntity =  postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        PostItemDTO postItemDTO = postMapper.postItemDTO(postEntity);

//        List<String> tags = postEntity.getTags().stream()
//                .map(TagEntity::getName)
//                .collect(Collectors.toList());
//        postItemDTO.setTags(tags);

        var items = new ArrayList<String>();
        for (var img : postEntity.getPostImages()) {
            items.add(img.getName());
        }
        postItemDTO.setFiles(items);

        return postItemDTO;
    }

    @Override
    public PostSearchDTO searchGetAllPost(int categoryId, String tag, int page, int size) {
        Page<PostEntity> result = postRepository
                .findAll(findByCategoryId(categoryId).and(findByTag(tag)),
                        PageRequest.of(page, size));

        List<PostItemDTO> products = result.getContent().stream()
                .map(product -> {
                    PostItemDTO postItemDTO = postMapper.postItemDTO(product);

//                    List<TagEntity> tags = product.getTags();
//                    List<String> tagNames = tags.stream()
//                            .map(TagEntity::getName)
//                            .collect(Collectors.toList());
//                    postItemDTO.setTags(tagNames);

                    List<String> imageNames = postImageRepository.findImageNamesByPost(product);
                    postItemDTO.setFiles(imageNames);

                    return postItemDTO;
                })
                .collect(Collectors.toList());

        return new PostSearchDTO(products, (int) result.getTotalElements());
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
//            postRepository.save(entity);
            postRepository.deleteById(id);
        }
    }


    @Override
    public PostImageItemDTO createImage(PostImageCreateDTO dto) throws IOException {
        MultipartFile file = dto.getFile();
        var imageName = storageService.SaveImage(file, FileSaveFormat.WEBP);

        var imageEntity = new PostImageEntity();
        imageEntity.setName(imageName);
        imageEntity.setDateCreated(LocalDateTime.now());
        postImageRepository.save(imageEntity);

        return postImageMapper.postImageItemDTO(imageEntity);
    }

    @Override
    public void deleteImage(PostImageItemDTO dto) throws IOException {
        storageService.deleteImage(dto.getName());
        postImageRepository.deleteById(dto.getId());
    }

}