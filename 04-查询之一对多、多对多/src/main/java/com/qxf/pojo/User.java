package com.qxf.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/3
 * @Description: com.qxf.pojo
 */
public class User implements Serializable{
    private String id;
    private String username;
    private String password;
    private Integer isValid;
    //一个用户，对应多篇博客
    private List<Blog> blogs;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isValid=" + isValid +
                ", blogs=" + blogs +
                '}';
    }
}
