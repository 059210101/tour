package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guestbook {    //留言类
    /**
     * 留言id
     */
    private int guestbook_id;
    /**
     * 留言人用户名
     */
    private String user_name;
    /**
     * 留言标题
     */
    private String guestbook_title;
    /**
     * 留言内容
     */
    private String guestbook_contents;
    /**
     * 留言添加时间
     */
    private String guestbook_addtime;
    /**
     * 留言状态判断
     */
    private int guestbook_state;

}
