package com.example.demo.service.impl;

import com.example.demo.domain.Base;
import com.example.demo.mapper.BaseMapper;
import com.example.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Forzh
* @description 针对表【base】的数据库操作Service实现
* @createDate 2022-03-13 16:06:00
*/
@Service
public class BaseServiceImpl implements BaseService{

    @Autowired
    BaseMapper baseMapper;

    @Override
    public List<Base> selectAllBase(Base record, Integer pageNum, Integer pageSize) {
        return this.baseMapper.selectAllBase(record, pageNum, pageSize);
    }

    @Override
    public List<Base> selectAllType() {
        return this.baseMapper.selectAllType();
    }

    @Override
    public List<Base> selectAllProv() {
        return this.baseMapper.selectAllProv();
    }

    @Override
    public List<Base> selectAllCity(Base base) {
        return this.baseMapper.selectAllCity(base);
    }

    @Override
    public List<Base> selectNewBase() {
        return this.baseMapper.selectNewBase();
    }

    @Override
    public int selectBaseCount() {
        return this.baseMapper.selectBaseCount();
    }

    @Override
    public Base selectByPrimaryKey(Integer id) {
        return this.baseMapper.selectByPrimaryKey(id);
    }
}
