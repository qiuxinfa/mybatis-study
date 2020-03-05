package com.qxf.mapper;

import com.qxf.pojo.User;


/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/3
 * @Description: com.qxf.mapper
 */
public interface UserMapper {
    //根据id查询
    User getUserById(String id);
    //新增用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUserById(String id);
}
