package com.example.demo.service.impl;

import com.example.demo.domain.Joininfo;
import com.example.demo.mapper.JoininfoMapper;
import com.example.demo.service.JoininfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Forzh
* @description 针对表【joininfo】的数据库操作Service实现
* @createDate 2022-03-13 16:06:00
*/
@Service
public class JoininfoServiceImpl implements JoininfoService{

    @Autowired
    JoininfoMapper joininfoMapper;

    @Override
    public List<Joininfo> selectByDate(Joininfo record) {
        return this.joininfoMapper.selectByDate(record);
    }

    @Override
    public Joininfo selectByJoinInfoID(Integer id) {
        return this.joininfoMapper.selectByJoinInfoID(id);
    }

    @Override
    public int insertSelective(Joininfo record) {
        return this.joininfoMapper.insertSelective(record);
    }

    @Override
    public List<Joininfo> selectByUserID(Integer id) {
        return this.joininfoMapper.selectByUserID(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Joininfo record) {
        return this.joininfoMapper.updateByPrimaryKeySelective(record);
    }
}
