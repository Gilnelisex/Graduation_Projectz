package com.example.demo.controller;


import com.example.demo.domain.Users;
import com.example.demo.service.UsersService;
import com.example.demo.things.imgupload.ImageUploadService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImgController {
    @Autowired
    ImageUploadService imageUploadService;

    @Autowired
    UsersService usersService;

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam(value = "file", required = false) MultipartFile file, Integer id) {
        String url = imageUploadService.uploadImages(file);
        if (StringUtils.isBlank(url)) {
            return "redirect:/";
        } else {
            Users users = new Users();
            users.setPicture(url);
            users.setId(id);
            this.usersService.updateByPrimaryKeySelective(users);
            return "redirect:/personalCenter";
        }
    }
}
