package org.example.controllers;

import lombok.AllArgsConstructor;

import org.example.DTO.post.PostCreateDTO;
import org.example.DTO.post.PostEditDTO;
import org.example.DTO.post.PostItemDTO;
import org.example.DTO.post.PostSearchDTO;
import org.example.Services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("api/posts")
public class PostController {
    private final PostService postService;
    @GetMapping("/{id}")
    public ResponseEntity<PostItemDTO> getById(@PathVariable int id) {
        var result = postService.getById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<PostSearchDTO> searchByName(
            @RequestParam (defaultValue = "0")int categoryId,
            @RequestParam (defaultValue = "")String tag,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        try {
            PostSearchDTO posts = postService.searchGetAllPost(categoryId, tag, page, size);
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PostItemDTO> create(@ModelAttribute PostCreateDTO dto) {
        try {
            var result = postService.create(dto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostItemDTO> editPost(@ModelAttribute PostEditDTO dto) {
        try {
            var result = postService.editPost(dto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) throws IOException {
        try {
            postService.deletePost(id);
            return new ResponseEntity<>("Success", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
