package com.example.demo.service.impl;

import com.example.demo.domain.Rotation;
import com.example.demo.mapper.RotationMapper;
import com.example.demo.service.RotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Forzh
* @description 针对表【rotation】的数据库操作Service实现
* @createDate 2022-03-13 16:06:00
*/
@Service
public class RotationServiceImpl implements RotationService{

    @Autowired
    RotationMapper rotationMapper;

    @Override
    public List<Rotation> selectAllRotation() {
        return this.rotationMapper.selectAllRotation();
    }
}
