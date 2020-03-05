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
public class SecondLevelCache {
    public static void main(String[] args) throws IOException {
        //读取配置信息
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置信息，创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSession工厂创建SqlSession
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println("----------第一次查询开始-----------");
        User user = mapper.getUserById("123");
        System.out.println(user);
        System.out.println("----------第一次查询结束-----------");
        //一定要先关闭第一个SqlSession，不然二级缓存不起作用，暂时也不知道为什么
        sqlSession.close();

        //第二个SqlSession
        SqlSession sqlSession2 = factory.openSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        System.out.println("----------第二次查询开始-----------");
        User user2 = mapper2.getUserById("123");
        System.out.println(user2);
        System.out.println("----------第二次查询结束-----------");

        sqlSession2.close();

    }
}
