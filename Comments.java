package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    /**
     * 评论的ID
     */
    private int comments_id;
    /**
     * 评论所属的文章的ID
     */
    private int essay_id;
    /**
     * 评论所属的用户的ID
     */
    private String user_name;
    /**
     * 表示评论的内容
     */
    private String comments_contents;
    /**
     * 表示评论的添加时间
     */
    private String comments_addtime;
}
