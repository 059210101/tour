package com.example.service;

import com.example.dao.NoticeMapper;
import com.example.pojo.Notice;

import java.util.List;

public class NoticeServiceImpl implements NoticeService{
    private NoticeMapper noticeMapper;

    public void setNoticeMapper(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    @Override
    public List<Notice> selectNoticeAll() {
        return noticeMapper.selectNoticeAll();
    }

    @Override
    public List<Notice> selectNoticeByScenicName(String scenic_name) {
        return noticeMapper.selectNoticeByScenicName(scenic_name);
    }

    @Override
    public List<Notice> selectNoticeByTitle(String notice_title) {
        return noticeMapper.selectNoticeByTitle(notice_title);
    }

    @Override
    public List<Notice> selectNoticeById(int notice_id) {
        return noticeMapper.selectNoticeById(notice_id);
    }

    @Override
    public int addNotice(Notice notice) {
        return noticeMapper.addNotice(notice);
    }

    @Override
    public int deleteNotice(int notice_id) {
        return noticeMapper.deleteNotice(notice_id);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }
}
