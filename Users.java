package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {    //用户类
    /**
     * 用户ID
     */
    private int user_id;
    /**
     * 用户名
     */
    private String user_name;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 用户添加时间
     */
    private String adddata;
}
