package com.example.service;

import com.example.pojo.Guestbook;

import java.util.List;

public interface GuestbookService {
    List<Guestbook> selectGuestbookAll();
    List<Guestbook> selectGuestbookById(int guestbook_id);
    List<Guestbook> selectGuestbookByName(String user_name);
    int addGuestbook(Guestbook guestbook);
    int updateGuestbook(int guestbook_id);
    int deleteGuestbook(int guestbook_id);

}
