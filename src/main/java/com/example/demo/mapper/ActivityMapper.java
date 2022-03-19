package com.example.demo.mapper;

import com.example.demo.domain.Activity;
import com.example.demo.domain.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Forzh
* @description 针对表【activity】的数据库操作Mapper
* @createDate 2022-03-13 16:06:17
* @Entity com.example.demo.domain.Activity
*/
public interface ActivityMapper {

    List<Activity> selectAllAct(@Param("activity") Activity activity,
                                @Param("pageNum") Integer pageNum,
                                @Param("pageSize") Integer pageSize);

    List<Activity> selectByBase(Integer id);

    List<Activity> selectAllType();

    List<Activity> selectAllHarvest();

    List<Activity> selectNewAct();

    int deleteByPrimaryKey(Integer id);

    int insert(Activity record);

    int insertSelective(Activity record);

    Activity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Activity record);

    int updateByPrimaryKey(Activity record);

}
