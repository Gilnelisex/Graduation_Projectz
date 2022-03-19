package com.example.demo.mapper;

import com.example.demo.domain.Managers;

/**
* @author Forzh
* @description 针对表【managers】的数据库操作Mapper
* @createDate 2022-03-13 16:06:17
* @Entity com.example.demo.domain.Managers
*/
public interface ManagersMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Managers record);

    int insertSelective(Managers record);

    Managers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Managers record);

    int updateByPrimaryKey(Managers record);

}
