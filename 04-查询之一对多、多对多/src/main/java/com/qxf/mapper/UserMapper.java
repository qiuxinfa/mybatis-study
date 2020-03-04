package com.qxf.mapper;

import com.qxf.pojo.User;


/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/4
 * @Description: com.qxf.mapper
 */
public interface UserMapper {
    //根据id查询用户及其所有博客
    User getUserAndBlogByUserId(String id);
}
