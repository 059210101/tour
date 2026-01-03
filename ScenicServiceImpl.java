package com.example.service;

import com.example.dao.ScenicMapper;
import com.example.pojo.Scenic;

import java.util.List;

public class ScenicServiceImpl implements ScenicService{
    private ScenicMapper scenicMapper;

    public void setScenicMapper(ScenicMapper scenicMapper) {
        this.scenicMapper = scenicMapper;
    }

    @Override
    public List<Scenic> selectScenicAll() {
        return scenicMapper.selectScenicAll();
    }

    @Override
    public List<Scenic> selectScenicById(int scenic_id) {
        return scenicMapper.selectScenicById(scenic_id);
    }

    @Override
    public List<Scenic> selectScenicByName(String scenic_name) {
        return scenicMapper.selectScenicByName(scenic_name);
    }

    @Override
    public List<Scenic> selectScenicByTitle(String scenic_contact) {
        return scenicMapper.selectScenicByTitle(scenic_contact);
    }

    @Override
    public int addScenic(Scenic scenic) {
        return scenicMapper.addScenic(scenic);
    }

    @Override
    public int updateScenic(Scenic scenic) {
        return scenicMapper.updateScenic(scenic);
    }

    @Override
    public int deleteScenicById(int scenic_id) {
        return scenicMapper.deleteScenicById(scenic_id);
    }
}
