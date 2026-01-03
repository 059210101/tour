package com.example.service;

import com.example.dao.CommentsMapper;
import com.example.pojo.Comments;

import java.util.List;

public class CommentsServiceImpl implements CommentsService{
    private CommentsMapper commentsMapper;

    public void setCommentsMapper(CommentsMapper commentsMapper) {
        this.commentsMapper = commentsMapper;
    }

    @Override
    public List<Comments> selectCommentsAll(int essay_id) {
        return commentsMapper.selectCommentsAll(essay_id);
    }

    @Override
    public int addComments(Comments comments) {
        return commentsMapper.addComments(comments);
    }

    @Override
    public int deleteCommentsById(int comments_id) {
        return commentsMapper.deleteCommentsById(comments_id);
    }
}
