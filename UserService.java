package com.example.service;

import com.example.pojo.Users;

import java.util.List;

public interface UserService {
    int addUser(Users users);
    List<Users> selectUserAll();
    List<Users> selectUserById(int user_id);

    List<Users> selectUserByName(String user_name);
    int updateUser(Users users);
    int updateUserAll(Users users);
    int deleteUser(int user_id);

}
