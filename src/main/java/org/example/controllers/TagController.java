package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.DTO.tag.TagCreateDTO;
import org.example.DTO.tag.TagEditDTO;
import org.example.DTO.tag.TagItemDTO;
import org.example.Services.CategoryService;
import org.example.Services.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/tags")
public class TagController {
    private final TagService tagService;

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<TagItemDTO> getById(@PathVariable int id) {
        var result = tagService.getById(id);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<TagItemDTO>> gtAll() {
        try {
            List<TagItemDTO> tags = tagService.getAll();
            return new ResponseEntity<>(tags, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<TagItemDTO> create(@ModelAttribute TagCreateDTO dto) {
        try {
            var result = tagService.create(dto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<TagItemDTO> editTag(@ModelAttribute TagEditDTO dto) {
        try {
            var result = tagService.editTag(dto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable int id) throws IOException {
        try {
            tagService.deleteTag(id);
            return new ResponseEntity<>("Success", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
