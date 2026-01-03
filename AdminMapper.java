package com.example.dao;

import com.example.pojo.Admin;

import java.util.List;

public interface AdminMapper {
    List<Admin> selectAdminAll();
    int updateAdmin(Admin admin);
    Admin selectAdminById(int admin_id);
}
