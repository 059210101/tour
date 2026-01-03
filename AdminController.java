package com.example.controller;

import com.example.pojo.Admin;
import com.example.pojo.Users;
import com.example.service.AdminService;
import com.example.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    @RequestMapping("/toAdminIndex")
    public String toAdminIndex(){
        return "redirect:/jsp/adminIndex.jsp";
    }

    @RequestMapping("/updateAdmin")
    public String updateAdmin(int admin_id, String admin_name, String password_now, String password_new, String password_new2, String phone, Model model, HttpSession session){
        if (!Objects.equals(password_new, password_new2)){
            model.addAttribute("judge","修改失败：两次输入密码不一致");
        }else {
            if (!Objects.equals(adminService.selectAdminById(admin_id).getPassword(),password_now)){
                model.addAttribute("judge","修改失败：原密码错误");
            }else {
                adminService.updateAdmin(new Admin(admin_id, admin_name, password_new, phone));
                session.setAttribute("admin", adminService.selectAdminById(admin_id));
                model.addAttribute("judge", "修改成功");
            }
        }
        return "adminPersonalManagement";
    }


}
