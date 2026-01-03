package com.example.service;

import com.example.dao.GuestbookMapper;
import com.example.pojo.Guestbook;

import java.util.List;

public class GuestbookServiceImpl implements GuestbookService{
    private GuestbookMapper guestbookMapper;
    public void setGuestbookMapper(GuestbookMapper guestbookMapper) {
        this.guestbookMapper = guestbookMapper;
    }
    @Override
    public List<Guestbook> selectGuestbookAll() {
        return guestbookMapper.selectGuestbookAll();
    }

    @Override
    public List<Guestbook> selectGuestbookById(int guestbook_id) {
        return guestbookMapper.selectGuestbookById(guestbook_id);
    }

    @Override
    public List<Guestbook> selectGuestbookByName(String user_name) {
        return guestbookMapper.selectGuestbookByName(user_name);
    }

    @Override
    public int addGuestbook(Guestbook guestbook) {
        return guestbookMapper.addGuestbook(guestbook);
    }

    @Override
    public int updateGuestbook(int guestbook_id) {
        return guestbookMapper.updateGuestbook(guestbook_id);
    }

    @Override
    public int deleteGuestbook(int guestbook_id) {
        return guestbookMapper.deleteGuestbook(guestbook_id);
    }
}
