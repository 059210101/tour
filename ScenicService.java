package com.example.service;

import com.example.pojo.Scenic;

import java.util.List;

public interface ScenicService {
    List<Scenic> selectScenicAll();
    List<Scenic> selectScenicById(int scenic_id);
    List<Scenic> selectScenicByName(String scenic_name);
    List<Scenic> selectScenicByTitle(String scenic_contact);   //按地址查询:模糊查询

    int addScenic(Scenic scenic);
    int updateScenic(Scenic scenic);
    int deleteScenicById(int scenic_id);
}
