package com.example.controller;

import com.example.pojo.Notice;
import com.example.pojo.Scenic;
import com.example.service.NoticeService;
import com.example.service.ScenicService;
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
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/scenic")
public class ScenicController {
    String saveFileName = "";
    @Autowired
    @Qualifier("ScenicServiceImpl")
    private ScenicService scenicService;

    @Autowired
    @Qualifier("NoticeServiceImpl")
    private NoticeService noticeService;


    @RequestMapping("/toAdminIndex")
    public String toAdminIndex(){
        return "adminIndex";
    }
    @RequestMapping("/addScenic")
    public String addScenic(Scenic scenic,Model model) throws ParseException {
        if (!"".equals(scenic.getScenic_name()) && !"".equals(scenic.getScenic_address()) &&
                !"".equals(scenic.getScenic_price())) {
            scenic.setScenic_photo(saveFileName);
            scenic.setScenic_addtime(new Time().Conversion(String.valueOf(new Date())));
            int result = scenicService.addScenic(scenic);
            saveFileName = "";
            if (result > 0) {
                System.out.println("添加成功");
            }
        }
        return "scenicAdd";
    }

    @RequestMapping("/selectScenicAll")
    public String selectScenicAll(Model model){
        List<Scenic> scenicList = scenicService.selectScenicAll();
        model.addAttribute("scenicList",scenicList);
        return "scenicUpdate";
    }
    @RequestMapping("/selectScenicAllUserAction")
    public String selectScenicAllUserAction(Model model){
        List<Scenic> scenicList = scenicService.selectScenicAll();
        model.addAttribute("scenicList",scenicList);
        return "z_Scenic";
    }

    @RequestMapping("/selectScenicById")
    public String selectScenicById(int scenic_id,Model model){
        List<Scenic> scenicList = scenicService.selectScenicById(scenic_id);
        model.addAttribute("scenicList",scenicList);
        return "scenicUpdate";
    }

    @RequestMapping("/selectScenicByName")
    public String selectScenicByName(String scenic_name,Model model){
        List<Scenic> scenicList = scenicService.selectScenicByName(scenic_name);
        model.addAttribute("scenicList",scenicList);
        return "scenicUpdate";
    }
    @RequestMapping("/selectScenicByNameUserAction")
    public String selectScenicByNameUserAction(String scenic_name,Model model){
        List<Scenic> scenicList = scenicService.selectScenicByName(scenic_name);
        model.addAttribute("scenicList",scenicList);
        return "z_Scenic";
    }
    @RequestMapping("/selectScenicByTitle")
    public String selectScenicByTitle(String scenic_contact,Model model){
        List<Scenic> scenicList = scenicService.selectScenicByTitle(scenic_contact);
        model.addAttribute("scenicList",scenicList);
        return "scenicUpdate";
    }

    @RequestMapping("/toScenicUpdateChange")
    public String toScenicLook(int scenic_id,Model model){
        List<Scenic> scenicList = scenicService.selectScenicById(scenic_id);
        model.addAttribute("scenicList",scenicList);
        return "scenicUpdateChange";
    }

    @RequestMapping("/updateScenic")
    public String updateScenic(Scenic scenic,Model model){
        if (saveFileName.equals("")){
            scenicService.updateScenic(scenic);
        }else {
            scenic.setScenic_photo(saveFileName);
            saveFileName = "";
            scenicService.updateScenic(scenic);
        }
        return "redirect:/scenic/selectScenicAll";
    }
    @RequestMapping("/deleteScenicById")
    public String deleteScenicById(int scenic_id,Model model){
        scenicService.deleteScenicById(scenic_id);
        return "redirect:/scenic/selectScenicAll";
    }
    @RequestMapping("/toUserScenicLook")
    public String toUserScenicLook(int scenic_id,Model model){
        List<Scenic> scenicList = scenicService.selectScenicById(scenic_id);
        model.addAttribute("scenicList",scenicList);
        List<Notice> noticeList = noticeService.selectNoticeByScenicName(scenicList.get(0).getScenic_name());
        model.addAttribute("noticeList",noticeList);
        return "z_ScenicLook";
    }

    @ResponseBody   //作用：将处理结果直接以JSON格式返回给前端客户端
    @RequestMapping("/ajaxImg")
    public Object ajaxImg(MultipartFile scenic_photo, HttpServletRequest request) {
        //提取生成文件名UUID+上传图片的后缀.jpg .png
        saveFileName = FileNameUtil.getUUIDFileName()+ FileNameUtil.getFileType(scenic_photo.getOriginalFilename());
        System.out.println(saveFileName+"111");
        //得到项目中图片存储的路径
        String path = request.getServletContext().getRealPath("/img");
        //转存
        try {
            scenic_photo.transferTo(new File(path+File.separator+saveFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //返回客户端JSON对象，封装图片的路径，为了在页面实现立即回显
        JSONObject object = new JSONObject();
        object.put("imgurl",saveFileName);
        return object.toString();
    }
}
