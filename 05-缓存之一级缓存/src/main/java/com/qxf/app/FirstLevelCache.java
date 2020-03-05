package com.qxf.app;

import com.qxf.mapper.UserMapper;
import com.qxf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/5
 * @Description: com.qxf.app
 */
public class FirstLevelCache {
    public static void main(String[] args) throws IOException {
        //读取配置信息
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置信息，创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSession工厂创建SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取接口的代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //第二个会话，为了说明一级缓存是session级别的
        SqlSession sqlSession2 = factory.openSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        System.out.println("----------第一次查询开始-----------");
        User user = mapper.getUserById("123");
        System.out.println(user);
        System.out.println("----------第一次查询结束-----------");

        //1.执行了更新操作，会清除缓存
//        System.out.println("两次查询之间执行更新操作");
//        user.setUsername("张三2");
//        mapper.updateUser(user);
//        sqlSession.commit();

        //2.手动执行清除缓存操作
//        sqlSession.clearCache();

        //3.sqlSession关闭了，当然缓存也就没了
        System.out.println("----------第二次查询开始-----------");
        User user2 = mapper2.getUserById("123");
        System.out.println(user2);
        System.out.println("----------第二次查询结束-----------");
        sqlSession.close();

    }
}
