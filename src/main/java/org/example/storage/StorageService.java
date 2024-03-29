package org.example.storage;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {

    void init() throws IOException;
    String SaveImage(MultipartFile file, FileSaveFormat format) throws IOException;
    String SaveImageURL(String imageUrl, FileSaveFormat format) throws IOException;
    void deleteImage(String fileName) throws IOException;
    String SaveImageBase64(String base64, FileSaveFormat format);
}