package com.example.dao;

import com.example.pojo.Comments;

import java.util.List;

public interface CommentsMapper {
    List<Comments> selectCommentsAll(int essay_id);
    int addComments(Comments comments);
    int deleteCommentsById(int comments_id);
}
