package com.example.demo.mapper;

import com.example.demo.domain.Joininfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Forzh
* @description 针对表【joininfo】的数据库操作Mapper
* @createDate 2022-03-13 16:06:17
* @Entity com.example.demo.domain.Joininfo
*/
public interface JoininfoMapper {

    List<Joininfo> selectByDate(@Param("joininfo") Joininfo record);

    Joininfo selectByJoinInfoID(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Joininfo record);

    int insertSelective(Joininfo record);

    List<Joininfo> selectByUserID(Integer id);

    Joininfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Joininfo record);

    int updateByPrimaryKey(Joininfo record);

}
