package com.qxf.pojo;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/4
 * @Description: com.qxf.pojo
 */
public class Blog {
    private String id;
    private String title;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
