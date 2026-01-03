package com.example.controller;

import com.example.pojo.Notice;
import com.example.service.NoticeService;
import com.example.utils.FileNameUtil;
import com.example.utils.Time;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    //异步上传的图片的名称
    String saveFileName = "";

    @Autowired
    @Qualifier("NoticeServiceImpl")
    private NoticeService noticeService;

    @RequestMapping("/selectNoticeAll")
    public String selectNoticeAll(Model model){
        List<Notice> noticeList = noticeService.selectNoticeAll();
        model.addAttribute("noticeList",noticeList);
        return "noticePersonalManagement";
    }
    @RequestMapping("/selectNoticeByTitle")
    public String selectNoticeByTitle(String notice_title,Model model){
        List<Notice> noticeList = noticeService.selectNoticeByTitle(notice_title);
        model.addAttribute("noticeList",noticeList);
        return "noticePersonalManagement";
    }
    @RequestMapping("/selectNoticeByScenicName")
    public String selectNoticeByScenicName(String scenic_name,Model model){
        List<Notice> noticeList = noticeService.selectNoticeByScenicName(scenic_name);
        model.addAttribute("noticeList",noticeList);
        return "noticePersonalManagement";
    }

    @RequestMapping("/toAddNotice")
    public String deleteNotice(Model model){
        return "noticeAdd";
    }
    @RequestMapping("/addNotice")
    public String addNotice(Notice notice,Model model) throws ParseException {
        if (!"".equals(notice.getScenic_name())&&!"".equals(notice.getNotice_title())&&
                !"".equals(notice.getNotice_image())&&!"".equals(notice.getNotice_contents())) {
            notice.setNotice_image(saveFileName);
            notice.setNotice_addtime(new Time().Conversion(String.valueOf(new Date())));
            int num = noticeService.addNotice(notice);
            if (num>0) {
                System.out.println("发布成功");
                saveFileName="";
            }else {
                System.out.println("发布失败");
            }
        }
        return "noticePersonalManagement";
    }
    @RequestMapping("/deleteNotice")
    public String deleteNotice(int notice_id,Model model){
        noticeService.deleteNotice(notice_id);
        return "noticePersonalManagement";
    }

    @RequestMapping("/toUpdateNotice")
    public String toUpdateNotice(int notice_id,Model model){
        List<Notice> noticeList = noticeService.selectNoticeById(notice_id);
        model.addAttribute("noticeList",noticeList);
        return "noticeEdit";
    }
    @RequestMapping("/updateNotice")
    public String updateNotice(Notice notice,Model model) throws ParseException {
        if (!"".equals(notice.getScenic_name())&&!"".equals(notice.getNotice_title())&&
                !"".equals(notice.getNotice_contents())) {

            Notice notice_new = new Notice();
            notice_new.setScenic_name(notice.getScenic_name());
            notice_new.setNotice_title(notice.getNotice_title());
            if (Objects.equals(saveFileName, "")) {
                notice_new.setNotice_image(notice.getNotice_image());
            }else {
                notice_new.setNotice_image(saveFileName);
                saveFileName="";
            }
            notice_new.setNotice_contents(notice.getNotice_contents());
            notice_new.setNotice_addtime(new Time().Conversion(String.valueOf(new Date())));

            int num = noticeService.addNotice(notice_new);
            if (num > 0) {
                System.out.println("发布成功");
                noticeService.deleteNotice(notice.getNotice_id());
            } else {
                System.out.println("发布失败");
            }
        }
        return "noticeEdit";
    }

    @ResponseBody   //作用：将处理结果直接以JSON格式返回给前端客户端
    @RequestMapping("/ajaxImg")
    public Object ajaxImg(MultipartFile notice_image, HttpServletRequest request) {
        //提取生成文件名UUID+上传图片的后缀.jpg .png
        saveFileName = FileNameUtil.getUUIDFileName()+ FileNameUtil.getFileType(notice_image.getOriginalFilename());
        System.out.println(saveFileName+"111");
        //得到项目中图片存储的路径
        String path = request.getServletContext().getRealPath("/img");
        //转存
        try {
            notice_image.transferTo(new File(path+File.separator+saveFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //返回客户端JSON对象，封装图片的路径，为了在页面实现立即回显
        JSONObject object = new JSONObject();
        object.put("imgurl",saveFileName);
        return object.toString();
    }
}
