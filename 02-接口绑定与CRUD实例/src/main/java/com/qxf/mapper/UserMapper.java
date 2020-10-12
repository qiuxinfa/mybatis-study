package com.qxf.mapper;

        import com.qxf.pojo.User;
        import org.apache.ibatis.annotations.Param;
        import org.apache.ibatis.annotations.Select;

        import java.util.List;


/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/3
 * @Description: com.qxf.mapper
 */
public interface UserMapper {
    int addBatch(List<User> list);
    //根据id查询
    User getUserById(String id);
    //新增用户
    int addUser(User user);
    //修改用户
    int updateUser(User user);
    //删除用户
    int deleteUserById(String id);

    @Select("select * from t_user where username=#{username}")
    User loadUserByUsername(String username);

    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
