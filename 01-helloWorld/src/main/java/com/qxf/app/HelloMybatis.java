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
        //读取配置信息
        InputStream  inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置信息，创建SqlSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSession工厂创建SqlSession
        SqlSession sqlSession = factory.openSession();
        //SqlSession进行数据库的CRUD操作
        //这里的selectOne是查询一个的意思，返回0个或1个对象
        User user = (User)sqlSession.selectOne("hello.mybatis.test.getUserById", "123");
        System.out.println(user);
        //关闭会话
        sqlSession.close();
    }
}
