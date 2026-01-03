package com.example.service;

import com.example.dao.UserMapper;
import com.example.pojo.Users;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int addUser(Users users) {
        return userMapper.addUser(users);
    }

    @Override
    public List<Users> selectUserAll() {
        return userMapper.selectUserAll();
    }

    @Override
    public List<Users> selectUserById(int user_id) {
        return userMapper.selectUserById(user_id);
    }

    @Override
    public List<Users> selectUserByName(String user_name) {
        return userMapper.selectUserByName(user_name);
    }

    @Override
    public int updateUser(Users users) {
        return userMapper.updateUser(users);
    }

    @Override
    public int updateUserAll(Users users) {
        return userMapper.updateUserAll(users);
    }

    @Override
    public int deleteUser(int user_id) {
        return userMapper.deleteUser(user_id);
    }
}
