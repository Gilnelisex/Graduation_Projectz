package com.example.demo.service;

import com.example.demo.domain.Rotation;

import java.util.List;

/**
* @author Forzh
* @description 针对表【rotation】的数据库操作Service
* @createDate 2022-03-13 16:06:00
*/
public interface RotationService {

    List<Rotation> selectAllRotation();

}
