package com.example.dao;

import com.example.pojo.Notice;

import java.util.List;

public interface NoticeMapper {
    List<Notice> selectNoticeAll();
    //根据景点名字查询
    List<Notice> selectNoticeByScenicName(String scenic_name);
    //根据标题模糊查询
    List<Notice> selectNoticeByTitle(String notice_title);
    List<Notice> selectNoticeById(int notice_id);
    int addNotice(Notice notice);
    int deleteNotice(int notice_id);
    int updateNotice(Notice notice);
}
