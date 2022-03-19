package com.example.demo.things.imgupload;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

    String uploadImages(MultipartFile file);

}
