package com.example.demo.mapper;

import com.example.demo.domain.Dictionary;

/**
* @author Forzh
* @description 针对表【dictionary】的数据库操作Mapper
* @createDate 2022-03-13 16:06:17
* @Entity com.example.demo.domain.Dictionary
*/
public interface DictionaryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

}
