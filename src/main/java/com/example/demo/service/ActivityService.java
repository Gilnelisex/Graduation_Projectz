package com.example.demo.service;

import com.example.demo.domain.Activity;

import java.util.List;

/**
* @author Forzh
* @description 针对表【activity】的数据库操作Service
* @createDate 2022-03-13 16:06:00
*/
public interface ActivityService {

    List<Activity> selectAllAct(Activity activity, Integer pageNum, Integer pageSize);

    List<Activity> selectByBase(Integer id);

    List<Activity> selectAllType();

    List<Activity> selectAllHarvest();

    List<Activity> selectNewAct();

    Activity selectByPrimaryKey(Integer id);

}
