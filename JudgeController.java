package com.example.controller;

import com.example.pojo.Admin;
import com.example.pojo.Users;
import com.example.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/judge")
public class JudgeController {
    @Autowired
    @Qualifier("JudgeServiceImpl")
    private JudgeService judgeService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "l_login";
    }
    @RequestMapping("/toSignup")
    public String toSignup(){
        return "l_signup";
    }

    @RequestMapping("/judgeLogin")
    public String judgeLogin(String name, String password, String category, Model model, HttpSession session){
        if ("管理员".equals(category)) {
            Admin admin = judgeService.judgeAdmin(name, password);
            if(admin!=null){
                session.setAttribute("admin",admin);
                return "redirect:/jsp/adminIndex.jsp";
            }else{
                model.addAttribute("error","用户名或密码错误");
                return "l_login";
            }
        }else {
            Users user = judgeService.judgeUsers(name, password);
            if(user!=null){
                session.setAttribute("user",user);
                return "redirect:/jsp/z_index.jsp";
            }else{
                model.addAttribute("error","用户名或密码错误");
                return "l_login";
            }
        }
    }
    @RequestMapping("/adminOut")
    public String adminOut(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/judge/toLogin";
    }
    @RequestMapping("/userOut")
    public String userOut(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/judge/toLogin";
    }
}
