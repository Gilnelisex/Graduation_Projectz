package com.example.demo.mapper;

import com.example.demo.domain.Base;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Forzh
* @description 针对表【base】的数据库操作Mapper
* @createDate 2022-03-13 16:06:17
* @Entity com.example.demo.domain.Base
*/
public interface BaseMapper {

    List<Base> selectAllBase(@Param("base") Base record,
                             @Param("pageNum") Integer pageNum,
                             @Param("pageSize") Integer pageSize);

    List<Base> selectAllType();

    List<Base> selectAllProv();

    List<Base> selectAllCity(Base base);

    List<Base> selectNewBase();

    int selectBaseCount();

    int deleteByPrimaryKey(Integer id);

    int insert(Base record);

    int insertSelective(Base record);

    Base selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Base record);

    int updateByPrimaryKey(Base record);

}
