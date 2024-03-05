package org.example.Services;


import lombok.AllArgsConstructor;
import org.example.DTO.post.PostItemDTO;
import org.example.DTO.post.PostSearchDTO;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.stream.Collectors;
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
}