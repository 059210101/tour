package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {   //公告
    /**
     * 公告id
     */
    private int notice_id;
    /**
     * 景点名称
     */
    private String scenic_name;
    /**
     * 公告标题
     */
    private String notice_title;
    /**
     * 公告图片
     */
    private String notice_image;
    /**
     * 公告内容
     */
    private String notice_contents;
    /**
     * 公告添加时间
     */
    private String notice_addtime;

}
