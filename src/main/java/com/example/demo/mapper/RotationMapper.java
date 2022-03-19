package com.example.demo.mapper;

import com.example.demo.domain.Rotation;

import java.util.List;

/**
* @author Forzh
* @description 针对表【rotation】的数据库操作Mapper
* @createDate 2022-03-13 16:06:17
* @Entity com.example.demo.domain.Rotation
*/
public interface RotationMapper {

    List<Rotation> selectAllRotation();

    int deleteByPrimaryKey(Long id);

    int insert(Rotation record);

    int insertSelective(Rotation record);

    Rotation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Rotation record);

    int updateByPrimaryKey(Rotation record);

}
