package com.qxf.app;

import com.qxf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/3
 * @Description: com.qxf.app
 */
public class HelloMybatis {
    public static void main(String[] args) throws IOException{
        InputStream  inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        User user = (User)sqlSession.selectOne("hello.mybatis.test.getUserById", 123);
        System.out.println(user);
        sqlSession.close();
    }
}
