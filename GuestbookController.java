package com.example.controller;

import com.example.pojo.Guestbook;
import com.example.pojo.Users;
import com.example.service.GuestbookService;
import com.example.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
    @Autowired
    @Qualifier("GuestbookServiceImpl")
    private GuestbookService guestbookService;

    @RequestMapping("/selectGuestbookAll")
    public String selectGuestbookAll(Model model){
        List<Guestbook> guestbookList = guestbookService.selectGuestbookAll();
        model.addAttribute("guestbookList",guestbookList);
        return "guestbook";
    }
    @RequestMapping("/selectGuestbookById")
    public String selectGuestbookById(int guestbook_id, Model model){
        List<Guestbook> guestbookList = guestbookService.selectGuestbookById(guestbook_id);
        model.addAttribute("guestbookList",guestbookList);
        return "guestbook";
    }
    @RequestMapping("/selectGuestbookByName")
    public String selectGuestbookByName(String user_name, Model model){
        List<Guestbook> guestbookList = guestbookService.selectGuestbookByName(user_name);
        model.addAttribute("guestbookList",guestbookList);
        return "guestbook";
    }
    @RequestMapping("/selectGuestbookByNameUserAction")
    public String selectGuestbookByNameUserAction(HttpSession session,Model model){
        Users user = (Users) session.getAttribute("user");
        List<Guestbook> guestbookList = guestbookService.selectGuestbookByName(user.getUser_name());
        model.addAttribute("guestbookList",guestbookList);
        return "z_userGuestbook";
    }
    @RequestMapping("/deleteGuestbook")
    public String deleteGuestbook(int guestbook_id, Model model){
        int num = guestbookService.deleteGuestbook(guestbook_id);
        if (num > 0){
            model.addAttribute("judge","删除成功");
        }else{
            model.addAttribute("judge","删除失败");
        }
        return "redirect:/guestbook/selectGuestbookAll";
    }
    @RequestMapping("/toGuestbookLook")
    public String toGuestbookLook(int guestbook_id, Model model){
        List<Guestbook> guestbookList = guestbookService.selectGuestbookById(guestbook_id);
        guestbookService.updateGuestbook(guestbook_id);
        model.addAttribute("guestbookList",guestbookList);
        return "guestbookLook";
    }

    @RequestMapping("/toGuestbookUserLook")
    public String toGuestbookUserLook(int guestbook_id, Model model){
        List<Guestbook> guestbookList = guestbookService.selectGuestbookById(guestbook_id);
        model.addAttribute("guestbookList",guestbookList);
        return "guestbookLook";
    }

    @RequestMapping("/addGuestbook")
    public String addGuestbook(Guestbook guestbook, Model model, HttpSession session) throws ParseException {
        Users user = (Users) session.getAttribute("user");
        guestbook.setUser_name(user.getUser_name());
        guestbook.setGuestbook_addtime(new Time().Conversion(String.valueOf(new Date())));
        int num = guestbookService.addGuestbook(guestbook);
        if (num > 0){
            model.addAttribute("judge","留言成功");
        }else{
            model.addAttribute("judge","留言失败");
        }
        return "z_guestbook";
    }
}
