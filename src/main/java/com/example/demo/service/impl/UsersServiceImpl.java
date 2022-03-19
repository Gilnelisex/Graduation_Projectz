package com.example.demo.service.impl;

import com.example.demo.domain.Users;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Forzh
* @description 针对表【users】的数据库操作Service实现
* @createDate 2022-03-13 16:06:00
*/
@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Users selectUser(Users record) {
        return this.usersMapper.selectUser(record);
    }

    @Override
    public Users selectByNickname(Users record) {
        return this.usersMapper.selectByNickname(record);
    }

    @Override
    public Users selectByAccount(Users record) {
        return this.usersMapper.selectByAccount(record);
    }

    @Override
    public Users selectByPrimaryKey(Integer id) {
        return this.usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return this.usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(Users record) {
        return this.usersMapper.insertSelective(record);
    }
}
