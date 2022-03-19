package com.example.demo.service;

import com.example.demo.domain.Joininfo;

import java.util.List;

/**
* @author Forzh
* @description 针对表【joininfo】的数据库操作Service
* @createDate 2022-03-13 16:06:00
*/
public interface JoininfoService {

    List<Joininfo> selectByDate(Joininfo record);

    Joininfo selectByJoinInfoID(Integer id);

    int insertSelective(Joininfo record);

    List<Joininfo> selectByUserID(Integer id);

    int updateByPrimaryKeySelective(Joininfo record);

}
