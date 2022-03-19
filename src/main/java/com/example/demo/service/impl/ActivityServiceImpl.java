package com.example.demo.service.impl;

import com.example.demo.domain.Activity;
import com.example.demo.mapper.ActivityMapper;
import com.example.demo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Forzh
* @description 针对表【activity】的数据库操作Service实现
* @createDate 2022-03-13 16:06:00
*/
@Service
public class ActivityServiceImpl implements ActivityService{

    @Autowired
    ActivityMapper activityMapper;

    @Override
    public List<Activity> selectAllAct(Activity activity, Integer pageNum, Integer pageSize) {
        return this.activityMapper.selectAllAct(activity, pageNum, pageSize);
    }

    @Override
    public List<Activity> selectByBase(Integer id) {
        return this.activityMapper.selectByBase(id);
    }

    @Override
    public List<Activity> selectAllType() {
        return this.activityMapper.selectAllType();
    }

    @Override
    public List<Activity> selectAllHarvest() {
        return this.activityMapper.selectAllHarvest();
    }

    @Override
    public List<Activity> selectNewAct() {
        return this.activityMapper.selectNewAct();
    }

    @Override
    public Activity selectByPrimaryKey(Integer id) {
        return this.activityMapper.selectByPrimaryKey(id);
    }
}
