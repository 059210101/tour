package com.example.service;

import com.example.dao.EssayMapper;
import com.example.pojo.Essay;

import java.util.List;

public class EssayServiceImpl implements EssayService{
    private EssayMapper essenceMapper;

    public void setEssenceMapper(EssayMapper essenceMapper) {
        this.essenceMapper = essenceMapper;
    }

    @Override
    public List<Essay> selectEssayAll() {
        return essenceMapper.selectEssayAll();
    }

    @Override
    public List<Essay> selectEssayById(int essay_id) {
        return essenceMapper.selectEssayById(essay_id);
    }

    @Override
    public List<Essay> selectEssayByTitle(String essay_title) {
        return essenceMapper.selectEssayByTitle(essay_title);
    }

    @Override
    public List<Essay> selectEssayByUserName(String user_name) {
        return essenceMapper.selectEssayByUserName(user_name);
    }

    @Override
    public List<Essay> selectEssayByUserNameAndTitle(String user_name, String essay_title) {
        return essenceMapper.selectEssayByUserNameAndTitle(user_name,essay_title);
    }

    @Override
    public int addEssay(Essay essay) {
        return essenceMapper.addEssay(essay);
    }

    @Override
    public int updateEssay(Essay essay) {
        return essenceMapper.updateEssay(essay);
    }

    @Override
    public int deleteEssayById(int essay_id) {
        return essenceMapper.deleteEssayById(essay_id);
    }


}
