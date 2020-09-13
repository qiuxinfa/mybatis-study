package com.qxf.pojo;

import java.io.Serializable;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/4
 * @Description: com.qxf.pojo
 */
public class Blog implements Serializable{
    private String id;
    private String title;
    private String userId;

    public Blog(){
        System.out.println("创建Blog对象....");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        System.out.println("设置Blog对象的id");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        System.out.println("设置Blog对象的title");
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        System.out.println("设置Blog对象的userId");
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
