package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Comments;
import com.example.service.CommentsService;
import com.example.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    @Qualifier("CommentsServiceImpl")
    private CommentsService commentsService;

    @RequestMapping("/addComments")
    public String addComments(Comments comments) throws ParseException {
        if (!comments.getComments_contents().equals("")) {
            comments.setComments_addtime(new Time().Conversion(String.valueOf(new Date())));
            int i = commentsService.addComments(comments);
        }
        return "redirect:/essay/toEssayLookUserAction?essay_id="+comments.getEssay_id();
    }
    @RequestMapping("/deleteComments")
    public String deleteComments(int comments_id,int essay_id){
        commentsService.deleteCommentsById(comments_id);
        return "redirect:/essay/toEssayLookUserAction?essay_id="+essay_id;
    }
}
