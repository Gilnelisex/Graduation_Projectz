package com.example.demo.service;

import com.example.demo.domain.Users;

/**
* @author Forzh
* @description 针对表【users】的数据库操作Service
* @createDate 2022-03-13 16:06:00
*/
public interface UsersService {

    Users selectUser(Users record);

    Users selectByNickname(Users record);

    Users selectByAccount(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int insertSelective(Users record);

}
