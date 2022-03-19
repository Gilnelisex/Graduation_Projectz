package com.example.demo.mapper;

import com.example.demo.domain.Users;

/**
* @author Forzh
* @description 针对表【users】的数据库操作Mapper
* @createDate 2022-03-13 16:06:17
* @Entity com.example.demo.domain.Users
*/
public interface UsersMapper {

    Users selectUser(Users record);

    Users selectByPrimaryKey(Integer id);

    Users selectByNickname(Users record);

    Users selectByAccount(Users record);

    int updateByPrimaryKeySelective(Users record);

    int insert(Users record);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Users record);

    int updateByPrimaryKey(Users record);

}
