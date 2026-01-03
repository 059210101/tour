package com.example.service;

import com.example.pojo.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> selectNoticeAll();
    List<Notice> selectNoticeByScenicName(String scenic_name);

    List<Notice> selectNoticeByTitle(String notice_title);
    List<Notice> selectNoticeById(int notice_id);

    int addNotice(Notice notice);
    int deleteNotice(int notice_id);
    int updateNotice(Notice notice);
}
