package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Essay {    //文章类
    /**
     * 文章id
     */
    private int essay_id;
    /**
     * 用户名
     */
    private String user_name;
    /**
     * 图片
     */
    private String essay_photo;
    /**
     * 文章标题
     */
    private String essay_title;
    /**
     * 文章内容
     */
    private String essay_contents;
    /**
     * 添加时间
     */
    private String essay_addtime;

}
