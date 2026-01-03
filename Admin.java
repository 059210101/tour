package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    /**
     * 管理员的ID
     */
    private int admin_id;
    /**
     * 管理员的姓名
     */
    private String admin_name;
    /**
     * 管理员的密码
     */
    private String password;
    /**
     * 管理员的联系方式
     */
    private String phone;
}
