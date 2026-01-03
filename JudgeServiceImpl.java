package com.example.service;

import com.example.dao.JudgeMapper;
import com.example.pojo.Admin;
import com.example.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

public class JudgeServiceImpl implements JudgeService{
    private JudgeMapper judgeMapper;

    public void setJudgeMapper(JudgeMapper judgeMapper) {
        this.judgeMapper = judgeMapper;
    }

    @Override
    public Admin judgeAdmin(String admin_name, String password) {
        return judgeMapper.judgeAdmin(admin_name,password);
    }

    @Override
    public Users judgeUsers(String name, String password) {
        return judgeMapper.judgeUsers(name,password);
    }
}
