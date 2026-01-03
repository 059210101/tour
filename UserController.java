package com.example.controller;

import com.example.pojo.Users;
import com.example.service.UserService;
import com.example.utils.MD5Util;
import com.example.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;


    @RequestMapping("/toUserIndex")
    public String toUserIndex(){
        return "z_userIndex";
    }
    @RequestMapping("/toAddUser")
    public String toAddUser(){          //前往addUser.jsp页
        return "userAdd";
    }
    @RequestMapping("/addUser")
    public String addUser(Users user, Model model) throws ParseException {      //增加一个用户
        String judge = "";
        user.setAdddata(new Time().Conversion(String.valueOf(new Date())));
        List<Users> userList = userService.selectUserByName(user.getUser_name());
        if (userList.size() == 0){
            int num = userService.addUser(user);
            if (num>0){
                judge = "添加成功";
            }else{
                judge = "添加失败，请重试";
            }
        }else{
            judge = "添加失败：用户名已被占用";
        }
        model.addAttribute("judge",judge);
        return "forward:/user/toAddUser";
    }
    @RequestMapping("/selectAllUser")
    public String selectAllUser(Model model) throws ParseException {      //查询所有用户
        List<Users> userList = userService.selectUserAll();
        for (Users users : userList) {
            users.setPassword(new MD5Util().getMD5(users.getPassword()));
        }
        model.addAttribute("userList",userList);
        return "userUpdate";
    }
    @RequestMapping("/selectUserByName")
    public String selectUserByName(String user_name, Model model) throws ParseException {      //根据用户名查询用户
        List<Users> userList = userService.selectUserByName(user_name);
        for (Users users : userList) {
            users.setPassword(new MD5Util().getMD5(users.getPassword()));
        }
        model.addAttribute("userList",userList);
        return "userUpdate";
    }

    @RequestMapping("/toChange")
    public String toUpdate(String user_name,Model model){          //前往change.jsp页
        List<Users> userList = userService.selectUserByName(user_name);
        model.addAttribute("userList",userList);
        return "userUpdateChange";
    }
    @RequestMapping("/updateUser")
    public String updateUser(Users user,Model model){
        int num = userService.updateUser(user);
        if (num>0){
            model.addAttribute("judge","修改成功");
        }else {
            model.addAttribute("judge","修改失败");
        }
        return "forward:/user/selectAllUser";
    }

    @RequestMapping("/toUpdateUserAll")
    public String toUpdateUserAll(HttpSession session, Model model){
        Users user = (Users) session.getAttribute("user");
        List<Users> usersList = userService.selectUserByName(user.getUser_name());
        model.addAttribute("userList",usersList);
        return "z_userPersonalManagement";
    }
    @RequestMapping("/updateUserAll")
    public String updateUserAll(int user_id,String user_name,String password_now,
                                String password_new,String password_new2,String phone,
            String sex,String birthday,Model model){
        List<Users> usersList = userService.selectUserById(user_id);
        Users user_now = usersList.get(0);
        if (password_now.equals(user_now.getPassword())&&password_new.equals(password_new2)) {
            Users user_new = new Users();
            user_new.setUser_id(user_id);
            user_new.setPassword(password_new);
            user_new.setPhone(phone);
            user_new.setSex(sex);
            user_new.setBirthday(birthday);
            int num = userService.updateUserAll(user_new);
            if (num > 0) {
                model.addAttribute("judge", "修改成功");
            } else {
                model.addAttribute("judge", "修改失败");
            }
        }else if (!password_now.equals(user_now.getPassword())){
            model.addAttribute("judge","修改失败：原密码错误");
        }else if (!password_new.equals(password_new2)){
            model.addAttribute("judge","修改失败：两次输入的密码不一致");
        }
        model.addAttribute("userList",userService.selectUserByName(user_name));
        return "z_userPersonalManagement";
    }

    @RequestMapping("/CheckUserName")
    @ResponseBody
    public String checkUserName(String user_name) {
        List<Users> userList = userService.selectUserByName(user_name);
        String msg = userList.size() == 0 ? "OK" : "用户名已被占用";
        return msg;
    }
    @RequestMapping("/signupUser")
    public String signupUser(String user_name,String password,String confirmPassword,
            String sex,String birthday,String phone,Model model) throws ParseException {
        if (password.equals(confirmPassword)){
            List<Users> usersList = userService.selectUserByName(user_name);
            if (usersList.size()==0){
                Users user = new Users();
                user.setUser_name(user_name);
                user.setPassword(password);
                user.setSex(sex);
                user.setBirthday(birthday);
                user.setPhone(phone);
                user.setAdddata(new Time().Conversion(String.valueOf(new Date())));
                userService.addUser(user);
                model.addAttribute("judge","注册成功");
                return "l_login";
            }else {
                model.addAttribute("judge","注册失败：用户名已被占用");
                return "l_signup";
            }

        }else {
            model.addAttribute("judge","注册失败：两次输入的密码不一致");
            return "l_signup";
        }
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(int user_id,Model model){
        int num = userService.deleteUser(user_id);
        if (num>0){
            model.addAttribute("judge","删除成功");
        }else {
            model.addAttribute("judge","删除失败");
        }
        return "forward:/user/selectAllUser";
    }
}
