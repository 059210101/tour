package com.example.dao;

import com.example.pojo.Users;

import java.util.List;

public interface UserMapper {
    int addUser(Users users);

    List<Users> selectUserAll();
    List<Users> selectUserById(int user_id);

    List<Users> selectUserByName(String user_name);

    int updateUser(Users users);    //管理员修改用户部分信息
    int updateUserAll(Users users); //用户自行修改，可修改除Id和用户名外所有信息

    int deleteUser(int user_id);
}
