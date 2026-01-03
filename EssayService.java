package com.example.service;

import com.example.pojo.Essay;

import java.util.List;

public interface EssayService {
    List<Essay> selectEssayAll();
    List<Essay> selectEssayById(int essay_id);
    List<Essay> selectEssayByTitle(String essay_title);   //模糊查询
    List<Essay> selectEssayByUserName(String user_name);

    List<Essay> selectEssayByUserNameAndTitle(String user_name,String essay_title);

    int addEssay(Essay essay);
    int updateEssay(Essay essay);

    int deleteEssayById(int essay_id);
}
