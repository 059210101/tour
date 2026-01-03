package com.example.dao;

import com.example.pojo.Admin;
import com.example.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface JudgeMapper {
    Admin judgeAdmin(@Param("name") String admin_name, @Param("password")String password);

    Users judgeUsers(@Param("name") String user_name, @Param("password")String password);

}
