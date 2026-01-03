package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scenic {   //景点类
    /**
     * 景点ID
     */
    private int scenic_id;
    /**
     * 景点名称
     */
    private String scenic_name;
    /**
     * 景点票价
     */
    private String scenic_price;
    /**
     * 景点联系方式
     */
    private String scenic_contact;
    /**
     * 景点地址
     */
    private String scenic_address;
    /**
     * 景点介绍
     */
    private String scenic_introduction;
    /**
     * 景点图片
     */
    private String scenic_photo;
    /**
     * 景点添加时间
     */
    private String scenic_addtime;
}
