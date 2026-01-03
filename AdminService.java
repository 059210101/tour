package com.example.service;

import com.example.pojo.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> selectAdminAll();
    int updateAdmin(Admin admin);
    Admin selectAdminById(int admin_id);

}
