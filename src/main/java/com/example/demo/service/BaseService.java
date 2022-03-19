package com.example.demo.service;

import com.example.demo.domain.Base;

import java.util.List;

/**
* @author Forzh
* @description 针对表【base】的数据库操作Service
* @createDate 2022-03-13 16:06:00
*/
public interface BaseService {

    List<Base> selectAllBase(Base record, Integer pageNum, Integer pageSize);

    List<Base> selectAllType();

    List<Base> selectAllProv();

    List<Base> selectAllCity(Base base);

    List<Base> selectNewBase();

    int selectBaseCount();

    Base selectByPrimaryKey(Integer id);

}
