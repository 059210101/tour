package com.example.controller;

import com.example.pojo.Comments;
import com.example.pojo.Essay;
import com.example.pojo.Users;
import com.example.service.CommentsService;
import com.example.service.EssayService;
import com.example.utils.FileNameUtil;
import com.example.utils.Time;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/essay")
public class EssayController {
    String saveFileName = "";
    @Autowired
    @Qualifier("EssayServiceImpl")
    private EssayService essayService;

    @Autowired
    @Qualifier("CommentsServiceImpl")
    private CommentsService commentsService;

    @RequestMapping("/selectEssayAll")
    public String selectEssayAll(Model model){
        List<Essay> essayList = essayService.selectEssayAll();
        model.addAttribute("essayList",essayList);
        return "essayPersonalManagement";
    }

    @RequestMapping("/selectEssayById")
    public String selectEssayById(int essay_id,Model model){
        List<Essay> essayList = essayService.selectEssayById(essay_id);
        model.addAttribute("essayList",essayList);
        return "essayPersonalManagement";
    }
    @RequestMapping("/selectEssayByTitle")
    public String selectEssayByTitle(String essay_title,Model model){
        List<Essay> essayList = essayService.selectEssayByTitle(essay_title);
        model.addAttribute("essayList",essayList);
        return "essayPersonalManagement";
    }
    @RequestMapping("/selectEssayByUserName")
    public String selectEssayByUserName(String user_name,Model model){
        List<Essay> essayList = essayService.selectEssayByUserName(user_name);
        model.addAttribute("essayList",essayList);
        return "essayPersonalManagement";
    }

    @RequestMapping("/addEssay")
    public String addEssay(Essay essay,Model model,HttpSession session) throws ParseException {
        Users user = (Users) session.getAttribute("user");
        essay.setUser_name(user.getUser_name());
        essay.setEssay_photo(saveFileName);
        saveFileName = "";
        essay.setEssay_addtime(new Time().Conversion(String.valueOf(new Date())));
        int i = essayService.addEssay(essay);
        if(i>0){
            model.addAttribute("judge","添加成功");
        }else{
            model.addAttribute("judge","添加失败");
        }
        return "z_userEssayAdd";
    }

    @RequestMapping("/selectEssayByUserNameUserAction")
    public String selectEssayByUserNameUserAction(HttpSession session,Model model){
        Users user = (Users) session.getAttribute("user");
        List<Essay> essayList = essayService.selectEssayByUserName(user.getUser_name());
        model.addAttribute("essayList",essayList);
        return "z_userEssayPersonalManagement";
    }

    @RequestMapping("/selectEssayByUserNameAndTitle")
    public String selectEssayByUserNameAndTitle(String essay_title,Model model,HttpSession session){
        Users user = (Users) session.getAttribute("user");
        String user_name = user.getUser_name();
        List<Essay> essayList = essayService.selectEssayByUserNameAndTitle(user_name,essay_title);
        model.addAttribute("essayList",essayList);
        return "z_userEssayPersonalManagement";
    }
    @RequestMapping("/toUpdateEssay")
    public String toUpdateEssay(int essay_id,Model model){
        List<Essay> essayList = essayService.selectEssayById(essay_id);
        model.addAttribute("essayList",essayList);
        return "z_userEssayUpdate";
    }
    @RequestMapping("/updateEssay")
    public String updateEssay(Essay essay,Model model,HttpSession session) throws ParseException {
        if (!"".equals(essay.getEssay_photo())) {
            saveFileName = essay.getEssay_photo();
        }
        Essay essay_new = new Essay();
        essay_new.setUser_name(essay.getUser_name());
        essay_new.setEssay_title(essay.getEssay_title());
        essay_new.setEssay_contents(essay.getEssay_contents());
        essay_new.setEssay_addtime(new Time().Conversion(String.valueOf(new Date())));
        deleteEssayById(essay.getEssay_id(),model);
        addEssay(essay_new, model, session);
        return "z_userEssayUpdate";
    }

    @RequestMapping("/deleteEssayById")
    public String deleteEssayById(int essay_id,Model model){
        int i = essayService.deleteEssayById(essay_id);
        if(i>0){
            model.addAttribute("judge","删除成功");
        }else{
            model.addAttribute("judge","删除失败");
        }
        return "redirect:/essay/selectEssayAll";
    }

    @RequestMapping("/toEssayLook")
    public String toEssayLook(int essay_id,Model model){
        List<Essay> essayList = essayService.selectEssayById(essay_id);
        model.addAttribute("essayList",essayList);
        return "essayLook";
    }


    @RequestMapping("/toUserEssayUserAction")
    public String toUserEssayUserAction(Model model){
        List<Essay> essayList = essayService.selectEssayAll();
        model.addAttribute("essayList",essayList);
        return "z-essay";
    }
    @RequestMapping("/selectEssayByUserNameUserActionTwo")
    public String selectEssayByUserNameUserActionTwo(String user_name,Model model){
        List<Essay> essayList = essayService.selectEssayByUserName(user_name);
        model.addAttribute("essayList",essayList);
        return "z-essay";
    }
    @RequestMapping("/selectEssayByTitleUserAction")
    public String selectEssayByTitleUserAction(String essay_title,Model model){
        List<Essay> essayList = essayService.selectEssayByTitle(essay_title);
        model.addAttribute("essayList",essayList);
        return "z-essay";
    }
    @RequestMapping("/toEssayLookUserAction")
    public String toEssayLookUserAction(int essay_id,Model model,HttpSession session){
        List<Essay> essayList = essayService.selectEssayById(essay_id);
        model.addAttribute("essayList",essayList);
        Users user = (Users) session.getAttribute("user");
        model.addAttribute("user",user);
        List<Comments> commentsList = commentsService.selectCommentsAll(essay_id);
        model.addAttribute("commentsList",commentsList);
        return "z-essayLook";
    }


    @ResponseBody   //作用：将处理结果直接以JSON格式返回给前端客户端
    @RequestMapping("/ajaxImg")
    public Object ajaxImg(MultipartFile essay_photo, HttpServletRequest request) {
        //提取生成文件名UUID+上传图片的后缀.jpg .png
        saveFileName = FileNameUtil.getUUIDFileName()+ FileNameUtil.getFileType(essay_photo.getOriginalFilename());
        System.out.println(saveFileName+"111");
        //得到项目中图片存储的路径
        String path = request.getServletContext().getRealPath("/img");
        //转存
        try {
            essay_photo.transferTo(new File(path+File.separator+saveFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //返回客户端JSON对象，封装图片的路径，为了在页面实现立即回显
        JSONObject object = new JSONObject();
        object.put("imgurl",saveFileName);
        return object.toString();
    }
}
