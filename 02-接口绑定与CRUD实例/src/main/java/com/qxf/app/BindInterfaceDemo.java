package com.qxf.app;

import com.qxf.mapper.UserMapper;
import com.qxf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/3
 * @Description: com.qxf.app
 */
public class BindInterfaceDemo {
    public static void main(String[] args) throws IOException{
        //读取配置信息
        InputStream  inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置信息，创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSession工厂创建SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行相应的接口方法
        //查找
//        User user = mapper.getUserById("123");
//        System.out.println(user);

        //新增
//        User u = new User();
//        u.setId(UUID.randomUUID().toString().replace("-",""));
//        u.setUsername("王五");
//        u.setPassword("123456");
//        u.setIsValid(1);
//        int cnt = mapper.addUser(u);

        //修改
//        User u2 = new User();
//        u2.setId("123");
//        u2.setUsername("修改后的姓名");
//        u2.setPassword("654321");
//        u2.setIsValid(0);
//        mapper.updateUser(u2);

        //删除
//        mapper.deleteUserById("123");

        //增删改，一定要提交事务，不然不起作用
        sqlSession.commit();

        //关闭连接
        sqlSession.close();
    }
}
