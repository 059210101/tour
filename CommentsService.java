package com.example.service;

import com.example.pojo.Comments;

import java.util.List;

public interface CommentsService {
    List<Comments> selectCommentsAll(int essay_id);
    int addComments(Comments comments);
    int deleteCommentsById(int comments_id);
}
