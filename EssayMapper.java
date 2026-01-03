package com.example.dao;

import com.example.pojo.Essay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EssayMapper {
    List<Essay> selectEssayAll();
    List<Essay> selectEssayById(int essay_id);
    List<Essay> selectEssayByTitle(String essay_title);   //模糊查询
    List<Essay> selectEssayByUserName(String user_name);

    List<Essay> selectEssayByUserNameAndTitle(@Param("user_name")String user_name, @Param("essay_title")String essay_title);
    int addEssay(Essay essay);
    int updateEssay(Essay essay);

    int deleteEssayById(int essay_id);

}
