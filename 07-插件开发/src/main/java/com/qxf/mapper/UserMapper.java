package com.qxf.mapper;

import com.qxf.pojo.MyPage;
import com.qxf.pojo.User;

import java.util.List;


/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/3
 * @Description: com.qxf.mapper
 */
public interface UserMapper {
    //分页查询
    List<User> getAllUserByPage(MyPage myPage);
}
