package com.example.service;

import com.example.dao.AdminMapper;
import com.example.pojo.Admin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class AdminServiceImpl implements AdminService{
    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }


    @Override
    public List<Admin> selectAdminAll() {
        return adminMapper.selectAdminAll();
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

    @Override
    public Admin selectAdminById(int admin_id) {
        return adminMapper.selectAdminById(admin_id);
    }
}
